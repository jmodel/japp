package com.github.jmodel.japp.spi;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.adapter.spi.Factory;

/**
 * Action factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class ActionFactory extends Factory<Action<?, ?, ?>> {

	protected final void init() {
		map = new TreeMap<String, Action<?, ?, ?>>();
		createActions(map);
	}

	protected abstract void createActions(SortedMap<String, Action<?, ?, ?>> map);

}
