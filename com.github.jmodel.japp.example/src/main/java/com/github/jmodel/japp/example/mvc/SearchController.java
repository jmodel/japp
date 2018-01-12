package com.github.jmodel.japp.example.mvc;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.jmodel.adapter.Logger;
import com.github.jmodel.api.control.Service;
import com.github.jmodel.api.control.ServiceContext;
import com.github.jmodel.japp.Controller;
import com.github.jmodel.japp.JappException;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
@RestController
public class SearchController extends Controller {

	private static final Logger logger = Logger.getLogger(SearchController.class.getName());
	
	@RequestMapping(value = "/search/{searchUser}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ROLE_ADMIN') and #oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_ADMIN'))")
	public String searchUser(@PathVariable String searchUser, String requestBody) throws JappException {

		try {
			
			Service<String, String> service = getService("SearchService");

			ServiceContext<Void> ctx = new ServiceContext<Void>();
			ctx.setOwnerId(0L);
			ctx.setTraceId(0L);

			return service.serve(ctx, requestBody, service.getItemId(), searchUser);
		} catch (Exception e) {
			logger.error("");
			throw new JappException("", e);
		}
	}

}
