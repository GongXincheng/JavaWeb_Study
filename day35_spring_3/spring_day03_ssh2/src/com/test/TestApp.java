package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.User;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestApp {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void demo01(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setAge(122);
		
		userService.register(user);
	}
}
