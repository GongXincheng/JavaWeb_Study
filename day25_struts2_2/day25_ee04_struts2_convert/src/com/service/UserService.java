package com.service;

import com.domain.User;

public interface UserService {
	
	public User findUserByUsername(String username);
	
	public int register(User user);
	
}
