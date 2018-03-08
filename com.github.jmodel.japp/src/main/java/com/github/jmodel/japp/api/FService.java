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
public class FService {

	private static FService fservice;

	private ServiceLoader<FeatureFactory> loader;

	private FService() {
		loader = ServiceLoader.load(FeatureFactory.class);
	}

	public static synchronized FService getInstance() {
		if (fservice == null) {
			fservice = new FService();
		}
		return fservice;
	}

	public Feature<?, ?> getFeature(String featureId) {

		Feature<?, ?> feature = null;

		Iterator<FeatureFactory> featureFactorys = loader.iterator();
		while (feature == null && featureFactorys.hasNext()) {
			FeatureFactory featureFactory = featureFactorys.next();
			feature = featureFactory.getFeature(featureId);
		}

		return feature;
	}

}
