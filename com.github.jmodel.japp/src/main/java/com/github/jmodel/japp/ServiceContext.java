package com.github.jmodel.japp;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Service context
 * 
 * @author jianni@hotmail.com
 *
 */
public class ServiceContext<D> {

	public final static ObjectMapper objectMapper = new ObjectMapper();

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
