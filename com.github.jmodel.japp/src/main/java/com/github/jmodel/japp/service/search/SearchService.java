package com.github.jmodel.japp.service.search;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jmodel.api.control.F;
import com.github.jmodel.api.control.Feature;
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

	@F(name = "SearchFeature")
	private Feature<?> searchFeature;

	@Override
	protected String perform(ServiceContext<?> ctx, String request, String... path) {

		String index = ctx.getConf().getValue(INX, getRegionId(), path);
		String mappingURIForSearch = ctx.getConf().getValue(IMAP, getRegionId(), path);
		String mappingURIForUI = ctx.getConf().getValue(OMAP, getRegionId(), path);

		try {
			JsonNode requestObj = JappUtil.mapper.readTree(request);
			return (String) searchFeature.perform(ctx, requestObj, index, mappingURIForSearch, mappingURIForUI);
		} catch (Exception e) {
			throw new RuntimeException("Search service does not work", e);
		}
	}

	@Override
	public String getItemId() {
		return "SearchService";
	}

}
