package com.gxc.staff.dao.impl;

import java.util.List;

import com.gxc.base.impl.BaseDaoImpl;
import com.gxc.staff.dao.StaffDao;
import com.gxc.staff.domain.CrmStaff;

public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao {

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

}
