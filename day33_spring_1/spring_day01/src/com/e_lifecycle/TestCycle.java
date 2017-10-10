package com.e_lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {
	
	
	@Test
	public void demo1() throws Exception{
		
		String xmlPath = "com/e_lifecycle/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = applicationContext.getBean("userServiceId", UserService.class);
		userService.addUser();
		
		//要求：1.容器必须close，才能执行销毁方法，2.必须是单例的(scope="singleton")
		applicationContext.getClass().getMethod("close").invoke(applicationContext);
	}
	
}
