package com.c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {

	
	@Test	//之前方法
	public void demo1(){
		MyBeanFactory myBeanFactory = new MyBeanFactory();
		UserService userService = myBeanFactory.createUserService();
		userService.addUser();
	}
	
	@SuppressWarnings("resource")
	@Test
	public void demo2(){
		String xmlPath = "com/c_inject/c_factory/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = applicationContext.getBean("userServiceId", UserService.class);
		userService.addUser();
	}
	
}
