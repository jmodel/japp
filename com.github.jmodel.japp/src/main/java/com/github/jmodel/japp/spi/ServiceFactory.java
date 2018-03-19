package com.github.jmodel.japp.spi;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.spi.Factory;
import com.github.jmodel.japp.api.Service;

/**
 * Service factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class ServiceFactory extends Factory<Service<?, ?>> {

	protected final void init() {
		map = new TreeMap<String, Service<?, ?>>();
		createServices(map);
	}

	protected abstract void createServices(SortedMap<String, Service<?, ?>> map);
}
