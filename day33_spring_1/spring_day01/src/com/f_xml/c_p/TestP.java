package com.f_xml.c_p;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP {
	
	@Test
	public void demo1() throws Exception{
		String xmlPath = "com/f_xml/c_p/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		Person person = applicationContext.getBean("personId",Person.class);
		System.out.println(person);
		
		applicationContext.getClass().getMethod("close").invoke(applicationContext);
	}
}
