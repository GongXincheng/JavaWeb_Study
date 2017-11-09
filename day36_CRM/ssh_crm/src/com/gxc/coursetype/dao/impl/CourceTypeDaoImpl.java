package com.gxc.coursetype.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.coursetype.dao.CourceTypeDao;
import com.gxc.coursetype.domain.CrmCourseType;

public class CourceTypeDaoImpl extends HibernateDaoSupport implements CourceTypeDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCourseType> findAll() {
		return this.getHibernateTemplate().find("from CrmCourseType");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCourseType> findAll(String condition, Object[] params) {
		String hql = "from CrmCourseType where 1=1 "+condition;
		return this.getHibernateTemplate().find(hql,params);
	}

	@Override
	public void saveOrUpdate(CrmCourseType courseType) {
		this.getHibernateTemplate().saveOrUpdate(courseType);
	}

	@Override
	public CrmCourseType findById(String courseTypeId) {
		return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);
	}

	
}
