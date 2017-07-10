public class LFUCache {

	private static final int DEFAULT_MAX_SIZE = 3;
	private int capacity = DEFAULT_MAX_SIZE;

	// 保存缓存的访问频率和上次访问时间
	private final Map<Integer, HitRate> cache = new HashMap<>(); 
	// 保存缓存的key - value pairs
	private final Map<Integer, Integer> KV = new HashMap<Integer, Integer>();

	public LFUCache(int capacity) {
		this.capacity = capacity; 
	}

	public void set(int key, int value) {
		if (! KV.containsKey(key)) {
			if (cache.size() == capacity) { 
				Integer k = getKickedKey(); 
				KV.remove(k); 
				cache.remove(k);
			}
			cache.put(key, new HitRate(key, 1, System.nanoTime())); 
		} else {
			HitRate hitRate = cache.get(key); 
			hitRate.hitCount += 1; 
			hitRate.lastTime = System.nanoTime();
		}
		KV.put(key, value); 
	}

	public int get(int key) { 
		Integer v = KV.get(key); 
		if (v != null) {
			HitRate hitRate = cache.get(key); 
			hitRate.hitCount += 1; 
			hitRate.lastTime = System.nanoTime(); 
			return v;
		}
		return -1; 
	}

	private Integer getKickedKey() {
		HitRate min = Collections.min(cache.values());
		return min.key; 
	}

}

class HitRate implements Comparable<HitRate> { 
	Integer key;
	Integer hitCount;
	public HitRate(Integer key, Integer hitCount, Long lastTime) { 
		this.key = key;
		this.hitCount = hitCount;
		this.lastTime = lastTime; 
	}
	public int compareTo(HitRate o) {
		int hr = hitCount.compareTo(o.hitCount);
		return hr != 0 ? hr : lastTime.compareTo(o.lastTime);
	} 
}
