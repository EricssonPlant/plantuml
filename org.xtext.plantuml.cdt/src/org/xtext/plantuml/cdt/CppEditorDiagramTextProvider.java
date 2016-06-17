package org.xtext.plantuml.cdt;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamespaceDefinition;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTVisibilityLabel;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.model.CoreModelUtil;
import org.eclipse.cdt.core.model.ICProject;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.internal.core.dom.parser.cpp.*;
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

import net.sourceforge.plantuml.eclipse.utils.ValueHolder;
import net.sourceforge.plantuml.text.AbstractDiagramTextProvider;

// See JavaEditorDiagramTextProvider for inspiration
public class CppEditorDiagramTextProvider extends AbstractDiagramTextProvider {

	private class Context {
		IProject project;
		ICProject iCProject;
		ITranslationUnit translationUnit;
		IASTTranslationUnit iastTranslationUnit;
	}
	
	private Context currentContext = null;
	StringBuilder result = new StringBuilder();
	public boolean supportsSelection(ISelection selection) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// This method will get the owner classes for a class and the namespaces this class may reside in
	public StringBuilder getNamespacesAndClasses(IASTNode parentTraversalNode){
		StringBuilder namespaceName = new StringBuilder();
		StringBuilder ownerClassName = new StringBuilder();
		// This loop traverses the parents of the parameter node while gathering information about the names of the
		// namespaces and owner classes.
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
	// This method is called when the method getDiagramText is run. It will make sure that the nodes of the AST that are 
	// considered declarations are visited.
	public void collectAllDeclarators(IASTTranslationUnit tu){
		ASTVisitor visitor = new ASTVisitor(){
			{ shouldVisitDeclarations = true;}
			
			int count = 0; // just used for debugging!
			
			// 
			private int visibility_level = 1; 
			
			@Override
			public int visit(IASTDeclaration declaration){
				//This if-statement makes sure that 'declaration' is of the type CPPASTSimpleDeclaration 
				//so that it's safe to temporarily cast it to that type because not all declarations are of this type.
				//Declarations are of interest since the name of declared classes are to be fetched.

				count++;
				if (declaration instanceof CPPASTSimpleDeclaration) {
			        IASTDeclSpecifier specifier = ((CPPASTSimpleDeclaration) declaration).getDeclSpecifier();
			        
			        // If specifier is an instance of CPPASTCompositeTypeSpecifier, the node in the AST might be a class and can have 
			        // its name printed in the diagram.
			        if(specifier instanceof CPPASTCompositeTypeSpecifier){

			        	CPPASTCompositeTypeSpecifier compositeSpecifier = (CPPASTCompositeTypeSpecifier)specifier;
			        	result.append("class " + getNamespacesAndClasses((IASTNode) declaration) + compositeSpecifier.getName().toString() +"{\n");
			        	
			        	//TODO recursivly search for info to implement in UML class
			        	IASTNode[] children = ((IASTNode) declaration).getChildren();
			        	result.append(genFunctions(children,"R",0));
			        	//-------------------------------------------------------------------
			        	
			        	result.append("}\n");
			        	// The method GetBaseSpecifiers() returns the classes that the class in the current node inherits from.
			        	ICPPASTCompositeTypeSpecifier.ICPPASTBaseSpecifier[] inheritance = compositeSpecifier.getBaseSpecifiers();
			        	// This for loop will print the inherited class and the inheritor showing their relationship in the diagram
			        	for(int i=0; i<inheritance.length; i++){
			        		result.append(inheritance[i].getNameSpecifier() + " <|.. " + getNamespacesAndClasses((IASTNode) declaration) + compositeSpecifier.getName().toString() + "\n");
			        	}
			        	System.out.println("count = " + count);
			        	//Experiment, should reduce the amout of work
			        	return PROCESS_SKIP; 
			        }
			    }
				// This return value indicates that it's ok to traverse the children nodes.
				
				System.out.println("count = " + count);
				return PROCESS_CONTINUE;
			}
			
			private String genFunctions(IASTNode[] iastNodes,String str,int level) {
				StringBuilder result = new StringBuilder();
				int count = 0;
				for(IASTNode node : iastNodes){
					count++;
					result.append(genFunction(node,str+count, level));
				}
				return result.toString();
			}
			private String genFunction(IASTNode node,String str,int level) {
				System.out.println("--------------");
				System.out.println(str + " - " + node.getClass().getSimpleName() +" ["+node.getRawSignature()+"]");
					
				IASTNode[] children = node.getChildren();
					
				if(node instanceof CPPASTCompositeTypeSpecifier){ // the whole class
						
				}else if(node instanceof CPPASTName){ // just classname???
						
				}else if(node instanceof CPPASTVisibilityLabel){ // public: + / package private: ~ / protected: # / Private: -
					visibility_level = ((CPPASTVisibilityLabel)node).getVisibility();
				}else if(node instanceof CPPASTFunctionDefinition){ // e.g. virtual ~IDemo() {}
						
				}else if(node instanceof CPPASTSimpleDeclSpecifier){ // virtual
					
				}else if(node instanceof CPPASTFunctionDeclarator){ // ~IDemo()
					// get the name of the function
					String func_name = ((CPPASTFunctionDeclarator)node).getName().toString();
					// chose symbol for visibility level... //TODO implement which to show, e.g && show_private
					if(visibility_level == ICPPASTVisibilityLabel.v_public){ //TODO add AND show public?????
						return "+"+func_name+"()\n";
					}
					if(visibility_level == ICPPASTVisibilityLabel.v_protected && ValueHolder.INSTANCE.getShowProtected()) {
						return "#"+func_name+"()\n";
					}
					if(visibility_level == ICPPASTVisibilityLabel.v_private && ValueHolder.INSTANCE.getShowPrivate()) {
						return "-"+func_name+"()\n";
					}
					
				}
				return genFunctions(children, str, level+1);
			}
		};
		
		
		tu.accept(visitor);
		
	}
	
	// This method provides the diagram text that is to be displayed in the Plantuml diagram.
	@Override
	protected String getDiagramText(IEditorPart editorPart, IEditorInput editorInput, ISelection selection) {
		result.setLength(0);
		// Checks if this is a '.h' file.
		if (! (editorInput instanceof IFileEditorInput && ("h".equals(((IFileEditorInput) editorInput).getFile().getFileExtension()) 
		|| "cpp".equals(((IFileEditorInput) editorInput).getFile().getFileExtension())))) {
			return null;
		}
		// Gets file
		IFile sourceFile = ((IFileEditorInput) editorInput).getFile();
		currentContext = new Context();
		
		IPath path = ((IFileEditorInput) editorInput).getFile().getFullPath();
		currentContext.project = ResourcesPlugin.getWorkspace().getRoot().getProject(path.segment(0));
		currentContext.iCProject = CoreModel.getDefault().create(currentContext.project);
		currentContext.translationUnit = CoreModelUtil.findTranslationUnit(currentContext.project.getFile(sourceFile.getProjectRelativePath()));
		
		try {
			// Using the indexed AST means we can use the setting AST_SKIP_ALL_HEADERS to not have included '.h' files in our created AST
			IIndex index= CCorePlugin.getIndexManager().getIndex(currentContext.iCProject);
			try {
				// The AST is created based on the translation unit.
				// When using an indexed AST it is recommended to acquire the ReadLock before doing something to the tree.
				// I'm not sure of how relevant it is for our scenario but I did it anyway just to be on the safe side.
				index.acquireReadLock();
				currentContext.iastTranslationUnit = currentContext.translationUnit.getAST(index, ITranslationUnit.AST_SKIP_ALL_HEADERS);
				collectAllDeclarators(currentContext.iastTranslationUnit);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// When done using the AST, the ReadLock should be released
				index.releaseReadLock();
				currentContext.iastTranslationUnit = null;
			}
		} catch (CoreException e) {
			System.err.println(e);
		} finally {
			// Resetting the context
			currentContext = null;
		}
		// If the file being shown in the editor is a '.cpp' file, this message will be displayed in the plantuml diagram 
		// to alert the user about the lack of support for '.cpp' files.
		/*if("cpp".equals(((IFileEditorInput) editorInput).getFile().getFileExtension())){
			return "\nLegend left \nDiagrams will only be displayed for '.h' files. \nendlegend \n@enduml";
		}*/
		return result.toString();
	}
}