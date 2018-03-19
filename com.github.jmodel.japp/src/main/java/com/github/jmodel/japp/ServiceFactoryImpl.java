package com.github.jmodel.japp;

import java.util.SortedMap;

import com.github.jmodel.japp.api.Service;
import com.github.jmodel.japp.service.search.SearchService;
import com.github.jmodel.japp.spi.ServiceFactory;

/**
 * Service factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class ServiceFactoryImpl extends ServiceFactory {

	@Override
	protected void createServices(SortedMap<String, Service<?, ?>> map) {
		map.put(JappTerms.SEARCH, new SearchService());		
	}

}
