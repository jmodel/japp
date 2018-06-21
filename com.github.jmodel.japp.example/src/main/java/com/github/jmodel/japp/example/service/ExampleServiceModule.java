package com.github.jmodel.japp.example.service;

import com.github.jmodel.japp.example.feature.ExampleFeature;

import dagger.Module;
import dagger.Provides;

@Module
public class ExampleServiceModule {

	@Provides
	static ExampleFeature provideFeature() {
		return new ExampleFeature();
	}
}
