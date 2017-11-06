package com.gxc.department.service;

import java.util.List;

import com.gxc.department.domain.CrmDepartment;

public interface DepartmentService {
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<CrmDepartment> findAll();
}
