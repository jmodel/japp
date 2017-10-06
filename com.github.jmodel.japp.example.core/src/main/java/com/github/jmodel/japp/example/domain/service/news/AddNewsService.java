package com.github.jmodel.japp.example.domain.service.news;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jmodel.adapter.Mapper;
import com.github.jmodel.adapter.Persister;
import com.github.jmodel.adapter.config.Configuration;
import com.github.jmodel.adapter.config.ConfigurationLoader;
import com.github.jmodel.japp.JappException;
import com.github.jmodel.japp.Service;
import com.github.jmodel.japp.ServiceContext;
import com.github.jmodel.japp.example.domain.entity.News;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public class AddNewsService extends Service<String, String> {

	private final static String M_ADD_NEWS = "mAddNews";

	@Override
	protected String perform(ServiceContext<?> ctx, String request, String... path) throws JappException {

		try {
			Configuration conf = ConfigurationLoader.getInstance().getConfiguration();
			String mappingURI = conf.getValue(M_ADD_NEWS, getRegionId());
			JsonNode requestObj = ServiceContext.objectMapper.readTree(request);
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
			throw new JappException("Add News Service does not work", e);
		}
	}

	@Override
	public String getItemId() {
		return "AddNewsService";
	}

}
