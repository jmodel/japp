package com.github.jmodel.japp.spi;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.spi.Factory;
import com.github.jmodel.japp.api.Feature;

/**
 * Feature factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class FeatureFactory extends Factory<Feature<?, ?>> {

	protected final void init() {
		map = new TreeMap<String, Feature<?, ?>>();
		createFeatures(map);
	}

	protected abstract void createFeatures(SortedMap<String, Feature<?, ?>> map);

}
