package com.f_xml.d_spel;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpEL {
	
	@Test
	public void demo1() throws Exception{
		
		String xmlPath = "com/f_xml/d_spel/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		Customer customer = applicationContext.getBean("customerId", Customer.class);
		System.out.println(customer);
		
		applicationContext.getClass().getMethod("close").invoke(applicationContext);
	}
	
}
