package com.web.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dao.TopicDao;
import com.dao.TopicDaoImpl;
import com.domain.Reply;
import com.domain.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class TopicAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private TopicDao topicDao = new TopicDaoImpl();
	private Topic topic;
	private List<Topic> topicList;
	private String queryString;
	private Reply reply;
	
	//添加
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
	
	//查询全部
	public String list(){
		topicList = topicDao.getAll();
		return "List";
	}
	
	//条件查询
	public String search(){
		topicList = topicDao.findTtopic(queryString);
		return "List";
	}
	
	//回复列表
	public String show(){
		topic = topicDao.findTopicById(topic.getTid());
		return "replyList";
	}
	
	//添加回复
	public String addReply(){
		topic = topicDao.findTopicById(topic.getTid());
		//1.IP
		reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		//2.createDate
		reply.setCreateDate(new Date());
		topicDao.saveReply(topic, reply);
		return "replyList";
	}
	
	
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}
	
}
