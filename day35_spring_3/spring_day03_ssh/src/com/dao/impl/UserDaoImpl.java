package com.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.UserDao;
import com.domain.User;

public class UserDaoImpl implements UserDao {

	//需要Spring注入模板
	HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

}
