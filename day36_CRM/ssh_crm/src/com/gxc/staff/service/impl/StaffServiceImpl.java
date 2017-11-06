package com.gxc.staff.service.impl;

import java.util.List;

import com.gxc.staff.dao.StaffDao;
import com.gxc.staff.domain.CrmStaff;
import com.gxc.staff.service.StaffService;
import com.gxc.utils.MyStringUtils;

public class StaffServiceImpl implements StaffService {

	// Spring 注入
	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	//登录
	public CrmStaff login(CrmStaff staff) {
		//MD5加密
		String loginPwd = MyStringUtils.getMD5Value(staff.getLoginPwd());
		return staffDao.find(staff.getLoginName(), loginPwd);
	}

	@Override
	public List<CrmStaff> findAll() {
		List<CrmStaff> list = staffDao.findAll();
		return list;
	}
	
}
