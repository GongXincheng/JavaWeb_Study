package com.d_scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	
	@SuppressWarnings("resource")
	@Test
	public void demo1(){
		
		String xmlPath = "com/d_scope/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = applicationContext.getBean("userServiceId", UserService.class);
		UserService userService2 = applicationContext.getBean("userServiceId", UserService.class);
		
		System.out.println(userService);
		System.out.println(userService2);
	}
	
}
