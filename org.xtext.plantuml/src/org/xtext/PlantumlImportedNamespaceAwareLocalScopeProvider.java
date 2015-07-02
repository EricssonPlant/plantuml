package org.xtext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
//import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.internal.xtend.util.QualifiedName;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.scoping.impl.MultimapBasedSelectable;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.xtext.plantuml.Arrow;
import org.xtext.plantuml.Declarations;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/*public class PlantumlImportedNamespaceAwareLocalScopeProvider extends
		ImportedNamespaceAwareLocalScopeProvider {
	
	@Override
	protected IScope getLocalElementsScope(IScope parent, EObject context,
			EReference reference) {
		// TODO Auto-generated method stub
		return super.getLocalElementsScope(parent, context, reference);
	}
	
	protected ISelectable internalGetAllDescriptions(final Resource resource) {
		Iterable<EObject> allContents = new Iterable<EObject>(){
			@Override
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllContents((Collection<?>) resource, false);
			}
		}; 
		Iterable<IEObjectDescription> transformed = IterableExtensions.flatten(Iterables.transform(allContents,
				new Function<EObject, List<IEObjectDescription>>() {
					@Override
					public List<IEObjectDescription> apply(EObject from) {
						if (from instanceof Arrow) {
							List<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
							Arrow l = (Arrow) from;
							for (String i : l.getNames()) {
								result.add(EObjectDescription.create(QualifiedName.create(i), from));
							}
							return result;
						} else {
							final org.eclipse.xtext.naming.QualifiedName qualifiedName = getQualifiedNameProvider().apply(from);
							if (qualifiedName != null)
								return Lists.newArrayList(new EObjectDescription(qualifiedName, from, null));
							return Collections.emptyList();
						}
						
						
					}
				}));
		return new MultimapBasedSelectable( Iterables.filter(transformed, Predicates.notNull()));
	}
}*/