package com.github.jmodel.japp.spi;

import com.github.jmodel.japp.api.Feature;

/**
 * Feature factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface FeatureFactory {

	public Feature<?, ?> getFeature(String featureId);

}
