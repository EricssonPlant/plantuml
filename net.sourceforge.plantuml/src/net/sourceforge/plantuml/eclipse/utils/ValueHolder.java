package net.sourceforge.plantuml.eclipse.utils;



public enum ValueHolder{
	INSTANCE;
	
	// Values to store in value holder
	private boolean showPrivate = false; // Controls whether private functions should be shown in plantuml diagrams
	private boolean showProtected = false; // Controls whether protected function should be shown in plantuml diagrams
	private boolean showStruct = false; // Controls whether protected structs should be shown in plantuml diagrams 
	private boolean showEnum = false; // Controls whether enumerators should be shown in plantuml diagrams
	
	// The default setting for how many layers of h-file classes that will be included in the class diagram is set to 1 layer
	private int depthSettingForHFileClasses = 1;

	public boolean getShowPrivate(){
		return showPrivate;
	}
	public boolean getShowProtected(){
		return showProtected;
	}
	
	public boolean getShowStruct(){
		return showStruct;
	}

	public boolean getShowEnum(){
		return showEnum;
	}
	
	public void toggleShowStruct(){
		showStruct = !showStruct;
	}
	
	public void toggleShowEnum(){
		showEnum = !showEnum;
	}
	
	public void toggleShowPrivate(){
		showPrivate = !showPrivate;
	}
	
	public void toggleShowProtected(){
		showProtected = !showProtected;
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
