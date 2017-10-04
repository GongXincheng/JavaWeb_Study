package com.dao;

import org.hibernate.Session;
import com.domain.Topic;
import com.utils.HibernateUtil;

public class TopicDaoImpl implements TopicDao {

	public void save(Topic topic) {
		Session session = HibernateUtil.getCurrenSession();
		session.save(topic);
	}

}
