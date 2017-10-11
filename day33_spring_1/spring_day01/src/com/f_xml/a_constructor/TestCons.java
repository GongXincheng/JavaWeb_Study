package com.f_xml.a_constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCons {
	
	@Test
	public void demo1() throws Exception{
		
		String xmlPath = "com/f_xml/a_constructor/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		User user = applicationContext.getBean("userId", User.class);
		System.out.println(user);
		
		applicationContext.getClass().getMethod("close").invoke(applicationContext);
	}
	
}
