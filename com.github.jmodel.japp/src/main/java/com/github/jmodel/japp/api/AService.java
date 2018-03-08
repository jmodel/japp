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
public class AService {

	private static AService aservice;

	private ServiceLoader<ActionFactory> loader;

	private AService() {
		loader = ServiceLoader.load(ActionFactory.class);
	}

	public static synchronized AService getInstance() {
		if (aservice == null) {
			aservice = new AService();
		}
		return aservice;
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
