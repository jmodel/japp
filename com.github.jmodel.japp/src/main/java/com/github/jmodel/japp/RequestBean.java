package com.github.jmodel.japp;

import javax.ws.rs.HeaderParam;

public class RequestBean {

	@HeaderParam("myHeader")
	private String header;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

}
