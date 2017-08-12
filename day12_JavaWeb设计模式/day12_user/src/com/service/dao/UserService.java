package com.service.dao;

import com.domain.User;
import com.exception.UserExistException;

public interface UserService {

	/**
	 * 注册用户
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * 根据用户名和密码查找用户信息
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 根据用户名查找用户是否存在
	 * @return
	 * @throws UserExistException
	 */
	public boolean findUserByName(String name) throws UserExistException;
}
