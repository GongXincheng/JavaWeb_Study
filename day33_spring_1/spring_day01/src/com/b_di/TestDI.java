package com.b_di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
	
	@SuppressWarnings("resource")
	@Test
	public void demo1(){
		//使用ApplicationContext加载配置文件
		String xmlPath = "com/b_di/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		BookService bookService = (BookService) applicationContext.getBean("BookServiceId");
		bookService.addBook();
	}
	
	
/*	@SuppressWarnings("deprecation")
	@Test
	public void demo2(){
		//使用BeanFactory加载配置文件
		String xmlPath = "com/b_di/beans.xml";
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
		BookService bookService = (BookService) beanFactory.getBean("BookServiceId");
		bookService.addBook();
	}*/
}
