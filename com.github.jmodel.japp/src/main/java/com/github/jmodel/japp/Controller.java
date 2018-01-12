package com.github.jmodel.japp;

import com.github.jmodel.adapter.utils.AdapterUtil;
import com.github.jmodel.api.control.ControlEnum;
import com.github.jmodel.api.control.Service;

/**
 * 
 * Controller is bridge to application container. Japp do not limit your
 * application to a certain container.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class Controller {

	protected <I, R> Service<I, R> getService(String serviceId) throws JappException {

		try {
			
			Service<I, R> service = AdapterUtil.findObject(ControlEnum.SERVICE, serviceId);
			return service;
		} catch (Exception e) {
			throw new JappException("Failed to get service", e);
		}
	}

}
