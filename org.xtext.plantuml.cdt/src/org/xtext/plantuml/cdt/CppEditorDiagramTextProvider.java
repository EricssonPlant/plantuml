package org.xtext.plantuml.cdt;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

import javax.xml.transform.Source;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorIncludeStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit.IDependencyTree.IASTInclusionNode;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamespaceDefinition;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTVisibilityLabel;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.model.CoreModelUtil;
import org.eclipse.cdt.core.model.ICProject;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.internal.core.dom.parser.ASTNode;
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
	HashSet<String> fileNamesOfNodesToBeShown = new HashSet<String>();
	
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
	
	private String getFileNameOfNode(IASTNode node){
		String fullPath = node.getContainingFilename();
		int index = fullPath.lastIndexOf(File.separator);
		String fileName = fullPath.substring(index + 1);
		return fileName;
	}
	
	private boolean isNodeToBeShown(ASTNode node){
		return fileNamesOfNodesToBeShown.contains(getFileNameOfNode(node));
	
	}
	
	public void setFilesOfPreprocessorIncludeDirectiveNodesToBeShown(IASTInclusionNode[] inclusionNodes, int depthCount){
		//The if-statement makes sure that this recursive function will stop within the boundary of the depth setting's value
		if(ValueHolder.INSTANCE.getDepthSettingForHFileClasses() > depthCount){
			for (IASTInclusionNode inclusionNode : inclusionNodes){
				// Every inclusion node contains one include directive
				IASTPreprocessorIncludeStatement preprocessorIncludeDirective = inclusionNode.getIncludeDirective();
				// If the inclusion node has an include directive that is a system include, 
				// it is to be skipped because library includes aren't supposed to show up in the class diagram
				if(!preprocessorIncludeDirective.isSystemInclude()){
					Path path = Paths.get(preprocessorIncludeDirective.getPath());
					String fileName = path.getFileName().toString();
					// The file name in the include directive is added to the list of file names that is used to determine which nodes are allowed to be shown
					fileNamesOfNodesToBeShown.add(fileName);
					depthCount++;
					// A recursive function call to visit the inclusion nodes of inclusion nodes as far as the depth setting allows
					setFilesOfPreprocessorIncludeDirectiveNodesToBeShown(inclusionNode.getNestedInclusions(), depthCount);
					
				}
			}
		}
	}
	
	// This method is called when the method getDiagramText is run. It will make sure that the nodes of the AST that are 
	// considered declarations are visited.
	public void collectAllDeclarators(IASTTranslationUnit tu, StringBuilder result){
		IASTInclusionNode[] inclusionNodes = tu.getDependencyTree().getInclusions();
		int depthCount=0;
		setFilesOfPreprocessorIncludeDirectiveNodesToBeShown(inclusionNodes, depthCount);
		System.out.print(((IASTNode)tu).getRawSignature()); // prints the whole code for debugging
		ASTVisitor visitor = new ASTVisitor(){
			{ shouldVisitDeclarations = true;}
			// Setts base visibility to Public
			private int visibility_level = 1; 
			
			@Override
			public int visit(IASTDeclaration declaration){
				if(isNodeToBeShown((ASTNode) declaration)){
					IASTNode[] children = ((IASTNode) declaration).getChildren();
				    genCode(children, result);
				}
				return PROCESS_SKIP; 
			}
			
			
			//Part of the recursion 
			private void genCode(IASTNode[] iastNodes, StringBuilder result) {
				int count = 0;
				for(IASTNode node : iastNodes){
					count++;
					genCode(node, result);
				}
			}
			
			// Checks for nodes where UML code should be generated
			private void genCode(IASTNode node, StringBuilder result) {
				IASTNode[] children = node.getChildren();
				
				if(node instanceof CPPASTCompositeTypeSpecifier){ 
					// class or global struct
					if(((CPPASTCompositeTypeSpecifier) node).getParent() instanceof CPPASTCompositeTypeSpecifier){
						//This struct or class is nested/local
						//System.out.println("- nested class or local struct");
					}else{
						createClassCode(node, result, false);
					}
						
				}else if(node instanceof CPPASTEnumerationSpecifier){
					//System.out.println("In a Enumerator 1 = "+ ((CPPASTEnumerationSpecifier)node).getName());
					createEnumCode(node, result);
					//TODO acc functionality for contetnt of enums!!!!
					
				}else if(node instanceof CPPASTVisibilityLabel){ // public: + / package private: ~ / protected: # / Private: -
					visibility_level = ((CPPASTVisibilityLabel)node).getVisibility();
				}else if(node instanceof CPPASTSimpleDeclaration){ 
					
					if(node instanceof CPPASTCompositeTypeSpecifier){ //local struct of nested class
						//System.out.println("- nested class or local struct");
					}else if(node instanceof CPPASTEnumerationSpecifier){ //local or global enumerator
						//System.out.println("- local enum");
						System.out.println("In a Enumerator 2");
						
					}else{
						//System.out.println("- local variable");
						createVariableCode(node, result);
					}

				}else if(node instanceof CPPASTFunctionDefinition){
					genCode(node.getChildren(),result);
				}else if(node instanceof CPPASTFunctionDeclarator){ 
					createFunctionCode(node,result);
				}else if(node instanceof CPPASTDeclarator){
					//TODO what is this????????
				}
			}
			
			private void createEnumCode(IASTNode node, StringBuilder result){
				createClassCode(node, result, true);
			}
			
			private void createClassCode(IASTNode node, StringBuilder result, boolean isEnum){
				//1. is this a class or struct or enum??
				String type = "class";
				if(isEnum){type = "enum";}
				print(type,result);
				print(" ",result);
				
				//2. get the name
				String file = new File(node.getContainingFilename()).getName();
				String name = (isEnum ? ((CPPASTEnumerationSpecifier)node).getName().toString() : ((CPPASTCompositeTypeSpecifier) node).getName().toString());
				if(name.equals("")){name = ".";} // needed for empty names of enumerators
				print(file,result);
				print(".",result); // normaly for namespace but we use it for separating classes into files
				print(name,result);
				if(node instanceof CPPASTCompositeTypeSpecifier && ((CPPASTCompositeTypeSpecifier) node).getKey() == CPPASTCompositeTypeSpecifier.k_struct){
					print(" <<(S,#FF7700)>>",result);
				}
				
				//3. Create the body
				print(" {\n",result);
				genCode(node.getChildren(), result);
				print("\n}\n",result);
				
				
				if(!isEnum){
					//4. get inheritance
		        	ICPPASTCompositeTypeSpecifier.ICPPASTBaseSpecifier[] inheritance = ((CPPASTCompositeTypeSpecifier) node).getBaseSpecifiers(); // The method GetBaseSpecifiers() returns the classes that the class in the current node inherits from.
		        	for(int i=0; i<inheritance.length; i++){ // This for loop will print the inherited class and the inheritor showing their relationship in the diagram
		        		String fileTo = new File(inheritance[i].getContainingFilename()).getName();
		        		//String fileTo2 = new File(inheritance[i].get).getName().split("\\.")[0];
		        		//TODO this gives the wrongtrans filename
		        		//System.out.println(inheritance[i].getNameSpecifier().);
		        		String nameTo = inheritance[i].getNameSpecifier().toString();
		        		print(fileTo, result);
		        		print(".",result);
		        		print(nameTo, result);
		        		print(" <|.. ", result);
		        		print(file, result);
		        		print(".",result);
		        		print(name, result); //TODO add "getNamespacesAndClasses((IASTNode) declaration) +" before
		        		print("\n",result);
		        	}
				}
			}


			private void createVariableCode(IASTNode node, StringBuilder result) {
				// generates all PlantUml code for variable declaration
				IASTDeclSpecifier spec = ((CPPASTSimpleDeclaration) node).getDeclSpecifier(); // Declaration "type" e.g. int/double/char
				IASTDeclarator[] decs = ((CPPASTSimpleDeclaration) node).getDeclarators(); // variable name / list since many can be declared at once
				
				if(node.getRawSignature().contains("(")){
					genCode(node.getChildren(),result);
					// already handled by createFunctionCode(node)
				}else if(false){ //TODO find a way to skip global variables
					
				}else{
					for(IASTDeclarator dec : decs){
						String name = spec + " " + dec.getName().toString();
						if(visibility_level == ICPPASTVisibilityLabel.v_public){ //TODO add AND show public?????
							print("+"+name+"\n", result);
						}
						if(visibility_level == ICPPASTVisibilityLabel.v_protected && ValueHolder.INSTANCE.getShowProtected()) {
							print("#"+name+"\n",result);
						}
						if(visibility_level == ICPPASTVisibilityLabel.v_private && ValueHolder.INSTANCE.getShowPrivate()) {
							print("-"+name+"\n",result);
						}
					}
				}
			}
			
			private void print(String str, StringBuilder result){
				System.out.print(str);
				result.append(str);
			}


			// Function that generates the plantUml code for a function declaration !!!!!
			private void createFunctionCode(IASTNode node, StringBuilder result) {
				// generates all PlanUML code for function declarations 
				// 1. Get return type
				String ret_type = "";
				IASTNode[] siblings = node.getParent().getChildren();
				if(siblings[0] instanceof CPPASTSimpleDeclSpecifier){
					ret_type = siblings[0].getRawSignature().replace("virtual","").trim() + " ";
					//ret_type = siblings[0].getRawSignature() + " "; // if you want "virtual" included
				}
				
				//2. get the name of the function
				String func_name = ((CPPASTFunctionDeclarator)node).getName().toString();
				// chose symbol for visibility level... //TODO implement which to show, e.g && show_private
				
				// 3. Get function Parameters
				String parameters = "";
				for(ICPPASTParameterDeclaration par : ((CPPASTFunctionDeclarator)node).getParameters()){
					parameters = (parameters == "" ? "" : parameters+", ") + par.getRawSignature();
				}
				
				// 4. create function declaration string
				String func_string = ret_type+func_name+" ("+parameters+")";
				
				// 5. Create and return string based on visibility
				if(visibility_level == ICPPASTVisibilityLabel.v_public){ //TODO add AND show public?????
					print("+"+func_string+"\n",result);
				}
				if(visibility_level == ICPPASTVisibilityLabel.v_protected && ValueHolder.INSTANCE.getShowProtected()) {
					print("#"+func_string+"\n",result);
				}
				if(visibility_level == ICPPASTVisibilityLabel.v_private && ValueHolder.INSTANCE.getShowPrivate()) {
					print("-"+func_string+"\n",result);
				}
			}
		};
		
		
		tu.accept(visitor);
		
	}
	
	
	// This method provides the diagram text that is to be displayed in the Plantuml diagram.
	// Called by plugin.
	@Override
	protected String getDiagramText(IEditorPart editorPart, IEditorInput editorInput, ISelection selection) {
		StringBuilder result = new StringBuilder();
		int depthSetting = ValueHolder.INSTANCE.getDepthSettingForHFileClasses();
		IFile sourceFile = ((IFileEditorInput) editorInput).getFile();
		if(depthSetting == 1)
			result.append("title " + sourceFile.getName() + ": Up to " + depthSetting + " layer of h-file classes are currently being shown \n");
		else
			result.append("title " + sourceFile.getName() + ": Up to " + depthSetting + " layers of h-file classes are currently being shown \n");
		// Checks if this is a '.h' file.
		if (! (editorInput instanceof IFileEditorInput && ("h".equals(((IFileEditorInput) editorInput).getFile().getFileExtension()) 
		|| "cpp".equals(((IFileEditorInput) editorInput).getFile().getFileExtension())))) {
			return null;
		}
		// Gets file
		currentContext = new Context();
		
		IPath path = ((IFileEditorInput) editorInput).getFile().getFullPath();
		currentContext.project = ResourcesPlugin.getWorkspace().getRoot().getProject(path.segment(0));
		currentContext.iCProject = CoreModel.getDefault().create(currentContext.project);
		currentContext.translationUnit = CoreModelUtil.findTranslationUnit(currentContext.project.getFile(sourceFile.getProjectRelativePath()));
		
		
		// for dividing classes into files!
		//result.append("set namespaceSeparator :: \n");
		try {
			// Using the indexed AST means we can use the setting AST_SKIP_ALL_HEADERS to not have included '.h' files in our created AST
			IIndex index= CCorePlugin.getIndexManager().getIndex(currentContext.iCProject);
			try {
				// The AST is created based on the translation unit.
				// When using an indexed AST it is recommended to acquire the ReadLock before doing something to the tree.
				// I'm not sure of how relevant it is for our scenario but I did it anyway just to be on the safe side.
				index.acquireReadLock();
				fileNamesOfNodesToBeShown.clear();
				if(!sourceFile.getFileExtension().equals("cpp"))
					fileNamesOfNodesToBeShown.add(sourceFile.getName());
				currentContext.iastTranslationUnit = currentContext.translationUnit.getAST(index, 0);
				collectAllDeclarators(currentContext.iastTranslationUnit, result);
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
		return (result.length() > 0 ? result.toString() : null);
	}
}