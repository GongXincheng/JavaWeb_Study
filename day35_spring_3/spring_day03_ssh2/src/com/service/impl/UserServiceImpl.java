package com.service.impl;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void register(User user) {
		userDao.save(user);
	}

}
