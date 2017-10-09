package com.c_inject.c_factory;

/**
 * 实例工厂
 * @author Administrator
 */
public class MyBeanFactory {

	public UserService createUserService(){
		return new UserServiceImpl();
	}
	
}
