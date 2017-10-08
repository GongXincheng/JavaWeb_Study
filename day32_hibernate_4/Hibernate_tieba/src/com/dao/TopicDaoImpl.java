package com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.Reply;
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
	public List<Topic> findTtopic(String key) {
		Session session = HibernateUtil.getCurrenSession();
		
		Query query = session.createQuery("from Topic where title like :key");
		if(StringUtils.isBlank(key)){
			query.setString("key", "%");
		}else{
			query.setString("key", "%"+key+"%");
		}
		List<Topic> list = query.list();
		return list;
	}

	public Topic findTopicById(Integer id) {
		Session session = HibernateUtil.getCurrenSession();
		Topic topic = (Topic) session.get(Topic.class, id);
		return topic;
	}

	public void saveReply(Topic topic, Reply reply) {
		Session session = HibernateUtil.getCurrenSession();
		topic.getReplySet().add(reply);
		session.save(reply);
	}

}
