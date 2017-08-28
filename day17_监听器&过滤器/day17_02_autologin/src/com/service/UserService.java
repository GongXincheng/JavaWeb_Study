package com.service;

import java.sql.SQLException;

import com.dao.UserDao;
import com.domain.User;

public class UserService {

	UserDao userDao = new UserDao();
	
	public User findUser(String username, String password) {
		try {
			return userDao.findUser(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
