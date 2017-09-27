package com.a_hello;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class Test01 {
	
	@SuppressWarnings("unchecked")
	@Test
	public void show(){
		//加载Hibernate配置文件
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		//创建SessionFactory对象
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//得到Session对象
		Session session = sessionFactory.openSession();
		//得到Transaction（事务）对象
		Transaction transaction = session.beginTransaction();
		
		//方式1：
	/*	Criteria criteria = session.createCriteria(User.class);
		List<User> list = criteria.list();	*/
		
		//方式2：
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		
		//遍历集合中数据
		for(User user : list){
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getPassword());
			System.out.println("--------------");
		}
		
		//提交事务
		transaction.commit();
		//关闭session对象
		session.close();
		sessionFactory.close();
	}

	//将数据放到数据库
	@Test
	public void save() {
		Configuration configuration = new Configuration();
		//加载Hibernate配置文件
		configuration.configure("hibernate.cfg.xml");
		//创建SessionFactory对象
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//得到Session对象
		Session session = sessionFactory.openSession();
		//得到Transaction（事务）对象
		Transaction transaction = session.beginTransaction();
		
		User user = new User();
		user.setName("admin");
		user.setPassword("123");
		session.save(user);
		
		//提交事务
		transaction.commit();
		//关闭session对象
		session.close();
		sessionFactory.close();
	}
	
}
