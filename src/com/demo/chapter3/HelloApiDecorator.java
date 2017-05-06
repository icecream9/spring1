package com.demo.chapter3;

import com.demo.HelloApi;

public class HelloApiDecorator implements HelloApi {
	private HelloApi helloApi;
	public HelloApiDecorator() {
		// TODO Auto-generated constructor stub
	}
	public HelloApiDecorator(HelloApi helloApi) {
		this.helloApi=helloApi;
	}
	public void setHelloApi(HelloApi helloApi) {
		this.helloApi = helloApi;
	}
	@Override
	public void sayHello() {
		System.out.println("======");
		helloApi.sayHello();
		System.out.println("=====");

	}

}
