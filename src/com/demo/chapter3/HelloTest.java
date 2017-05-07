package com.demo.chapter3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.HelloApi;

public class HelloTest {
	// @Test
	public void testBeanInject() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/beanInject.xml");
		HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();
	}

	@Test
	public void testLocalAndParentBeanInject() {
		ApplicationContext parentBeanFactory = new ClassPathXmlApplicationContext(
				"chapter3/parentBeanInject.xml");
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				new String[] { "chapter3/localBeanInject.xml" },
				parentBeanFactory);
		HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
		bean1.sayHello();// local
		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();// parent
	}
	//@Test
	public void testInnerBeanInject() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"chapter3/innerBeanInject.xml");
		HelloApi beanApi=context.getBean("bean",HelloApi.class);
		beanApi.sayHello();

	}
}
