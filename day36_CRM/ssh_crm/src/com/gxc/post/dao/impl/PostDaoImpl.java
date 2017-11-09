package com.gxc.post.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.gxc.department.domain.CrmDepartment;
import com.gxc.post.dao.PostDao;
import com.gxc.post.domain.CrmPost;

/**
 * @author GXC
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmPost> findAll(CrmDepartment department) {
		return this.getHibernateTemplate().find("from CrmPost where department = ?", department);
	}
	
}
