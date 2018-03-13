package com.github.jmodel.japp;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.japp.api.Service;
import com.github.jmodel.japp.service.search.SearchService;
import com.github.jmodel.japp.spi.ServiceFactory;

/**
 * Service factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class ServiceFactoryImpl implements ServiceFactory {

	private SortedMap<String, Service<?, ?>> map;

	public ServiceFactoryImpl() {
		map = new TreeMap<String, Service<?, ?>>();
		map.put(JappTerms.SEARCH, new SearchService());
	}

	public Service<?, ?> getService(String serviceId) {
		return map.get(serviceId);
	}

}
