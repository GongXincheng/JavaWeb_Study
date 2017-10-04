package com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.Topic;
import com.utils.HibernateUtil;

public class TopicDaoImpl implements TopicDao {

	public void save(Topic topic) {
		Session session = HibernateUtil.getCurrenSession();
		session.save(topic);
	}

	@SuppressWarnings("unchecked")
	public List<Topic> getAll() {
		Session session = HibernateUtil.getCurrenSession();
		Query query = session.createQuery("from Topic");
		List<Topic> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Topic> findTtopic(String queryString) {
		Session session = HibernateUtil.getCurrenSession();
		
		System.out.println(StringUtils.isBlank(queryString));
		if(StringUtils.isBlank(queryString)){
			Query query = session.createQuery("from Topic");
			List<Topic> list = query.list();
			return list;
		}
		
		Query query = session.createQuery("select t from Topic t where t.title like '%" + queryString +"%'");
		List<Topic> list = query.list();
		
		return list;
	}

	/*@Override
	public int getNumber() {
		Session session = HibernateUtil.getCurrenSession();
		Query query = session.createQuery("select count(*) from Topic");
		int num = Integer.parseInt(query.uniqueResult().toString());
		return num;
	}*/

}
