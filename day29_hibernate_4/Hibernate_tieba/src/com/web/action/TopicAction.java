package com.web.action;

import java.util.Date;
import org.apache.struts2.ServletActionContext;
import com.dao.TopicDao;
import com.dao.TopicDaoImpl;
import com.domain.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class TopicAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private TopicDao topicDao = new TopicDaoImpl();
	private Topic topic;
	
	public String add(){
		//1. ip
		topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		//2. 创建/回帖时间
		topic.setCreateDate(new Date());
		topic.setLastReplyDate(topic.getCreateDate());
		//3. 保存
		topicDao.save(topic);
		return "toList";
	}

	public String list(){
		
		return SUCCESS;
	}
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
