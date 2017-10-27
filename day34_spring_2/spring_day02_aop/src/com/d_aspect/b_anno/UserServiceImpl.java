package com.d_aspect.b_anno;

import org.springframework.stereotype.Service;

//目标类
@Service("userServiceId")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("d_aspect.b_anno____addUser");
	}

	@Override
	public void updateUser() {
		System.out.println("d_aspect.b_anno____updateUser");
//		int i = 1/0;
	}

	@Override
	public void deleteUser() {
		System.out.println("d_aspect.b_anno____deleteUser");
	}

}
