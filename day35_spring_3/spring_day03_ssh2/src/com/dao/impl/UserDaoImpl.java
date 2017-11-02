package com.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.dao.UserDao;
import com.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

}
