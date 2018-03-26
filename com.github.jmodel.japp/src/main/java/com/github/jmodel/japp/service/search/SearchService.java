package com.github.jmodel.japp.service.search;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.Logger;
import com.github.jmodel.adapter.Mapper;
import com.github.jmodel.adapter.Searcher;
import com.github.jmodel.adapter.api.MonitorInfo;
import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.japp.JappTerms;
import com.github.jmodel.japp.api.Japp;
import com.github.jmodel.japp.api.Service;
import com.github.jmodel.japp.api.ServiceContext;

/**
 * Generic search service.
 * 
 * @author jianni@hotmail.com
 *
 */
public class SearchService extends Service<String, String> {

	private final static Logger logger = Logger.getLogger(SearchService.class.getName());

	@Override
	protected String perform(ServiceContext<?> ctx, String request, String... path) {

		String index = cm.getPropertyValue(JappTerms.SERVICE_SEARCH_INDEX, JappTerms.SERVICE, path);
		String mappingURIForSearch = cm.getPropertyValue(JappTerms.SERVICE_SEARCH_MAPPINGURIFORSEARCH,
				JappTerms.SERVICE, path);
		String mappingURIForUI = cm.getPropertyValue(JappTerms.SERVICE_SEARCH_MAPPINGURIFORUI, JappTerms.SERVICE, path);

		try {

			JsonNode requestObj = Japp.mapper.readTree(request);

			/*
			 * Prepare query criteria
			 */
			String query = Mapper.getMapper().convert(requestObj, mappingURIForSearch, String.class);

			/*
			 * Search in search engine
			 */
			String queryResultJson = Searcher.getSearcher().search(index, query);

			/*
			 * Change to json for UI presentation
			 */
			return Mapper.getMapper().convert(Japp.mapper.readTree(queryResultJson), mappingURIForUI, String.class);
		} catch (Exception e) {
			throw new RuntimeException("Search service does not work", e);
		}
	}

	@Override
	public Term getItemTerm() {
		return tfs.getTerm(JappTerms.SERVICE_SEARCH);
	}

	@Override
	protected void reportMe(MonitorInfo monitorInfo) {
		logger.info(tfs.getTerm(AdapterTerms.LOGGER_PFM),
				() -> "execution time: " + monitorInfo.getExecutionTime() + "ms");
	}

}
