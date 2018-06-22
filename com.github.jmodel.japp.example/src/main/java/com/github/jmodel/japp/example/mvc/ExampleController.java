package com.github.jmodel.japp.example.mvc;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.jmodel.adapter.Logger;
import com.github.jmodel.japp.Controller;
import com.github.jmodel.japp.JappException;
import com.github.jmodel.japp.api.Japp;
import com.github.jmodel.japp.api.Service;
import com.github.jmodel.japp.api.ServiceContext;
import com.github.jmodel.japp.example.JappExampleTerms;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
@RestController
public class ExampleController extends Controller {

	private static final Logger logger = Logger.getLogger(ExampleController.class.getName());

	@RequestMapping(value = "/example", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public String searchUser(String requestBody) throws JappException {

		try {

			Service<String, String> service = Japp.getService(JappExampleTerms.SERVICE_EXAMPLE);

			ServiceContext<Void> ctx = new ServiceContext<Void>();
			ctx.setOwnerId(0L);
			ctx.setTraceId(0L);

			return service.serve(ctx, requestBody);

		} catch (Exception e) {
			logger.info(() -> "");
			throw new JappException("", e);
		}
	}

}
