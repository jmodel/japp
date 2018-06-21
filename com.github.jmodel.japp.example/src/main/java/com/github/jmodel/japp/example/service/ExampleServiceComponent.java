package com.github.jmodel.japp.example.service;

import com.github.jmodel.japp.api.Service;

import dagger.Component;

@Component
public interface ExampleServiceComponent {

	void inject(Service<String, String> service);
}