package com.github.jmodel.japp;

import com.github.jmodel.adapter.config.Configurable;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class AbstractAction implements Configurable {

	public static String getRegionId() {
		return "Action";
	}
}
