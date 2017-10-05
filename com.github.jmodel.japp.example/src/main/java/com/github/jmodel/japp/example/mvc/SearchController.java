package com.github.jmodel.japp.example.mvc;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.jmodel.japp.Controller;
import com.github.jmodel.japp.JappException;
import com.github.jmodel.japp.Service;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
@RestController
public class SearchController extends Controller {

	@RequestMapping(value = "/search/{searchUser}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ROLE_ADMIN') and #oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_ADMIN'))")
	public String searchUser(@PathVariable String searchUser, String requestBody) {

		System.out.println("xxxxxxxxxxxxxxxxxxxxx");
		try {
			@SuppressWarnings("unchecked")
			Service<String, String> searchService = (Service<String, String>) getService("Search");
			String response = searchService.serve(0L, 0L, requestBody, "Search", searchUser);
			return response;
		} catch (JappException e) {
			e.printStackTrace();
		}

		return "{\"id\":\"aaa\",\"content\":\"Hello xxx World\"}";
	}

	@Override
	public String getItemId() {
		return "SearchController";
	}

}
