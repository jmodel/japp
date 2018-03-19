package com.github.jmodel.japp.api;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.japp.spi.ServiceFactory;

/**
 * Service factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
final class SService {

	private static SService sservice;

	private ServiceLoader<ServiceFactory> loader;

	private SService() {
		loader = ServiceLoader.load(ServiceFactory.class);
	}

	public static SService getInstance() {

		if (sservice != null) {
			return sservice;
		}

		synchronized (SService.class) {
			if (sservice == null) {
				sservice = new SService();
			}
			return sservice;
		}
	}

	public Service<?, ?> getService(String serviceId) {

		Service<?, ?> service = null;

		Iterator<ServiceFactory> serviceFactorys = loader.iterator();
		while (service == null && serviceFactorys.hasNext()) {
			ServiceFactory serviceFactory = serviceFactorys.next();
			service = serviceFactory.create(serviceId);
		}

		return service;
	}

}
