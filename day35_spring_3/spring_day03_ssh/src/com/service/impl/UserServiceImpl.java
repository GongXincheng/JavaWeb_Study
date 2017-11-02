package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;

@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void register(User user) {
		userDao.save(user);
	}

}
