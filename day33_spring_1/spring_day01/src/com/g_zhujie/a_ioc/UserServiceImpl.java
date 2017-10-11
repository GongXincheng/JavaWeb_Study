package com.g_zhujie.a_ioc;

import org.springframework.stereotype.Component;

@Component("userServiceId")
public class UserServiceImpl implements UserService {

	public void addUser() {
		System.out.println("UserServiceImpl____addUser()执行了...");
	}

}
