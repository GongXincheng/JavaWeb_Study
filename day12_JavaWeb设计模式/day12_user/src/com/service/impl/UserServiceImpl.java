package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.domain.User;
import com.service.dao.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User u = null;
		try {
			u = userDao.findUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
