package SimpleMapImpl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleMapImplTest {

	SimpleMap sm = new SimpleMap();

	@Before
	public void setUp() {
		sm = new SimpleMap();
	}

	@Test
	public void shouldGetItem() {
		String key = "Hello";
		sm.put(key, "World");
		assertEquals("World", sm.get(key));
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
		sm = new SimpleMap(maxSize);
		sm.put(key, "World");
		assertEquals("World", sm.get(key));
		assertEquals(1, sm.size());

		for (int i = 1; i < 200; i++) {
			sm.put(i, "World");
		}
		assertEquals(maxSize, sm.size());
	}

}
