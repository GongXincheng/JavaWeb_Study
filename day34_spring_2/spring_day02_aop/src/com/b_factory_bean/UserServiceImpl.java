package com.b_factory_bean;

//目标类
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("b_factory_bean____addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("b_factory_bean____updateUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("b_factory_bean____deleteUser");
	}

}
