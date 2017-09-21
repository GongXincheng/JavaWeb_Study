package com.dao.impl;

import java.util.List;

import com.dao.IUserDao;
import com.domain.User;

public class UserDaoImplForOracle implements IUserDao {

	@Override
	public User selectUserByInfo(String logonName, String logonPwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Integer userID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectUserById(Integer userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectUserByCondition(String userName, String gender,
			String education, String isUpload) {
		// TODO Auto-generated method stub
		return null;
	}

}
