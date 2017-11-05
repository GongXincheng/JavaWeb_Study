package com.gxc.staff.dao;

import com.gxc.staff.domain.CrmStaff;

public interface StaffDao {
	
	/**
	 * 通过用户名和密码查询
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName, String loginPwd);
	
}
