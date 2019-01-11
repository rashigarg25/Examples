package com.practice.lru.cache;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

	private Map<String, Entry> lruCache = new HashMap<>();

	private final int LRU_LIMIT = 5;

	private Entry start;
	private Entry end;

	public String get(String key) {

		if (lruCache.containsKey(key)) {
			removeEntry(lruCache.get(key));
			putHead(lruCache.get(key));
			return lruCache.get(key).getValue();
		}
		return null;
	}

	public void put(String key, String value) {

		if (lruCache.containsKey(key)) {
			removeEntry(lruCache.get(key));
			putHead(lruCache.get(key));
		} else {
			Entry entry = new Entry();
			entry.setRight(start);
			entry.setKey(key);
			entry.setValue(value);
			if (lruCache.size() == LRU_LIMIT) {
				lruCache.remove(end.getKey());
				removeEntry(end);
			}
			putHead(entry);
			lruCache.put(key, entry);
		}
	}

	private void removeEntry(Entry entry) {

		if (entry.getLeft() != null) {
			entry.getLeft().setRight(entry.getRight());
		} else {
			start = entry.getRight();
		}

		if (entry.getRight() != null) {
			entry.getRight().setLeft(entry.getLeft());
		} else {
			end = entry.getLeft();
		}
	}

	private void putHead(Entry entry) {
		if (start != null) {
			start.setLeft(entry);
		}
		entry.setRight(start);
		start = entry;

		if (end == null) {
			end = start;
		}
	}
}
