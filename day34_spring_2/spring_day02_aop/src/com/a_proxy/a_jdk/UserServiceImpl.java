package com.a_proxy.a_jdk;

//目标类
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("a_proxy.a_jdk____addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("a_proxy.a_jdk____updateUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("a_proxy.a_jdk____deleteUser");
	}

}
