package com.gxc.department.dao;

import java.util.List;

import com.gxc.department.domain.CrmDepartment;

public interface DepartmentDao {
	
	public List<CrmDepartment> findAll();
	
}
