package com.github.jmodel.japp.api;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.japp.spi.FeatureFactory;

/**
 * Feature factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
final class FService {

	private static FService service;

	private ServiceLoader<FeatureFactory> loader;

	private FService() {
		loader = ServiceLoader.load(FeatureFactory.class);
	}

	public static FService getInstance() {

		if (service != null) {
			return service;
		}

		synchronized (FService.class) {
			if (service == null) {
				service = new FService();
			}
			return service;
		}
	}

	public Feature<?, ?> getFeature(String featureId) {

		Feature<?, ?> feature = null;

		Iterator<FeatureFactory> featureFactorys = loader.iterator();
		while (feature == null && featureFactorys.hasNext()) {
			FeatureFactory featureFactory = featureFactorys.next();
			feature = featureFactory.create(featureId);
		}

		return feature;
	}

}
