package com.gxc.mapper;

import java.util.List;
import com.gxc.entity.User;

public interface UserMapper {

	public User findUserById(Integer id);
	
	public List<User> findUserByUsername(String username);
	
	public int insertUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUserById(Integer id);
	
}
