package com.a_proxy.b_cglib;

import org.junit.Test;

public class Test_cglib {

	@Test
	public void demo01(){
		UserServiceImpl userService = MyBeanFactory.createUserService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
	@Test
	public void demo02(){
		UserServiceImpl userService = MyBeanFactory2.getUserService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
	
}
