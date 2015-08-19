package SimpleMapImpl;

import java.util.concurrent.ConcurrentHashMap;

import SimpleMap.ISimpleMap;

public class SimpleMap implements ISimpleMap {

	ConcurrentHashMap<Object, Object> cache;
	
	public static final int DEFAULT_MAX_SIZE = 100;
	private final int maxCapacity;
	

	public SimpleMap() {
		this(DEFAULT_MAX_SIZE);
	}

	public SimpleMap(int maxSize) {
		cache = new ConcurrentHashMap<Object, Object>(maxSize);
		maxCapacity = maxSize;
	}

	  
    
	public void put(Object key, Object value) {
		if (cache.size() < maxCapacity) {
			cache.put(key, value);
		}

	}

	public Object get(Object key) {
		return cache.get(key);
	}

	public Object remove(Object key) {
		return cache.remove(key);
	}

	public int size() {
		// TODO Auto-generated method stub
		return cache.size();
	}

}
