package com.github.jmodel.japp;

import com.github.jmodel.japp.api.Feature;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

	@Provides
	static Feature<String, String> provideFeature() {
		return null;
	}
}
