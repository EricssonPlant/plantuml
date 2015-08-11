package org.xtext.plantuml.cdt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTEnumerationSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.IASTTypeId;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTDecltypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamespaceDefinition;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPNamespace;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.model.CModelException;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.model.CoreModelUtil;
import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.core.model.ICLanguageKeywords;
import org.eclipse.cdt.core.model.ICProject;
import org.eclipse.cdt.core.model.IInclude;
import org.eclipse.cdt.core.model.IParent;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.core.model.LanguageManager;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTNamespaceDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSimpleDeclaration;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTUsingDirective;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTVisibilityLabel;
import org.eclipse.cdt.internal.core.model.CProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

import net.sourceforge.plantuml.text.AbstractDiagramTextProvider;

// this is just some basic experimenting! see JavaEditorDiagramTextProvider for inspiration
// add this to net.sourceforge.plantuml.jdt - plugin.xml
public class CppEditorDiagramTextProvider extends AbstractDiagramTextProvider {

	private class Context {
		IEditorPart editorPart;
		IEditorInput editorInput;
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

	public List<IASTDeclaration> collectAllDeclarators(IASTTranslationUnit tu){
		final List<IASTDeclaration> declarations = new ArrayList<IASTDeclaration>();
		
		ASTVisitor visitor = new ASTVisitor(){
			{ shouldVisitDeclarations = true;
			  shouldVisitNamespaces = true;}
			
			@Override
			public int visit(IASTDeclaration declaration){
				String namespaceName = "";
				String ownerClass = "";
				ArrayList<String> namespaceNameList = new ArrayList();
				IASTNode node = (IASTNode) declaration;
				declarations.add(declaration);
				//System.out.println(declaration.toString());
				/*
			    System.out.println("......................");
			    System.out.println(declaration.getRawSignature());
			    System.out.println(declaration.getPropertyInParent());
			    System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
				*/
				
				if (declaration instanceof CPPASTSimpleDeclaration) {
			        IASTDeclSpecifier specifier = ((CPPASTSimpleDeclaration) declaration).getDeclSpecifier();
			        if(specifier instanceof CPPASTCompositeTypeSpecifier){
			        	System.out.println(node.getParent().getParent());
			        	while(node.getParent() != null){
			        		node = node.getParent();
			        		if(node instanceof ICPPASTNamespaceDefinition){
				        		namespaceNameList.add(((ICPPASTNamespaceDefinition) node).getName().toString());
				        	}
				        	
			        	}
			        	if(node.getParent() == null){
			        		//This loop will place the namespaceNames in the correct order so that that the actual full names are displayed in the graph
			        		for(int i=namespaceNameList.size()-1; -1<i; i--){
			        			System.out.println(namespaceNameList.get(i));
			        			namespaceName += namespaceNameList.get(i)+"::";
			        		}
			        	}
			        	CPPASTCompositeTypeSpecifier compositeSpecifier = (CPPASTCompositeTypeSpecifier)specifier;
			        	result.append("class " + namespaceName + ownerClass + compositeSpecifier.getName().toString() +"{\n}\n");
			        	//System.out.println("HERE -> "+ compositeSpecifier.getName().toString());
			        	ICPPASTCompositeTypeSpecifier.ICPPASTBaseSpecifier[] inheritance = compositeSpecifier.getBaseSpecifiers();
			        	for(int i=0; i<inheritance.length; i++){
			        		//System.out.println(inheritance[i].getNameSpecifier());
			        		result.append(inheritance[i].getNameSpecifier() + " <|.. " + namespaceName + ownerClass + compositeSpecifier.getName().toString() + "\n");
			        		
			        	}
			        	/*
			        	if(declaration.getPropertyInParent().equals(IASTCompositeTypeSpecifier.MEMBER_DECLARATION)){
			        		result.append("class "+ enumSpecifier.getName().toString() +"{\n}");
			        	}
			        	else if(!atLeastOneClass){
			        		atLeastOneClass = true;
			        		result.append("class "+ enumSpecifier.getName().toString() +"{\n");
			        	}
			        	else{
			        		result.append("class "+ enumSpecifier.getName().toString() +"}{\n");
			        	}
			        	*/
			        }
			    }
				return PROCESS_CONTINUE;
			}
			
			@Override
			public int visit(ICPPASTNamespaceDefinition namespaceDefinition){
			
				return PROCESS_CONTINUE;
				
			}
			
			
			
		};
		
		
		tu.accept(visitor);
		
		return declarations;
	}
	
	@Override
	protected String getDiagramText(IEditorPart editorPart, IEditorInput editorInput, ISelection selection) {
		result.setLength(0);
		// step 1: Check if this is a cpp file
		if (! (editorInput instanceof IFileEditorInput && ("h".equals(((IFileEditorInput) editorInput).getFile().getFileExtension()) 
		|| "cpp".equals(((IFileEditorInput) editorInput).getFile().getFileExtension())))) {
			result.append("C");
			return null;
		}
		// step 2: get file?
		IFile sourceFile = ((IFileEditorInput) editorInput).getFile();
		currentContext = new Context();
		
		IPath path = ((IFileEditorInput) editorInput).getFile().getFullPath();
		currentContext.project = ResourcesPlugin.getWorkspace().getRoot().getProject(path.segment(0));
		currentContext.iCProject = CoreModel.getDefault().create(currentContext.project);
		currentContext.translationUnit = CoreModelUtil.findTranslationUnit(currentContext.project.getFile(sourceFile.getProjectRelativePath()));
		/*
		try {
			ICElement[] icelements = currentContext.translationUnit.getChildren();
			System.out.println("-------------------");
			for(int i=0; i<icelements.length; i++){
				System.out.println(icelements[i]);
				System.out.println(icelements[i].getElementType());
				System.out.println(icelements[i].getPath());
				if(icelements[i].getElementType() == ICElement.C_INCLUDE){
					
				}
			}
			System.out.println("-------------------");
		} catch (CModelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		try {
			currentContext.translationUnit.open(new NullProgressMonitor());
			IIndex index= CCorePlugin.getIndexManager().getIndex(currentContext.iCProject);
			try {
				index.acquireReadLock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				IASTTranslationUnit iastTranslationUnit = currentContext.translationUnit.getAST(index, ITranslationUnit.AST_SKIP_ALL_HEADERS);
				List<IASTDeclaration> test = collectAllDeclarators(iastTranslationUnit);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				index.releaseReadLock();
				currentContext.iastTranslationUnit = null;
			}
			
			/*
			for (IType type: currentContext.translationUnit.getTypes()) {
				generateForType(type, result, GEN_MEMBERS | GEN_MODIFIERS | GEN_EXTENDS | GEN_IMPLEMENTS, null);
			}
			*/
		} catch (CoreException e) {
			System.err.println(e);
		} finally {
			currentContext = null;
		}
		return result.toString();
	}
	/*
	public List<IASTName> collectAllNames(IASTTranslationUnit tu){
		final List<IASTName> names = new ArrayList<IASTName>();
		
		ASTVisitor visitor = new ASTVisitor(){
			{ shouldVisitNames = true; }
			
			@Override
			public int visit(IASTName name){
				names.add(name);
				return PROCESS_CONTINUE;
			}
		};
		
		tu.accept(visitor);
		
		return names;
	}
	*/
}