package com.gxc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gxc.entity.User;
import com.gxc.mapper.UserMapper;

public class TestSM {

	@SuppressWarnings("resource")
	@Test
	public void testName() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = ac.getBean(UserMapper.class);
		User user = userMapper.selectUserById(10);
		System.out.println(user);
	}
	
}
