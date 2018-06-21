package com.github.jmodel.japp.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.jmodel.japp.example.config.ExampleConfigurationLoader;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.github.jmodel.japp.example.mvc" })
public class ExampleApp extends WebMvcConfigurerAdapter {

	static {
		ExampleConfigurationLoader.getInstance().load();
	}

	public static void main(final String[] args) {
		SpringApplication.run(ExampleApp.class, args);
	}
}
