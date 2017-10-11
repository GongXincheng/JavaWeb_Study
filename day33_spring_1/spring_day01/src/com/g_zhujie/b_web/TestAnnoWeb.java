package com.g_zhujie.b_web;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoWeb {
	
	@Test
	public void demo02(){
		//从spring容器获得
		String xmlPath = "com/g_zhujie/b_web/beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		StudentAction studentAction = (StudentAction) applicationContext.getBean("studentActionId");
		
		studentAction.execute();
		applicationContext.close();
	}

}
