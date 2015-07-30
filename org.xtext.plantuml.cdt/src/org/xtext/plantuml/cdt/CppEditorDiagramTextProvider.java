package org.xtext.plantuml.cdt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

import net.sourceforge.plantuml.text.AbstractDiagramTextProvider;

// this is just some basic experimenting! see JavaEditorDiagramTextProvider for inspiration
// add this to net.sourceforge.plantuml.jdt - plugin.xml
public class CppEditorDiagramTextProvider extends AbstractDiagramTextProvider {

	
	public boolean supportsSelection(ISelection selection) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// taken from JavaEditorDiagramTextProvider while experimenting!!!
	private class Context {
		IEditorPart editorPart;
		IEditorInput editorInput;
		IProject project;
		//IJavaProject javaProject;
		ICompilationUnit compUnit;
	}
	
	private Context currentContext = null;

	@Override
	protected String getDiagramText(IEditorPart editorPart, IEditorInput editorInput, ISelection selection) {
		
		// step 1: Check if this is a cpp file
		if (! (editorInput instanceof IFileEditorInput && "cpp".equals(((IFileEditorInput) editorInput).getFile().getFileExtension()))) {
			return null;
		}
		
		// step 2: get file?
		currentContext = new Context();
		IPath path = ((IFileEditorInput) editorInput).getFile().getFullPath();
		
		currentContext.project = ResourcesPlugin.getWorkspace().getRoot().getProject(path.segment(0));
		//System.out.println("3. currentContext.project= "+currentContext.project);
		
		//currentContext.javaProject = JavaCore.create(currentContext.project);
		//System.out.println("4. currentContext.javaProject= "+currentContext.javaProject);
		
		currentContext.compUnit = JavaCore.createCompilationUnitFrom(currentContext.project.getFile(path.removeFirstSegments(1)));
		//System.out.println("5. currentContext.compUnit= "+currentContext.compUnit);
		
		StringBuilder result = new StringBuilder();
		result.append("class test3 {\n}");
		return result.toString();
	}
	

}
