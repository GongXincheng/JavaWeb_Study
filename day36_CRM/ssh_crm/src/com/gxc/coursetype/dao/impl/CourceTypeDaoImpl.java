package com.gxc.coursetype.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.coursetype.dao.CourceTypeDao;
import com.gxc.coursetype.domain.CrmCourseType;
import com.gxc.page.PageHibernateCallback;

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

	
	@SuppressWarnings("unchecked")
	@Override
	public int getTotalRecord(String condition, Object[] params) {
		String hql = "select count(c) from CrmCourseType c where 1=1 " + condition;
		List<Long> list = this.getHibernateTemplate().find(hql,params);
		return list.get(0).intValue();
	}

	
	@Override
	public List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize) {
		String hql = "from CrmCourseType where 1=1 "+condition;
		List<CrmCourseType> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CrmCourseType>().setHql(hql).setParams(params).setStartIndex(startIndex).setPageSize(pageSize));
		return list;
	}

	
}
