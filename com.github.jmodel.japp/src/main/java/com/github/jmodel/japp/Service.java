package com.github.jmodel.japp;

import com.github.jmodel.adapter.config.Configurable;

/**
 * Service interface.
 * 
 * @author jianni@hotmail.com
 * 
 * @param <T>
 *            value type of return
 * @param <R>
 *            value type of request
 *
 */
public abstract class Service<T, R> implements Configurable {

	/**
	 * Perform service work.
	 * 
	 * @param ownerId
	 *            owner id
	 * @param traceId
	 *            trace id
	 * @param request
	 *            request
	 * @param path
	 *            path
	 * @return arbitrary object
	 * @throws JappException
	 *             JappException
	 */
	public T serve(Long ownerId, Long traceId, R request, String... path) throws JappException {

		ServiceContext ctx = new ServiceContext();
		ctx.setOwnerId(ownerId);
		ctx.setTraceId(traceId);

		return perform(ctx, request, path);
	}

	protected abstract T perform(ServiceContext ctx, R request, String... path) throws JappException;

	public static String getRegionId() {
		return "Service";
	}

}
