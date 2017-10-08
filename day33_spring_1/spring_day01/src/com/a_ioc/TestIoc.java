package com.a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	
	@Test
	public void demo1(){
		UserService userService = new UserServiceImpl();
		userService.addUser();
	}
	
	@SuppressWarnings("resource")
	@Test
	public void demo2(){
		//1.获取spring容器
		String xmlPath = "com/a_ioc/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		//2.获得内容-不需要自己new
		UserService userService = (UserService) applicationContext.getBean("UserServiceId");
		userService.addUser();
	}
	
}
