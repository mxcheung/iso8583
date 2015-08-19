package com.maxcheung.simplemap.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SimpleMapImplTest {

	SimpleMapImpl sm;
	
	@Before
	public void setUp() {
		sm = new SimpleMapImpl();
	}

	@Test
	public void shouldGetItem() {
		String key = "Hello";
		sm.put(key, "World");
		assertEquals("World", sm.get(key));
		assertEquals(1, sm.size());
	}
	
	@Test
	public void shouldRemoveItem() {
		String key = "Hello";
		sm.put(key, "World");
		assertEquals("World", sm.get(key));
		assertEquals(1, sm.size());
		sm.remove(key);
		assertEquals(0, sm.size());
	}

	@Test
	public void shouldNotRemoveUnknownKey() {
		String key = "Hello";
		sm.put(key, "World");
		assertEquals("World", sm.get(key));
		assertEquals(1, sm.size());
		sm.remove("Unknown");
		assertEquals(1, sm.size());
	}

	@Test
	public void shouldReplaceItem() {
		String key = "Hello";
		String replace = "There";
		sm.put(key, "World");
		sm.put(key, replace);
		assertEquals(replace, sm.get(key));
		assertEquals(1, sm.size());
	}

	@Test
	public void shouldReachMaxItems() {
		String key = "Hello";
		int maxSize = 100;
		sm = new SimpleMapImpl(maxSize);
		sm.put(key, "World");
		assertEquals("World", sm.get(key));
		assertEquals(1, sm.size());

		for (int i = 1; i < 200; i++) {
			sm.put(i, "World");
		}
		assertEquals(maxSize, sm.size());
	}
}
