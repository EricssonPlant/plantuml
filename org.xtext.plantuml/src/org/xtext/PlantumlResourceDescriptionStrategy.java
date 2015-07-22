package org.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.xtext.plantuml.ArrowID;
import org.xtext.plantuml.Sequence;

public class PlantumlResourceDescriptionStrategy extends
		DefaultResourceDescriptionStrategy {
	
	@Override
	public boolean createEObjectDescriptions(EObject eObject,
			IAcceptor<IEObjectDescription> acceptor) {
		if(eObject instanceof Sequence) {
			//EList<String> l = ((Sequence) eObject).getNames();
			for (ArrowID arrowID :  ((Sequence) eObject).getArrowIDs()) {
				acceptor.accept(EObjectDescription.create(QualifiedName.create(arrowID.getName()), eObject));
			}
		}
		return super.createEObjectDescriptions(eObject, acceptor);
	}

}