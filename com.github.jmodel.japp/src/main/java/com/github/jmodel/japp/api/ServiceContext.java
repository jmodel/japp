package com.github.jmodel.japp.api;

/**
 * Service context
 * 
 * @author jianni@hotmail.com
 *
 */
public final class ServiceContext<D> {

	private Long ownerId;

	private Long traceId;

	private D session;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getTraceId() {
		return traceId;
	}

	public void setTraceId(Long traceId) {
		this.traceId = traceId;
	}

	public D getSession() {
		return session;
	}

	public void setSession(D session) {
		this.session = session;
	}

}
