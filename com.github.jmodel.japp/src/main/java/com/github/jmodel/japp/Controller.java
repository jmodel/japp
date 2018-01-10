package com.github.jmodel.japp;

import com.github.jmodel.adapter.utils.Util;
import com.github.jmodel.api.control.ControlEnum;
import com.github.jmodel.api.control.Service;

public abstract class Controller {

	protected Service<?, ?> getService(String serviceId) {

		return Util.findObject(ControlEnum.SERVICE, serviceId);
	}

}
