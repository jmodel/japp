package com.github.jmodel.japp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jmodel.adapter.api.config.ConfigurationAware;
import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.japp.JappTerms;

public final class Japp implements ConfigurationAware {

	public static int hashCode = Japp.class.hashCode();

	public static final ObjectMapper mapper = new ObjectMapper();

	private final static SService _service_sp = SService.getInstance();

	private final static FService _feature_sp = FService.getInstance();

	private final static AService _action_sp = AService.getInstance();

	//

	@SuppressWarnings("unchecked")
	public static <T1, T2> Service<T1, T2> getService(String itemId) {
		Service<T1, T2> service = (Service<T1, T2>) _service_sp.getService(cm.getItemValue(JappTerms.SERVICE, itemId));
		service.setManager(Japp.class.hashCode());
		return service;
	}

	//

	@SuppressWarnings("unchecked")
	public static <T1, T2> Feature<T1, T2> getFeature(String itemId) {
		Feature<T1, T2> feature = (Feature<T1, T2>) _feature_sp.getFeature(cm.getItemValue(JappTerms.FEATURE, itemId));
		feature.setManager(Japp.class.hashCode());
		return (Feature<T1, T2>) _feature_sp.getFeature(cm.getItemValue(JappTerms.FEATURE, itemId));
	}

	//

	@SuppressWarnings("unchecked")
	public static <T1, T2, T3> Action<T1, T2, T3> getAction(String itemId) {
		AbstractAction action = (AbstractAction) _action_sp.getAction(cm.getItemValue(JappTerms.ACTION, itemId));
		action.setManager(Japp.class.hashCode());
		return (Action<T1, T2, T3>) action;
	}

}
