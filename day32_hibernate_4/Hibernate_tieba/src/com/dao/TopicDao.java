package com.dao;


import java.util.List;

import com.domain.Reply;
import com.domain.Topic;

public interface TopicDao {
	public void save(Topic topic);
	public List<Topic> getAll();
	public List<Topic> findTtopic(String queryString); 
	public Topic findTopicById(Integer id);
	public void saveReply(Topic topic,Reply reply);
}
