package com.github.jmodel.japp.api;

import com.github.jmodel.adapter.api.ManagedObject;
import com.github.jmodel.adapter.api.MonitorInfo;
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

	@Override
	public Term getRegionTerm() {
		return tfs.getTerm(JappTerms.SERVICE);
	}

	//

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
	public final T serve(ServiceContext<?> ctx, R request, String... path) throws JappException {
		checkLegality(Japp.hashCode);

		//
		T r;
		if (isMonitored()) {
			long c = System.currentTimeMillis();
			r = perform(ctx, request, path);
			MonitorInfo monitorInfo = new MonitorInfo();
			monitorInfo.setExecutionTime((System.currentTimeMillis() - c) / 1000);
			reportMe(monitorInfo);
		} else {
			r = perform(ctx, request, path);
		}
		return r;
	}

	//

	protected abstract T perform(ServiceContext<?> ctx, R request, String... path) throws JappException;

}
