package org.xtext.plantuml.cdt;


import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamespaceDefinition;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.model.CoreModelUtil;
import org.eclipse.cdt.core.model.ICProject;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSimpleDeclaration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

import net.sourceforge.plantuml.text.AbstractDiagramTextProvider;

// this is just some basic experimenting! see JavaEditorDiagramTextProvider for inspiration
// add this to net.sourceforge.plantuml.jdt - plugin.xml
public class CppEditorDiagramTextProvider extends AbstractDiagramTextProvider {

	private class Context {
		IProject project;
		ICProject iCProject;
		ITranslationUnit translationUnit;
		IASTTranslationUnit iastTranslationUnit;
	}
	
	private Context currentContext = null;
	StringBuilder result = new StringBuilder();
	//String namespaceName = "";
	public boolean supportsSelection(ISelection selection) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public StringBuilder getNamespacesAndClasses(IASTNode parentTraversalNode){
		StringBuilder namespaceName = new StringBuilder();
		StringBuilder ownerClassName = new StringBuilder();
		while(parentTraversalNode.getParent() != null){
    		parentTraversalNode = parentTraversalNode.getParent();
    		if(parentTraversalNode instanceof ICPPASTNamespaceDefinition){
        		namespaceName.insert(0, ((ICPPASTNamespaceDefinition) parentTraversalNode).getName().toString()+"::");
        	}
    		else if(parentTraversalNode instanceof CPPASTCompositeTypeSpecifier){
    			ownerClassName.insert(0, ((CPPASTCompositeTypeSpecifier) parentTraversalNode).getName().toString()+"::");
    		}
    	}
		return namespaceName.append(ownerClassName);
	}
	
	public void collectAllDeclarators(IASTTranslationUnit tu){
		ASTVisitor visitor = new ASTVisitor(){
			{ shouldVisitDeclarations = true;}
			
			@Override
			public int visit(IASTDeclaration declaration){
				
				//This if-statement makes sure that only the declarations that contain classes will be searhed.
				if (declaration instanceof CPPASTSimpleDeclaration) {
			        IASTDeclSpecifier specifier = ((CPPASTSimpleDeclaration) declaration).getDeclSpecifier();
			        if(specifier instanceof CPPASTCompositeTypeSpecifier){
			        	//This if-statement makes sure that owner classes and namespaces corresponding the the displayed class will be shown in the diagram.
			        	
			        	CPPASTCompositeTypeSpecifier compositeSpecifier = (CPPASTCompositeTypeSpecifier)specifier;
			        	result.append("class " + getNamespacesAndClasses((IASTNode) declaration) + compositeSpecifier.getName().toString() +"{\n}\n");
			        	//System.out.println("HERE -> "+ compositeSpecifier.getName().toString());
			        	ICPPASTCompositeTypeSpecifier.ICPPASTBaseSpecifier[] inheritance = compositeSpecifier.getBaseSpecifiers();
			        	for(int i=0; i<inheritance.length; i++){
			        		//System.out.println(inheritance[i].getNameSpecifier());
			        		IASTNode parentTraversalNode = inheritance[i].getNameSpecifier();
			        		while(parentTraversalNode.getParent() != null){
			        			parentTraversalNode = parentTraversalNode.getParent();
			        			System.out.println(parentTraversalNode.getRawSignature());
			        			System.out.println("-----------------------------------");
			        		}
			        		result.append(inheritance[i].getNameSpecifier() + " <|.. " + getNamespacesAndClasses((IASTNode) declaration) + compositeSpecifier.getName().toString() + "\n");
			        		
			        	}
			        }
			    }
				return PROCESS_CONTINUE;
			}
		};
		
		
		tu.accept(visitor);
		
	}
	
	@Override
	protected String getDiagramText(IEditorPart editorPart, IEditorInput editorInput, ISelection selection) {
		result.setLength(0);
		// step 1: Check if this is a cpp file
		if (! (editorInput instanceof IFileEditorInput && ("h".equals(((IFileEditorInput) editorInput).getFile().getFileExtension()) 
		|| "cpp".equals(((IFileEditorInput) editorInput).getFile().getFileExtension())))) {
			return null;
		}
		// step 2: get file?
		IFile sourceFile = ((IFileEditorInput) editorInput).getFile();
		currentContext = new Context();
		
		IPath path = ((IFileEditorInput) editorInput).getFile().getFullPath();
		currentContext.project = ResourcesPlugin.getWorkspace().getRoot().getProject(path.segment(0));
		currentContext.iCProject = CoreModel.getDefault().create(currentContext.project);
		currentContext.translationUnit = CoreModelUtil.findTranslationUnit(currentContext.project.getFile(sourceFile.getProjectRelativePath()));
		
		try {
			IIndex index= CCorePlugin.getIndexManager().getIndex(currentContext.iCProject);
			try {
				index.acquireReadLock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				currentContext.iastTranslationUnit = currentContext.translationUnit.getAST(index, ITranslationUnit.AST_SKIP_ALL_HEADERS);
				collectAllDeclarators(currentContext.iastTranslationUnit);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				index.releaseReadLock();
				currentContext.iastTranslationUnit = null;
			}
		} catch (CoreException e) {
			System.err.println(e);
		} finally {
			currentContext = null;
		}
		if("cpp".equals(((IFileEditorInput) editorInput).getFile().getFileExtension())){
			return "\nLegend left \nDiagrams will only be displayed for .h files. \nendlegend \n@enduml";
		}
		return result.toString();
	}
}