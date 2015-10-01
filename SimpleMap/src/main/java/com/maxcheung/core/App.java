package com.maxcheung.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.maxcheung.config.AppConfig;
import com.maxcheung.simplemap.SimpleMap;

public class App {
    private static final String KEY = "Hello";
    private static ApplicationContext context;
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private App() {
    }

    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleMap obj = (SimpleMap) context.getBean("simpleMapBean");
        obj.put(KEY, "World");
        LOGGER.info("Hello : " + obj.get(KEY));
    }
}