package org.xtext.plantuml.cdt;

public enum ValueHolder {
	INSTANCE;
	
	// Values to store in value holder
	private boolean showPrivate = false; // show of hide private functions in uml diagrams
	private boolean showProtected = false; // show of hide protected functions in uml diagrams
	
	public void toggleVisigility(){
		showPrivate = !showPrivate;
		showProtected = showPrivate;
	}

	public boolean getShowPrivate(){
		return showPrivate;
	}
	public boolean getShowProtected(){
		return showProtected;
	}
}
