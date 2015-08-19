package com.maxcheung.simplemap.impl;

import java.util.concurrent.ConcurrentHashMap;

import com.maxcheung.simplemap.SimpleMap;

public class SimpleMapImpl implements SimpleMap {

	private static final int DEFAULT_MAX_SIZE = 100;
	private ConcurrentHashMap<Object, Object> map;
	private final int maxCapacity;

	public SimpleMapImpl() {
		this(DEFAULT_MAX_SIZE);
	}

	public SimpleMapImpl(int maxSize) {
		map = new ConcurrentHashMap<Object, Object>(maxSize);
		maxCapacity = maxSize;
	}

	public void put(Object key, Object value) {
		if (map.size() < maxCapacity) {
			map.put(key, value);
		}
	}

	public Object get(Object key) {
		return map.get(key);
	}

	public Object remove(Object key) {
		return map.remove(key);
	}

	public int size() {
		return map.size();
	}

}
