package org.xtext;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.scoping.impl.MultimapBasedSelectable;
import org.xtext.plantuml.ArrowID;
import org.xtext.plantuml.Sequence;

class PlantumlImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	
	@Override
	protected MultimapBasedSelectable internalGetAllDescriptions(Resource resource) {
		Iterable<EObject> allContents = new Iterable<EObject>(){
				@Override
				public java.util.Iterator<EObject> iterator() {
					return EcoreUtil.getAllContents(resource, false);
				}
		}; 
		List<IEObjectDescription> allDescriptions = new ArrayList<IEObjectDescription>();
		for (EObject o : allContents) {
			if (o instanceof Sequence) {
				for (ArrowID arrowID :  ((Sequence)o).getArrowIDs()) {
					allDescriptions.add(EObjectDescription.create(QualifiedName.create(arrowID.getName()), o, null));
				}
			} else {
				QualifiedName name = getQualifiedNameProvider().getFullyQualifiedName(o);
				if (name != null) {
					allDescriptions.add(EObjectDescription.create(name, o, null));
				}
			}
		}
		return new MultimapBasedSelectable(allDescriptions);
	}
}
