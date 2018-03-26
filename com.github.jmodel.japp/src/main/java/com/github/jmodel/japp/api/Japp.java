package com.github.jmodel.japp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jmodel.adapter.api.config.ConfigurationAware;
import com.github.jmodel.adapter.api.config.Item;
import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.japp.JappTerms;

public final class Japp implements ConfigurationAware {

	public final static int hashCode = Japp.class.hashCode();

	public final static ObjectMapper mapper = new ObjectMapper();

	private final static SService _service_sp = SService.getInstance();

	private final static FService _feature_sp = FService.getInstance();

	private final static AService _action_sp = AService.getInstance();

	//

	@SuppressWarnings("unchecked")
	public static <T1, T2> Service<T1, T2> getService(String itemId) {
		Service<T1, T2> service = (Service<T1, T2>) _service_sp.getService(cm.getItemValue(JappTerms.SERVICE, itemId));
		if (service.getManager() != null) {
			return service;
		}
		synchronized (service) {
			if (service.getManager() == null) {
				service.setManager(hashCode);
				Item item = cm.getItem(JappTerms.SERVICE, itemId);
				if (item.getMonitor() != null && item.getMonitor().equals("true")) {
					service.setMonitored(true);
				} else {
					service.setMonitored(false);
				}
			}
			return service;
		}
	}

	//

	@SuppressWarnings("unchecked")
	public static <T1, T2> Feature<T1, T2> getFeature(String itemId) {
		Feature<T1, T2> feature = (Feature<T1, T2>) _feature_sp.getFeature(cm.getItemValue(JappTerms.FEATURE, itemId));
		if (feature.getManager() != null) {
			return feature;
		}
		synchronized (feature) {
			if (feature.getManager() == null) {
				feature.setManager(hashCode);
				Item item = cm.getItem(JappTerms.FEATURE, itemId);
				if (item.getMonitor() != null && item.getMonitor().equals("true")) {
					feature.setMonitored(true);
				} else {
					feature.setMonitored(false);
				}
			}
			return feature;
		}
	}

	//

	@SuppressWarnings("unchecked")
	public static <T1, T2, T3> Action<T1, T2, T3> getAction(String itemId) {
		AbstractAction action = (AbstractAction) _action_sp.getAction(cm.getItemValue(JappTerms.ACTION, itemId));
		if (action.getManager() != null) {
			return (Action<T1, T2, T3>) action;
		}
		synchronized (action) {
			if (action.getManager() == null) {
				action.setManager(hashCode);
				Item item = cm.getItem(JappTerms.ACTION, itemId);
				if (item.getMonitor() != null && item.getMonitor().equals("true")) {
					action.setMonitored(true);
				} else {
					action.setMonitored(false);
				}
			}
			return (Action<T1, T2, T3>) action;
		}
	}

}
