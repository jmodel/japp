package com.github.jmodel.japp;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.jmodel.adapter.config.Configuration;
import com.github.jmodel.adapter.config.ConfigurationLoader;
import com.github.jmodel.adapter.util.Util;

/**
 * Root resource (exposed at "japp" path)
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JappResource {

	@POST
	@Path("/{service}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getIt(@PathParam("service") String serviceId, @BeanParam RequestBean requestBean) {
		return "Got itxx!";
	}

	@POST
	@Path("/{service}/{virtualService}")
	public String serve(@PathParam("service") String serviceId, @PathParam("virtualService") String virtualServiceId,
			@BeanParam RequestBean requestBean, String requestBody) {

		Configuration configuration = ConfigurationLoader.getInstance().getConfiguration();
		String serviceUrl = configuration.getValue(Service.getRegionId(), serviceId);

		Service<String, String> service = Util.find(serviceUrl);
		if (service == null) {
			// 404
			return "service is not found";
		}

		try {
			String response = service.serve(0L, 0L, requestBody, serviceId, virtualServiceId);
			return response;
		} catch (JappException e) {
			e.printStackTrace();
		}

		return "Got itxxww!";
	}
}
