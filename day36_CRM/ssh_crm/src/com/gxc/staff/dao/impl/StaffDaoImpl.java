package com.gxc.staff.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.staff.dao.StaffDao;
import com.gxc.staff.domain.CrmStaff;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

	@SuppressWarnings("unchecked")
	@Override
	public CrmStaff find(String loginName, String loginPwd) {
		
		String hql = "from CrmStaff where loginName=? and loginPwd=? ";
		List<CrmStaff> staffList = this.getHibernateTemplate().find(hql, loginName,loginPwd);
		if(staffList.size()==1){
			return staffList.get(0);
		}	
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmStaff> findAll() {
		List<CrmStaff> list = this.getHibernateTemplate().find("from CrmStaff");
		return list;
	}

	@Override
	public CrmStaff findById(String staffId) {
		return this.getHibernateTemplate().get(CrmStaff.class, staffId);
	}

}
