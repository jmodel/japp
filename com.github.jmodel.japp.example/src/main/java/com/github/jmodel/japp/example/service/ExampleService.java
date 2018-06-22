package com.github.jmodel.japp.example.service;

import com.github.jmodel.adapter.api.MonitorInfo;
import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.japp.JappException;
import com.github.jmodel.japp.api.Feature;
import com.github.jmodel.japp.api.Japp;
import com.github.jmodel.japp.api.Service;
import com.github.jmodel.japp.api.ServiceContext;
import com.github.jmodel.japp.example.JappExampleTerms;

public class ExampleService extends Service<String, String> {

	@Override
	public Term getItemTerm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String perform(ServiceContext<?> ctx, String request, String... path) throws JappException {
		
		Feature<String, String> exampleFeature = Japp.getFeature(JappExampleTerms.SERVICE_EXAMPLE);
		exampleFeature.serve(ctx, request);
		return null;
	}

	@Override
	protected void reportMe(MonitorInfo monitorInfo) {
		// TODO Auto-generated method stub

	}

}
