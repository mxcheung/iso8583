package com.maxcheung.simplemap.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SimpleMapImplTest {

    private static final String WORLD = "World";
    private static final String HELLO = "Hello";
    SimpleMapImpl sm;

    @Before
    public void setUp() {
        sm = new SimpleMapImpl();
    }

    @Test
    public void shouldGetItem() {
        String key = HELLO;
        sm.put(key, WORLD);
        assertEquals(WORLD, sm.get(key));
        assertEquals(1, sm.size());
    }

    @Test
    public void shouldRemoveItem() {
        String key = HELLO;
        sm.put(key, WORLD);
        assertEquals(WORLD, sm.get(key));
        assertEquals(1, sm.size());
        sm.remove(key);
        assertEquals(0, sm.size());
    }

    @Test
    public void shouldNotRemoveUnknownKey() {
        String key = HELLO;
        sm.put(key, WORLD);
        assertEquals(WORLD, sm.get(key));
        assertEquals(1, sm.size());
        sm.remove("Unknown");
        assertEquals(1, sm.size());
    }

    @Test
    public void shouldReplaceItem() {
        String key = HELLO;
        String replace = "There";
        sm.put(key, WORLD);
        sm.put(key, replace);
        assertEquals(replace, sm.get(key));
        assertEquals(1, sm.size());
    }

    @Test
    public void shouldReachMaxItems() {
        String key = HELLO;
        int maxSize = 100;
        sm = new SimpleMapImpl(maxSize);
        sm.put(key, WORLD);
        assertEquals(WORLD, sm.get(key));
        assertEquals(1, sm.size());

        for (int i = 1; i < 200; i++) {
            sm.put(i, WORLD);
        }
        assertEquals(maxSize, sm.size());
    }
}
