package com.github.jmodel.japp.example.service;

import java.util.SortedMap;

import com.github.jmodel.japp.api.Service;
import com.github.jmodel.japp.example.JappExampleTerms;
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
		map.put(JappExampleTerms.SERVICE_EXAMPLE, new ExampleService());
	}

}
