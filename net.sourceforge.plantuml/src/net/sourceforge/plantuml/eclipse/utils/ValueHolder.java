package net.sourceforge.plantuml.eclipse.utils;



public enum ValueHolder{
	INSTANCE;
	
	// Values to store in value holder
	private boolean showPrivate = false; // show of hide private functions in uml diagrams
	private boolean showProtected = false; // show of hide protected functions in uml diagrams
	
	// The default setting for how many layers of h-file classes that will be included in the class diagram is set to 1 layer
	private int depthSettingForHFileClasses = 1;
	
	public void toggleVisibility(){
		showPrivate = !showPrivate; // toggle
		showProtected = showPrivate; // keep them same...

	}

	public boolean getShowPrivate(){
		return showPrivate;
	}
	public boolean getShowProtected(){
		return showProtected;
	}
	
	public int getDepthSettingForHFileClasses(){
		return depthSettingForHFileClasses;
	}
	
	public void reduceDepthSettingForHFilesClasses(){
		if(depthSettingForHFileClasses > 0){
			--depthSettingForHFileClasses;
		}
	}
	
	public void increaseDepthSettingForHFilesClasses(){
		++depthSettingForHFileClasses;
	}
}
