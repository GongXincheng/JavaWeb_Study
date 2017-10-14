package com.a_proxy.a_jdk;

import org.junit.Test;

public class TestJDK {

	@Test
	public void demo01(){
		UserService userService = MyBeanFactory.createUserService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
}
