package net.sourceforge.plantuml.eclipse.utils;



public enum ValueHolder{
	INSTANCE;
	
	// Values to store in value holder
	private boolean showPrivate = false; // show of hide private functions in uml diagrams
	private boolean showProtected = false; // show of hide protected functions in uml diagrams
	
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
}
