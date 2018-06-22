package com.github.jmodel.japp.example.feature;

import java.util.SortedMap;

import com.github.jmodel.japp.api.Feature;
import com.github.jmodel.japp.example.JappExampleTerms;
import com.github.jmodel.japp.spi.FeatureFactory;

/**
 * Service factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class FeatureFactoryImpl extends FeatureFactory {

	@Override
	protected void createFeatures(SortedMap<String, Feature<?, ?>> map) {
		map.put(JappExampleTerms.SERVICE_EXAMPLE, new ExampleFeature());

	}

}
