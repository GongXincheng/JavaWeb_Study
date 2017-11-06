package com.gxc.staff.service;

import java.util.List;

import com.gxc.staff.domain.CrmStaff;

public interface StaffService {

	/**
	 * 登录
	 * @param staff
	 * @return
	 */
	public CrmStaff login(CrmStaff staff);
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<CrmStaff> findAll();

	/**
	 * 根据Id查询
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);
}
