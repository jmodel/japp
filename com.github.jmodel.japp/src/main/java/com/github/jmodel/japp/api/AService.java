package com.github.jmodel.japp.api;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.japp.spi.ActionFactory;

/**
 * Action factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class AService {

	private static AService service;

	private ServiceLoader<ActionFactory> loader;

	private AService() {
		loader = ServiceLoader.load(ActionFactory.class);
	}

	public static AService getInstance() {
		if (service != null) {
			return service;
		}

		synchronized (AService.class) {
			if (service == null) {
				service = new AService();
			}
			return service;
		}
	}

	public Action<?, ?, ?> getAction(String actionId) {

		Action<?, ?, ?> action = null;

		Iterator<ActionFactory> actionFactorys = loader.iterator();
		while (action == null && actionFactorys.hasNext()) {
			ActionFactory actionFactory = actionFactorys.next();
			action = actionFactory.getAction(actionId);
		}

		return action;
	}

}
