package com.github.jmodel.japp;

import com.github.jmodel.adapter.config.Configurable;
import com.github.jmodel.adapter.config.Configuration;
import com.github.jmodel.adapter.config.ConfigurationLoader;
import com.github.jmodel.adapter.util.Util;

public abstract class Controller implements Configurable {

	protected Service<?, ?> getService(String serviceId) {
		Configuration configuration = ConfigurationLoader.getInstance().getConfiguration();
		String serviceUrl = configuration.getValue(Service.getRegionId(), serviceId);
		return Util.find(serviceUrl);
	}
	
	public static String getRegionId() {
		return "Controller";
	}
}
