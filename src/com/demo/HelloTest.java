package com.demo;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	//@Test
	public void testHelloWorld() {
		// 1、读取配置文件实例化一个IoC容器
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"hello.xml");
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		HelloApi helloApi = context.getBean("hello", HelloApi.class);
		// 3、执行业务逻辑
		helloApi.sayHello();
		HelloApi name1=context.getBean("haha",HelloApi.class);
		name1.sayHello();
	}
	//@Test
	public void test1(){
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("hello.xml");
		HelloApi helloApi=beanFactory.getBean("haha", HelloApi.class);
		helloApi.sayHello();
		String[] beaStrings=beanFactory.getAliases("hello");
		for(String str:beaStrings){
			System.out.println(str);
		}
		Assert.assertEquals(1, beaStrings.length);
	}
//	@Test
	public void TestInstant(){
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("hello.xml");
		HelloApi bean1=beanFactory.getBean("bean1",HelloApi.class);
		bean1.sayHello();
		HelloApi bean2=beanFactory.getBean("bean2",HelloApi.class);
		bean2.sayHello();
	}
	//@Test
	public void testInstantiaingBeanByStaticFactory(){
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("hello.xml");
		HelloApi bean3=beanFactory.getBean("bean3",HelloApi.class);
		bean3.sayHello();
	}
	//@Test
	public void testInstanceBeanbyinstace(){
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("hello.xml");
		HelloApi bean4=beanFactory.getBean("bean4",HelloApi.class);
		bean4.sayHello();
	}
	@Test
	public void testContructorDependencyinjectTest(){
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("hello.xml");
		HelloApi byindex=beanFactory.getBean("byindex",HelloApi.class);
		byindex.sayHello();
		HelloApi byType=beanFactory.getBean("byType",HelloApi.class);
		byType.sayHello();
//		HelloApi byName=beanFactory.getBean("byName",HelloApi.class);
//		byName.sayHello();
		HelloApi byName1=beanFactory.getBean("byName1",HelloApi.class);
		byName1.sayHello();
	}
	
//public static void main(String[] args) {
////	HelloTest test=new HelloTest();
////	test.testHelloWorld();
//	new HelloTest().test1();
//}
}