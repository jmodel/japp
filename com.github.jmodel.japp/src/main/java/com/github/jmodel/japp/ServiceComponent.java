package com.github.jmodel.japp;

import com.github.jmodel.japp.api.Service;

import dagger.Component;

@Component
public interface ServiceComponent {
	
	void inject(Service<?, ?> service);
}