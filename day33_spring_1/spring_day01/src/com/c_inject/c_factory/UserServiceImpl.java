package com.c_inject.c_factory;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("c_inject.c_factory addUser()..执行了！");
	}

}
