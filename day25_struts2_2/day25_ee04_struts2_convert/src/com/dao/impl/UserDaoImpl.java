package com.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dao.UserDao;
import com.domain.User;
import com.util.C3P0Util;

public class UserDaoImpl implements UserDao {

	public User findUserByUsename(String username) {
		QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
		try {
			return qr.query("select * from user where username=?", new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public int addUser(User user) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			return qr.update("insert into user(username,password,birthday,hobby,married)values(?,?,?,?,?)",
					user.getUsername(),user.getPassword(),user.getBirthday(),user.getHobby(),user.isMarried());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
