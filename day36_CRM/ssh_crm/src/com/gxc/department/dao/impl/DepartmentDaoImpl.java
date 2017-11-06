package com.gxc.department.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.department.dao.DepartmentDao;
import com.gxc.department.domain.CrmDepartment;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	/**
	 * 查询所有部门
	 */
	@SuppressWarnings("unchecked")
	public List<CrmDepartment> findAll() {
		return this.getHibernateTemplate().find("from CrmDepartment");
	}
	
}
