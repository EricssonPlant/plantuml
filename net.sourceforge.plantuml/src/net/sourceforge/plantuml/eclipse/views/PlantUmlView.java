package net.sourceforge.plantuml.eclipse.views;

import net.sourceforge.plantuml.eclipse.actions.GenerateAction;
import net.sourceforge.plantuml.eclipse.actions.ToggleButtonAction;
import net.sourceforge.plantuml.eclipse.utils.PlantUmlUtils;
import net.sourceforge.plantuml.eclipse.utils.PlantumlConstants;
import net.sourceforge.plantuml.eclipse.utils.ValueHolder;

import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;

/**
 * 
 * The view permit to generate image diagram of UML modelisation.
 * <P>
 * To launch this view, go to Windows > Show View > Other... > PlantUml >
 * PlantUml. <BR>
 * To use it, it's very easy. you put your text describing the diagram in your
 * file (*.java, *.txt, ...) and you click in the text and automatically, the
 * UML diagram will be generated in the view.
 * <P>
 * To use the image you have the following functionalities on the right-click :
 * <BR>- Copy the image in the buffer. <BR>- Export the image has a file (to
 * be implement). <BR>- Print the image (to be implement).
 * 
 * @author durif_c
 */

public class PlantUmlView extends AbstractDiagramSourceView {
	
	private boolean toggleMenuCreated=false;
	private SWTImageCanvas canvas;
	/**
	 * The action which manage the image generation.
	 */
	private GenerateAction generateAction;

	private Action zoomInAction;
	private Action zoomOutAction;
	private Action fitCanvasAction;
	private Action showOriginalAction;
	private Action toggleAction;
	private Action toggleVisibility;
	private Action reduceDepth;
	private Action increaseDepth;
	/**
	 * The default constructor.
	 */
	public PlantUmlView() {
		super();
	}
	
	/**
	 * Method in which we construct the view and it contents
	 * 
	 * @author durif_c
	 */
	public void createPartControl(Composite parent) {
		// Display of the view.
		canvas = new SWTImageCanvas(parent);

		// Manage actions
		makeActions(parent.getDisplay());

		// add PlantUmlView in the listener list of the active page to get event
		// of updates.
		contributeToActionBars();

		super.createPartControl(parent);
	}

	final PlantUmlView puv = this; // To get accsess to this object in run of action for toggleVisibility
	
	/**
	 * Manage the actions.
	 * 
	 * @author durif_c
	 * @param display
	 */
	private void makeActions(Display display) {
		generateAction = new GenerateAction(canvas);

		zoomInAction = new Action() {
			public void run() {
				canvas.zoomIn();
			}
		};
		zoomInAction.setToolTipText(PlantumlConstants.ZOOM_IN_BUTTON);
		zoomInAction.setImageDescriptor(PlantUmlUtils.getImageDescriptor(
				display, "/icons/ZoomIn16.gif"));

		zoomOutAction = new Action() {
			public void run() {
				canvas.zoomOut();
			}
		};
		zoomOutAction.setToolTipText(PlantumlConstants.ZOOM_OUT_BUTTON);
		zoomOutAction.setImageDescriptor(PlantUmlUtils.getImageDescriptor(
				display, "/icons/ZoomOut16.gif"));

		fitCanvasAction = new Action() {
			public void run() {
				canvas.fitCanvas();
			}
		};
		fitCanvasAction.setToolTipText(PlantumlConstants.FIT_CANVAS_BUTTON);
		fitCanvasAction.setImageDescriptor(PlantUmlUtils.getImageDescriptor(
				display, "/icons/Fit16.gif"));

		showOriginalAction = new Action() {
			public void run() {
				canvas.showOriginal();
			}
		};
		showOriginalAction
				.setToolTipText(PlantumlConstants.SHOW_ORIGINAL_BUTTON);
		showOriginalAction.setImageDescriptor(PlantUmlUtils.getImageDescriptor(
				display, "/icons/Original16.gif"));
		
		
		final PlantUmlView puv = this; // To get access to this object in run of action for toggleVisibility
		
		toggleVisibility = new Action(){
			@Override
			public void run(){
				//ValueHolder.INSTANCE.toggleVisibility();
				
				Display display = Display.getDefault();
				
				
				if(!toggleMenuCreated){
					Shell shell = new Shell(display, SWT.CLOSE | SWT.TITLE);
					toggleMenuCreated = true;
					FillLayout fillLayout = new FillLayout();
					fillLayout.type = SWT.VERTICAL;
					shell.setLayout(fillLayout);
					
					//Adds the buttons along with a listener
					Button showStructButton = new Button(shell, SWT.CHECK);
					addShowButtonListenerAndText(showStructButton, "Show struct");
					setCheckedButton(showStructButton, ValueHolder.INSTANCE.getShowStruct()); 
					//Selects a checkbox immediately when the window is opened 
					// if the checkbox has been selected in a previously opened window
					
					Button showEnumButton = new Button(shell, SWT.CHECK);
					addShowButtonListenerAndText(showEnumButton, "Show enum");
					setCheckedButton(showEnumButton, ValueHolder.INSTANCE.getShowEnum());
					
					Button showProtectedButton = new Button(shell, SWT.CHECK);
					addShowButtonListenerAndText(showProtectedButton, "Show protected");
					setCheckedButton(showProtectedButton, ValueHolder.INSTANCE.getShowProtected());
					
					Button showPrivateButton = new Button(shell, SWT.CHECK);
					addShowButtonListenerAndText(showPrivateButton, "Show private");
					setCheckedButton(showPrivateButton, ValueHolder.INSTANCE.getShowPrivate());
					
					Button okShowButton = new Button(shell, SWT.PUSH);
					addShowButtonListenerAndText(okShowButton, "Ok");
			    
			    
				    shell.pack();
				    shell.open();
					puv.run();// updates the view/ repaints diagram
					while(!shell.isDisposed()){
						if (!display.readAndDispatch())
					        display.sleep();
					}
					toggleMenuCreated = false;
				}	
			}
		};
		toggleVisibility.setImageDescriptor(PlantUmlUtils.getImageDescriptor(display, "/icons/visibility16.gif"));
		
		toggleVisibility.setToolTipText(PlantumlConstants.TOGGLE_VISIBILITY_BUTTON);

		// action to start or stop the generation of the actual diagram
		toggleAction = new ToggleButtonAction(this, display);
		
		reduceDepth = new Action(){
			@Override
			public void run() {
				//Reduces the value of the the depth setting by 1 so that classes of one less layer of included h-files will be shown
				ValueHolder.INSTANCE.reduceDepthSettingForHFilesClasses();
				puv.run(); // updates the view/ repaints diagram
			}
		};
		reduceDepth.setToolTipText(PlantumlConstants.REDUCE_DEPTH_SETTING_FOR_HFILES);
		reduceDepth.setImageDescriptor(PlantUmlUtils.getImageDescriptor(display, "/icons/c_Minus.gif"));
		
		increaseDepth = new Action(){
			@Override
			public void run(){
				ValueHolder.INSTANCE.increaseDepthSettingForHFilesClasses();
				puv.run(); // updates the view/ repaints diagram
			}
		};
		increaseDepth.setToolTipText(PlantumlConstants.INCREASE_DEPTH_SETTING_FOR_HFILES);
		increaseDepth.setImageDescriptor(PlantUmlUtils.getImageDescriptor(display, "/icons/c_Plus.gif"));
		
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(toggleAction);
		manager.add(new Separator());
		manager.add(zoomInAction);
		manager.add(zoomOutAction);
		manager.add(fitCanvasAction);
		manager.add(showOriginalAction);
		manager.add(toggleVisibility);
		manager.add(reduceDepth);
		manager.add(increaseDepth);
	}
	
	public void setCheckedButton(Button button, Boolean check){
		button.setSelection(check);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		canvas.setFocus();
	}
	
	@Override
	protected void updateDiagramText(final String text) {
		if (toggleAction != null && toggleAction.isChecked()) {
			generateAction.treatPlantUmlSelected(-1, text);
		}
	}
	
	public void updateDiagram(final String text) {
		updateDiagramText(text);
	}
	
	private void addShowButtonListenerAndText(Button button, String buttonName){
		button.setText(buttonName);
		button.addSelectionListener(new SelectionAdapter(){
			
			@Override
			public void widgetSelected(SelectionEvent e){
				Button button = (Button) e.getSource();
				if(button.getText().equals("Ok")){
					System.out.println("kal");
					puv.run(); // updates the view/ repaints diagram
					
					// This makes it so that the window will be closed when the ok-button is pressed
					Display.getDefault().getActiveShell().dispose(); 
				}
				else if(button.getSelection() && button.getText().equals("Show struct")){
					ValueHolder.INSTANCE.toggleShowStruct();
				}
				else if(button.getSelection() && button.getText().equals("Show enum"))
					ValueHolder.INSTANCE.toggleShowEnum();
				else if(button.getSelection() && button.getText().equals("Show protected")){
					ValueHolder.INSTANCE.toggleShowProtected();
				}
				else if(button.getSelection() && button.getText().equals("Show private")){
					ValueHolder.INSTANCE.toggleShowPrivate();
				}
				else if(button.getText().equals("Show struct")){
					ValueHolder.INSTANCE.toggleShowStruct();
				}
				else if(button.getText().equals("Show enum")){
					ValueHolder.INSTANCE.toggleShowEnum();
				}
				else if(button.getText().equals("Show protected")){
					ValueHolder.INSTANCE.toggleShowPrivate();
				}
			}
		});
	}
}
