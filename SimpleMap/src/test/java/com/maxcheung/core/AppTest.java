package com.maxcheung.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maxcheung.config.AppConfig;
import com.maxcheung.simplemap.SimpleMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

	@Autowired
	private SimpleMap sm;

	@Test
	public void shouldGetItem() {
		String key = "Hello";
		sm.put(key, "World");
		assertEquals("World", sm.get(key));
		assertEquals(1, sm.size());
	}

}
