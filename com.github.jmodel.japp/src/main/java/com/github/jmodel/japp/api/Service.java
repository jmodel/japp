package com.github.jmodel.japp.api;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import com.github.jmodel.adapter.api.ManagedObject;
import com.github.jmodel.adapter.api.TermAware;
import com.github.jmodel.adapter.api.config.Configurable;
import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.japp.JappException;
import com.github.jmodel.japp.JappTerms;

/**
 * Service interface.
 * 
 * @author jianni@hotmail.com
 * 
 * 
 * @param <T>
 *            value type of return
 * @param <R>
 *            value type of request
 *
 */
public abstract class Service<T, R> extends ManagedObject implements Configurable, TermAware {

	private static Properties properties = new Properties();

	private static Map<String, Path> pathMap = new ConcurrentHashMap<String, Path>();

	@Override
	public Term getRegionTerm() {
		return tfs.getTerm(JappTerms.SERVICE);
	}

	//

	public T serve(ServiceContext<?> ctx, R request) throws JappException {
		return serve(ctx, request, null);
	}

	/**
	 * Perform service work.
	 * 
	 * @param ctx
	 *            service context
	 * @param request
	 *            request
	 * @param path
	 *            path
	 * @return arbitrary object
	 * @throws JappException
	 *             JappException
	 */
	public final T serve(ServiceContext<?> ctx, R request, String path) throws JappException {
		checkLegality(Japp.hashCode);
		return perform(ctx, request, path);
	}

	public Properties getProperties() {
		return properties;
	}

	public String getProperty(String key) {
		return (String) properties.get(key);
	}

	public Map<String, Path> getPathMap() {
		return pathMap;
	}

	public Path getPath(String key) {
		return pathMap.get(key);
	}

	//

	protected abstract T perform(ServiceContext<?> ctx, R request, String path) throws JappException;

}
