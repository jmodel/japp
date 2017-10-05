package com.github.jmodel.japp.example.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jmodel.adapter.Mapper;
import com.github.jmodel.adapter.Persister;
import com.github.jmodel.adapter.config.Configuration;
import com.github.jmodel.adapter.config.ConfigurationLoader;
import com.github.jmodel.japp.Controller;
import com.github.jmodel.japp.ServiceContext;
import com.github.jmodel.japp.example.domain.entity.News;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
@RestController
public class NewsController extends Controller {

	private JpaRepository<News, Long> repository;

	private final static String IMAP = "mappingURIForInsertNews";

	@Autowired
	public NewsController(JpaRepository<News, Long> repository) {
		this.repository = repository;
	}

	@RequestMapping(value = "/addNews", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ROLE_ADMIN') and #oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_ADMIN'))")
	public Long addNews(HttpEntity<String> httpEntity) {

		try {
			Configuration conf = ConfigurationLoader.getInstance().getConfiguration();
			String mappingURI = conf.getValue(IMAP, getRegionId(), getItemId());
			JsonNode requestObj = ServiceContext.objectMapper.readTree(httpEntity.getBody());
			News news = Mapper.convert(requestObj, mappingURI, News.class);
			return Persister.insertObject(repository, "InsertNews", news);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 1L;
	}

	@Override
	public String getItemId() {
		return "NewsController";
	}

}
