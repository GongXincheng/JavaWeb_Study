package com.gxc.staff.service;

import com.gxc.staff.domain.CrmStaff;

public interface StaffService {

	/**
	 * 登录
	 * @param staff
	 * @return
	 */
	public CrmStaff login(CrmStaff staff);
	
}
