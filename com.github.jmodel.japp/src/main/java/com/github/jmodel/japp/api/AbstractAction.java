package com.github.jmodel.japp.api;

import java.util.Properties;

import com.github.jmodel.adapter.api.config.Configurable;
import com.github.jmodel.japp.JappTerms;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class AbstractAction implements Configurable {

	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getProperty(String key) {
		return (String) properties.get(key);
	}

	@Override
	public String getRegionId() {
		return JappTerms.ACTION;
	}
}
