/*
 * generated by Xtext
 */
package org.xtext.ui.labeling

import com.google.inject.Inject
import org.xtext.plantuml.Arrow
import org.xtext.plantuml.Instruction
import org.xtext.plantuml.Sequence
import org.xtext.plantuml.Diagram
import org.xtext.plantuml.Reference
import org.xtext.plantuml.Definition
import org.xtext.plantuml.AutoNumber
import org.xtext.plantuml.Title
import org.xtext.plantuml.Legend
import org.xtext.plantuml.GroupingMessages
import org.xtext.plantuml.Note
import org.xtext.plantuml.Divider
import org.xtext.plantuml.Delay
import org.xtext.plantuml.Space
import org.xtext.plantuml.Activate
import org.xtext.plantuml.Deactivate
import org.xtext.plantuml.ParticipantCreation
import org.xtext.plantuml.Box
import org.xtext.plantuml.IncOut
import org.xtext.plantuml.Skinparam
import org.xtext.plantuml.ArrowID

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class PlantumlLabelProvider extends org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider {

	@Inject
	new(org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:
	
	def text(Diagram diagram){
		"Diagram"
	}
	
	def text(Instruction instr){
		if(instr.getInstr() instanceof Definition){
			"Definition"
		}
		else{
			"Instruction"
		}
	}
	
	def text(Sequence sequence){
		"Sequence"
	}
	
	def text(ArrowID arrowId){
		"Name: " + arrowId.getName();
	}
	
	def text(Arrow arrow){
		"Arrow. Shape: " + arrow.getLeft() + arrow.getLeftmid()
		+ arrow.getRightmid() + arrow.getRight() + ". Color: " + arrow.getColor();
	}
	
	def text(Definition defi){  
		"Type: " + defi.getStartKeyword() + ", Name: " + defi.getName();
	}
	
	
	def text(AutoNumber auto){
		"Autonumber"
	}
	
	def text(Title title){
		"Title"
	}
	
	def text(Legend legend){
		"Legend"
	}
	
	def text(GroupingMessages mess){
		"GroupingMessage: " + mess.getStartKeyword();
	}
	
	def text(Note note){
		"Note. Dir: " + note.getDir() + ", relative to: " + note.getIds()
	}
	
	def text(Divider div){
		"Divider"
	}
	
	def text(Reference ref){
		/*var String ret;
		for(i:0 ..< ref.getIds().length()){
			var Declaration dec = ref.getIds().get(i);
			if(dec instanceof Definition){
				var Definition def = dec as Definition;
				ret += "Reference over Defintion ID: " + def.getDeftype().getName() + "\n";
			}
			else if(dec instanceof Sequence){
				var Sequence seq = dec as Sequence;
				ret += "Reference over Sequence ID: " 
			}
		}
		ret*/
		"Reference"
	}
	
	def text(Delay delay){
		"Delay"
	}
	
	def text(Space space){
		"Space"
	}
	
	def text(Activate ac){
		"Activate"
	}
	
	def text(Deactivate deac){
		"Deactivate"
	}
	
	def text(ParticipantCreation create){
		"Creation of character: " + create.getName();
	}
	
	def text(Box box){
		"Box"
	}
	
	def text(IncOut incout){
		"Incoming/Outgoing Message"
	}
	
	def text(Skinparam skinparam){
		"Skinparam"
	}
	
	
	
}
