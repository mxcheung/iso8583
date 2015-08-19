package com.maxcheung.simplemap;

public interface SimpleMap {
	void put(Object key, Object value);

	Object get(Object key);

	Object remove(Object key);

	int size();
}
