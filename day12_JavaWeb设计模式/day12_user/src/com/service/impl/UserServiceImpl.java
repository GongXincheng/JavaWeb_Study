package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.domain.User;
import com.exception.UserExistException;
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

	@Override
	public boolean findUserByName(String name) throws UserExistException {
		// TODO Auto-generated method stub
		boolean b = userDao.findUserByName(name);
		if(b){
			throw new UserExistException("用户名已存在");
		}
		
		return b;
	}

}
