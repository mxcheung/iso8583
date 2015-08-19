package com.maxcheung.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.maxcheung.config.AppConfig;
import com.maxcheung.simplemap.SimpleMap;

public class App {
	private static final String key = "Hello";
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		SimpleMap obj = (SimpleMap) context.getBean("simpleMapBean");
		obj.put(key, "World");
		System.out.println("Hello : " + obj.get(key));

	}
}