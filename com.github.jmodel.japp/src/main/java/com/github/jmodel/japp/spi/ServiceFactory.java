package com.github.jmodel.japp.spi;

import com.github.jmodel.japp.api.Service;

/**
 * Service factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface ServiceFactory {

	public Service<?, ?> getService(String serviceId);

}
