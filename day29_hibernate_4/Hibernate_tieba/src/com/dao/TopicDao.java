package com.dao;


import java.util.List;

import com.domain.Topic;

public interface TopicDao {
	public void save(Topic topic);
	public List<Topic> getAll();
	public List<Topic> findTtopic(String queryString); 
	/*public int getNumber();*/
}
