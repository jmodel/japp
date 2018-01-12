package com.github.jmodel.japp.example.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.jmodel.api.control.Service;
import com.github.jmodel.api.control.ServiceContext;
import com.github.jmodel.japp.Controller;
import com.github.jmodel.japp.example.domain.dao.NewsRepository;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
@RestController
public class NewsController extends Controller {

	private NewsRepository repository;

	@Autowired
	public NewsController(NewsRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(value = "/addNews", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ROLE_ADMIN') and #oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_ADMIN'))")
	public String addNews(HttpEntity<String> httpEntity) {

		try {
			
			Service<String, String> service = getService("AddNewsService");
			
			ServiceContext<NewsRepository> ctx = new ServiceContext<NewsRepository>();
			ctx.setOwnerId(0L);
			ctx.setTraceId(0L);
			ctx.setSession(repository);

			String response = service.serve(ctx, httpEntity.getBody(), service.getItemId());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "xx";
	}

}
