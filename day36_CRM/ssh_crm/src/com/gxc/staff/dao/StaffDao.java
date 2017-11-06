package com.gxc.staff.dao;

import java.util.List;

import com.gxc.staff.domain.CrmStaff;

public interface StaffDao {
	
	/**
	 * 通过用户名和密码查询
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName, String loginPwd);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmStaff> findAll();
}
