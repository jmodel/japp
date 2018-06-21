package com.github.jmodel.japp.example.feature;

import javax.inject.Inject;

import com.github.jmodel.adapter.api.MonitorInfo;
import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.japp.JappException;
import com.github.jmodel.japp.api.Feature;

public class ExampleFeature extends Feature<String, String> {

	@Inject
	public ExampleFeature() {
	}

	@Override
	public Term getItemTerm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String perform(String inputObject, Object... args) throws JappException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void reportMe(MonitorInfo monitorInfo) {
		// TODO Auto-generated method stub

	}

}
