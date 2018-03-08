package com.github.jmodel.japp;

import com.github.jmodel.adapter.api.config.ConfigurationManager;
import com.github.jmodel.japp.api.SService;
import com.github.jmodel.japp.api.Service;

/**
 * 
 * Controller is bridge to application container. Japp do not limit your
 * application to a certain container.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class Controller {

	private final static SService _service_sp = SService.getInstance();

	//

	@SuppressWarnings("unchecked")
	protected <T1, T2> Service<T1, T2> getService(String itemId) {
		return (Service<T1, T2>) _service_sp
				.getService(ConfigurationManager.getInstance().getItemValue(JappTerms.SERVICE, itemId));
	}

}
