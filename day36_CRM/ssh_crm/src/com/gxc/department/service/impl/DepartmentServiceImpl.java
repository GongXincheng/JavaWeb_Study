package com.gxc.department.service.impl;

import java.util.List;

import com.gxc.department.dao.DepartmentDao;
import com.gxc.department.domain.CrmDepartment;
import com.gxc.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	/**
	 * 查询全部
	 */
	public List<CrmDepartment> findAll() {
		return departmentDao.findAll();
	}
	
	
	
}
