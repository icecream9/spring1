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
	//@Test
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
	//@Test
	public void testSetterDependencyInject(){
		BeanFactory beanFactory= new ClassPathXmlApplicationContext("hello.xml");
		HelloApi bean5=beanFactory.getBean("bean5",HelloApi.class);
		bean5.sayHello();
	}
	//@Test
	public void testBooleanBean(){
		BeanFactory beanFactory= new ClassPathXmlApplicationContext("hello.xml");
		HelloApi bean6=beanFactory.getBean("bean6",HelloApi.class);
		//System.out.println(bean6.isOk());
	}
	//@Test
	public void testListInject() {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("listInjext.xml");
		ListTestBean listBean=beanFactory.getBean("listBean",ListTestBean.class);
		System.out.println(listBean.getValues().size());
		
	}
	//@Test
	public void testSetInject() {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("listInjext.xml");
		SetTestBean setBean=beanFactory.getBean("setBean",SetTestBean.class);
		System.out.println(setBean.getValues().size());
		
	}
	
	
	//@Test
	public void testCollectionInject() {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("listInjext.xml");
		CollectionTestBean collectionBean=beanFactory.getBean("collectionBean",CollectionTestBean.class);
		System.out.println(collectionBean.getValues().size());
		
	}
	
	//@Test
	public void testArrayInject() {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("arrayInject.xml");
		ArrayTestBean arrayBean=beanFactory.getBean("arrayBean",ArrayTestBean.class);
		System.out.println(arrayBean.getArray().length);
		System.out.println(arrayBean.getArray2()[0].length);
		
	}
	
	@Test
	public void testMapInject() {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("mapInject.xml");
		MapTestBean mapBean=beanFactory.getBean("mapBean",MapTestBean.class);
		System.out.println(mapBean.getValues().size());
		System.out.println(mapBean.getValues().get("3"));
		
	}
//public static void main(String[] args) {
////	HelloTest test=new HelloTest();
////	test.testHelloWorld();
//	new HelloTest().test1();
//}
}