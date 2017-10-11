package com.f_xml.e_coll;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestColl {
	
	@SuppressWarnings("resource")
	@Test
	public void demo02() throws Exception{
		//spring 工厂
		String xmlPath = "com/f_xml/e_coll/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		CollData collData = (CollData) applicationContext.getBean("collDataId");
		System.out.println(collData);
	}

}
