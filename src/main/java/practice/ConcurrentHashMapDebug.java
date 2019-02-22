package practice;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDebug {
	public static void main(String[] args) {
		ConcurrentHashMap<Key, Integer> concurrentHashMap = new ConcurrentHashMap<Key, Integer>(16);
		for (int i = 0; i < 10; i++) {
			concurrentHashMap.put(new Key(1 + i * 10), 1 + i * 10);
		}
	}
}
