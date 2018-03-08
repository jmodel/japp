package com.github.jmodel.japp.spi;

import com.github.jmodel.adapter.api.persistence.Action;

/**
 * Action factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface ActionFactory {

	public Action<?, ?, ?> getAction(String actionId);

}
