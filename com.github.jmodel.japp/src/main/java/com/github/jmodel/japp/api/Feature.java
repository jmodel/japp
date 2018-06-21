package com.github.jmodel.japp.api;

import com.github.jmodel.adapter.api.ManagedObject;
import com.github.jmodel.adapter.api.MonitorInfo;
import com.github.jmodel.adapter.api.TermAware;
import com.github.jmodel.adapter.api.config.Configurable;
import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.japp.JappException;
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

	//

	@Override
	public Term getRegionTerm() {
		return tfs.getTerm(JappTerms.FEATURE);
	}

	//

	public final T serve(ServiceContext<?> ctx, I inputObject, Object... args) throws JappException {

		/*
		 * ensure feature instance is created by Japp
		 */
		checkLegality(Japp.hashCode);

		// TODO handle trace, security, ...

		T r;
		if (isMonitored()) {
			long c = System.currentTimeMillis();
			r = perform(inputObject, args);
			MonitorInfo monitorInfo = new MonitorInfo();
			monitorInfo.setExecutionTime((System.currentTimeMillis() - c) / 1000);
			reportMe(monitorInfo);
		} else {
			r = perform(inputObject, args);
		}
		return r;
	}

	//

	protected abstract T perform(I inputObject, Object... args) throws JappException;

}
