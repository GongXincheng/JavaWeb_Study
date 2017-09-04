package com.dao;

import com.domain.User;

public interface UserDao {
	/**
	 * 根据用户名查询该用户
	 * @param username
	 * @return
	 */
	public User findUserByUsename(String username);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
}
