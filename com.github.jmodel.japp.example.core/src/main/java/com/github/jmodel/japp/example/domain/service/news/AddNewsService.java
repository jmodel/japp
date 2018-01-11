package com.github.jmodel.japp.example.domain.service.news;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jmodel.adapter.Mapper;
import com.github.jmodel.adapter.Persister;
import com.github.jmodel.api.control.Service;
import com.github.jmodel.api.control.ServiceContext;
import com.github.jmodel.japp.example.domain.entity.News;
import com.github.jmodel.japp.utils.JappUtil;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public class AddNewsService extends Service<String, String> {

	private final static String M_ADD_NEWS = "mAddNews";

	@Override
	protected String perform(ServiceContext<?> ctx, String request, String... path) {

		try {

			String mappingURI = getProperty(M_ADD_NEWS);

			JsonNode requestObj = JappUtil.mapper.readTree(request);
			News news = Mapper.convert(requestObj, mappingURI, News.class);

			/*
			 * persist
			 */
			Persister.insertObject(ctx.getSession(), "InsertNewsAction", news);

			/*
			 * index
			 */

			return "xx";

		} catch (Exception e) {
			throw new RuntimeException("Add News Service does not work", e);
		}
	}

	@Override
	public String getItemId() {
		return "AddNewsService";
	}

}
