package com.github.jmodel.japp.feature.search;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jmodel.adapter.Mapper;
import com.github.jmodel.adapter.Searcher;
import com.github.jmodel.api.control.Feature;
import com.github.jmodel.api.control.ServiceContext;
import com.github.jmodel.japp.utils.JappUtil;

/**
 * Query by criteria.
 * 
 * @author jianni@hotmail.com
 *
 */
public class SearchFeature extends Feature<String> {

	@Override
	public String perform(ServiceContext<?> ctx, Object... args) {

		try {

			JsonNode request = (JsonNode) args[0];
			String index = (String) args[1];
			String mappingURIForSearch = (String) args[2];
			String mappingURIForUI = (String) args[3];

			/*
			 * Prepare query criteria
			 */
			String query = Mapper.convert(request, mappingURIForSearch, String.class);

			/*
			 * Search in search engine
			 */
			String queryResultJson = Searcher.search(index, query);

			/*
			 * Change to json for UI presentation
			 */
			return Mapper.convert(JappUtil.mapper.readTree(queryResultJson), mappingURIForUI, String.class);

		} catch (Exception e) {
			throw new RuntimeException("Failed to search", e);
		}
	}

	@Override
	public String getItemId() {
		return "SearchFeature";
	}

}
