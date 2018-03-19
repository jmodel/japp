package com.github.jmodel.japp.api;

import java.util.Properties;

import com.github.jmodel.ModelException;
import com.github.jmodel.adapter.api.ManagedObject;
import com.github.jmodel.adapter.api.TermAware;
import com.github.jmodel.adapter.api.config.Configurable;
import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.japp.JappTerms;

/**
 * Feature
 * 
 * @author jianni@hotmail.com
 *
 * @param <T>
 *            value type of return
 */
public abstract class Feature<I, T> extends ManagedObject implements Configurable, TermAware {

	private Properties properties;

	//

	@Override
	public Term getRegionTerm() {
		return tfs.getTerm(JappTerms.FEATURE);
	}

	//

	public final T serve(ServiceContext<?> ctx, I inputObject, Object... args) throws ModelException {

		/*
		 * ensure feature instance is created by Japp
		 */
		checkLegality(Japp.hashCode);

		// TODO handle trace, security, ...

		return perform(inputObject, args);
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getProperty(String key) {
		return (String) properties.get(key);
	}

	//

	protected abstract T perform(I inputObject, Object... args) throws ModelException;

}
