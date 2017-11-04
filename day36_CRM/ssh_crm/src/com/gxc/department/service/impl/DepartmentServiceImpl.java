package com.gxc.department.service.impl;

import com.gxc.department.dao.DepartmentDao;
import com.gxc.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	
	
}
