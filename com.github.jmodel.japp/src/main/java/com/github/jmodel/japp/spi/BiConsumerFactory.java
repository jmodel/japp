package com.github.jmodel.japp.spi;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

import com.github.jmodel.adapter.spi.Factory;

/**
 * BiConsumer factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class BiConsumerFactory extends Factory<BiConsumer<?, ?>> {

	protected final void init() {
		map = new TreeMap<String, BiConsumer<?, ?>>();
		register(map);
	}

	protected abstract void register(SortedMap<String, BiConsumer<?, ?>> map);

}
