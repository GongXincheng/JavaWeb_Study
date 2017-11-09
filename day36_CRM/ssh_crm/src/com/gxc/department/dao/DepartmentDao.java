package com.gxc.department.dao;

import java.util.List;

import com.gxc.department.domain.CrmDepartment;

public interface DepartmentDao {
	
	/**
	 * 查询全部部门
	 * @return
	 */
	public List<CrmDepartment> findAll();
	
}
