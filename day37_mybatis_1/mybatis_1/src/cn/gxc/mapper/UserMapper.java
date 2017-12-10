package cn.gxc.mapper;

import java.util.List;
import cn.gxc.entity.User;

public interface UserMapper {

	//根据用户ID查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据用户名称模糊查询用户列表
	public List<User> findUsersByName(String username) throws Exception;
	
	//添加用户
	public void insertUser(User user) throws Exception;
	
}
