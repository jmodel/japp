package com.github.jmodel.japp;

import com.github.jmodel.adapter.config.Configurable;

/**
 * Feature
 * 
 * @author jianni@hotmail.com
 *
 * @param <T>
 *            value type of return
 */
public abstract class Feature<T> implements Configurable {

	public T perform(ServiceContext<?> ctx, Object... args) throws JappException {
		return null;
	}

	public static String getRegionId() {
		return "Feature";
	}

}
