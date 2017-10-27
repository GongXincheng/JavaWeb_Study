package com.c_spring_aop;

//目标类
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("c_spring_aop____addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("c_spring_aop____updateUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("c_spring_aop____deleteUser");
	}

}
