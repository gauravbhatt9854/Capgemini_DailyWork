package com.igate.labs;

import java.util.HashMap;

class UsernameExistsException extends RuntimeException {

}

public class UsernamePasswordMap extends HashMap<String, String> {

	@Override
	public String get(Object key) {
		String string = super.get(key);
		StringBuilder reverse = new StringBuilder(string).reverse();
		return reverse.toString();
	}

	@Override
	public String put(String key, String value) {
		if (containsKey(key))
			throw new UsernameExistsException();
		String rev = new StringBuilder(value).reverse().toString();
		return super.put(key, rev);
	}

	public static void main(String[] args) {
		UsernamePasswordMap map = new UsernamePasswordMap();
		map.put("user1", "password");
		map.put("user2", "hello");
		map.put("user3", "reverse");
		map.put("user3", "reverse");
		System.out.println(map);
	}
}
