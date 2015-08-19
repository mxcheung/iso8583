package com.maxcheung.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxcheung.simplemap.SimpleMap;
import com.maxcheung.simplemap.impl.SimpleMapImpl;

@Configuration
public class AppConfig {

	@Bean(name = "simpleMapBean")
	public SimpleMap simpleMap() {
		return new SimpleMapImpl();
	}
}