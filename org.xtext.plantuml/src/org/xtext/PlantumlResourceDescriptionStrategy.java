package org.xtext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.xtext.plantuml.Arrow;

public class PlantumlResourceDescriptionStrategy extends
		DefaultResourceDescriptionStrategy {
	
	@Override
	public boolean createEObjectDescriptions(EObject eObject,
			IAcceptor<IEObjectDescription> acceptor) {
		if(eObject instanceof Arrow) {
			EList<String> l = ((Arrow) eObject).getNames();
			for (String i : ((Arrow) l).getNames()) {
				acceptor.accept(EObjectDescription.create(QualifiedName.create(i), eObject));
			}
		}
		return super.createEObjectDescriptions(eObject, acceptor);
	}

}