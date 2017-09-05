package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.domain.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao  = new UserDaoImpl();
	
	public User findUserByUsername(String username) {
		return userDao.findUserByUsename(username);
	}

	public int register(User user) {
		return userDao.addUser(user);
	}

}
