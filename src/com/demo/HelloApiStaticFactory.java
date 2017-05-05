package com.demo;

public class HelloApiStaticFactory {
	public static HelloApi newInstance(String message) {
		return new HelloImpl2(message);
	}

}
