package com.github.jmodel.japp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jmodel.adapter.api.config.ConfigurationAware;
import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.japp.JappTerms;
import com.github.jmodel.japp.api.AService;
import com.github.jmodel.japp.api.FService;
import com.github.jmodel.japp.api.Feature;
import com.github.jmodel.japp.api.SService;
import com.github.jmodel.japp.api.Service;

public final class JappUtil implements ConfigurationAware {

	public static final ObjectMapper mapper = new ObjectMapper();

	private final static SService _service_sp = SService.getInstance();

	private final static FService _feature_sp = FService.getInstance();

	private final static AService _action_sp = AService.getInstance();

	//

	@SuppressWarnings("unchecked")
	public static <T1, T2> Service<T1, T2> getService(String itemId) {
		return (Service<T1, T2>) _service_sp.getService(cm.getItemValue(JappTerms.SERVICE.toString(), itemId));
	}

	//

	@SuppressWarnings("unchecked")
	public static <T1, T2> Feature<T1, T2> getFeature(String itemId) {
		return (Feature<T1, T2>) _feature_sp.getFeature(cm.getItemValue(JappTerms.FEATURE.toString(), itemId));
	}

	//

	@SuppressWarnings("unchecked")
	public static <T1, T2, T3> Action<T1, T2, T3> getAction(String itemId) {
		return (Action<T1, T2, T3>) _action_sp.getAction(cm.getItemValue(JappTerms.ACTION.toString(), itemId));
	}
}
