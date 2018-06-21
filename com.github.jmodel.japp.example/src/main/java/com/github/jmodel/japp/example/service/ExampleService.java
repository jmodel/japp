package com.github.jmodel.japp.example.service;

import javax.inject.Inject;

import com.github.jmodel.adapter.api.MonitorInfo;
import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.japp.JappException;
import com.github.jmodel.japp.api.Service;
import com.github.jmodel.japp.api.ServiceContext;
import com.github.jmodel.japp.example.feature.ExampleFeature;

public class ExampleService extends Service<String, String> {

	@Inject
	ExampleFeature exampleFeature;

	@Override
	public Term getItemTerm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String perform(ServiceContext<?> ctx, String request, String... path) throws JappException {
		DaggerExampleServiceComponent.create().inject(this);
		exampleFeature.serve(ctx, request);
		return null;
	}

	@Override
	protected void reportMe(MonitorInfo monitorInfo) {
		// TODO Auto-generated method stub

	}

}
