package com.practice.lru.cache;

public class CacheMain {

	public static void main(String[] args) {

		LruCache lru = new LruCache();

		lru.put("1", "one");
		lru.put("2", "two");
		lru.put("3", "three");
		lru.put("4", "four");
		lru.put("5", "five");
		lru.put("6", "six");
		lru.put("7", "seven");

		System.out.println(lru.get("1"));
		System.out.println(lru.get("2"));
		System.out.println(lru.get("3"));
		System.out.println(lru.get("4"));
		System.out.println(lru.get("5"));
		System.out.println(lru.get("6"));
	}

}
