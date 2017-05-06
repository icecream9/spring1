package com.demo.chapter3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.HelloApi;

public class HelloTest {
	@Test
	public void testBeanInject() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/beanInject.xml");
		HelloApi bean1=beanFactory.getBean("bean1",HelloApi.class);
		bean1.sayHello();
		HelloApi bean2=beanFactory.getBean("bean2",HelloApi.class);
		bean2.sayHello();

	}

}
