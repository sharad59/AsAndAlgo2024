package Queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/*The priority of the data in the cache changes according to the need
 *  of that data i.e. if some data is fetched or updated recently then 
 *  the priority of that data would be changed and assigned to the 
 *  highest priority, and the priority of the data decreases if it 
 *  remains unused operations after operations.
 * 
*/
public class LRUCache {

	int capacity;
	Map<Integer, CacheEntry> cache;
	Deque<CacheEntry> list;

	class CacheEntry {

		int key;
		int value;

		public CacheEntry(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	public LRUCache(int capacity) {
		this.capacity = capacity;

		cache = new HashMap<>();
		list = new LinkedList<>();

	}

	public int get(int key) {

		CacheEntry entry = cache.get(key);

		if (entry != null) {
			list.remove(entry);
			list.addFirst(entry);
		}

		return entry == null ? -1 : entry.value;
	}

	public void put(int key, int value) {
		CacheEntry entry = cache.get(key);

		if (entry == null && cache.size() == capacity) {

			CacheEntry deletedEntry = list.removeLast();
			cache.remove(deletedEntry.key);

		} else if (entry != null) {
			list.remove(entry);
			entry.value = value;
		}

		if (entry == null) {
			entry = new CacheEntry(key, value);
		}

		cache.put(key, entry);
		list.addFirst(entry);

	}

	public void displayCache() {
		Iterator<CacheEntry> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().key + " " + itr.next().value);
		}

	}

	public static void main(String args[]) {

		LRUCache c = new LRUCache(3);
		c.put(1, 2);
		c.put(3, 4);
		c.put(2, 2);
		c.put(3, 4);
		c.put(5, 1);

		c.get(2);
		c.displayCache();

	}
}
