package SimpleMap;

public interface ISimpleMap {
	void put(Object key, Object value);

	Object get(Object key);

	Object remove(Object key);

	int size();
}
