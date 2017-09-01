package com.github.jmodel.japp.service.search;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jmodel.adapter.config.Configuration;
import com.github.jmodel.adapter.config.ConfigurationLoader;
import com.github.jmodel.adapter.util.Util;
import com.github.jmodel.japp.Feature;
import com.github.jmodel.japp.JappException;
import com.github.jmodel.japp.Service;
import com.github.jmodel.japp.ServiceContext;

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
	protected String perform(ServiceContext ctx, String request, String... path) throws JappException {

		Configuration conf = ConfigurationLoader.getInstance().getConfiguration();

		String index = conf.getValue(INX, getRegionId(), path);
		String mappingURIForSearch = conf.getValue(IMAP, getRegionId(), path);
		String mappingURIForUI = conf.getValue(OMAP, getRegionId(), path);

		String featureUrl = conf.getValue(Feature.getRegionId(), "Search");
		Feature<?> feature = Util.find(featureUrl);
		if (feature == null) {
			throw new JappException("Search feature is not found");
		}
		
		try {
			JsonNode requestObj = ServiceContext.objectMapper.readTree(request);
			return (String) feature.perform(ctx, requestObj, index, mappingURIForSearch, mappingURIForUI);
		} catch (Exception e) {
			throw new JappException("Search service does not work", e);
		}
	}

	@Override
	public String getItemId() {
		return "Search";
	}

}
