package com.github.jmodel.japp.service.search;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jmodel.adapter.Mapper;
import com.github.jmodel.adapter.Searcher;
import com.github.jmodel.api.control.Service;
import com.github.jmodel.api.control.ServiceContext;
import com.github.jmodel.japp.utils.JappUtil;

/**
 * Generic search service.
 * 
 * @author jianni@hotmail.com
 *
 */
public class SearchService extends Service<String, String> {

	private final static String INX = "index";

	private final static String IMAP = "mappingURIForSearch";

	private final static String OMAP = "mappingURIForUI";

	@Override
	protected String perform(ServiceContext<?> ctx, String request, String... path) {

		String index = getProperty(INX);
		String mappingURIForSearch = getProperty(IMAP);
		String mappingURIForUI = getProperty(OMAP);

		try {

			JsonNode requestObj = JappUtil.mapper.readTree(request);

			/*
			 * Prepare query criteria
			 */
			String query = Mapper.convert(requestObj, mappingURIForSearch, String.class);

			/*
			 * Search in search engine
			 */
			String queryResultJson = Searcher.search(index, query);

			/*
			 * Change to json for UI presentation
			 */
			return Mapper.convert(JappUtil.mapper.readTree(queryResultJson), mappingURIForUI, String.class);
		} catch (Exception e) {
			throw new RuntimeException("Search service does not work", e);
		}
	}

	@Override
	public String getItemId() {
		return "SearchService";
	}

}
