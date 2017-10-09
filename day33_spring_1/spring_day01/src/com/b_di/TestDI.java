package com.b_di;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void demo2(){
		//使用BeanFactory加载配置文件
		String xmlPath = "com/b_di/beans.xml";
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
		BookService bookService = (BookService) beanFactory.getBean("BookServiceId");
		bookService.addBook();
	}
}
