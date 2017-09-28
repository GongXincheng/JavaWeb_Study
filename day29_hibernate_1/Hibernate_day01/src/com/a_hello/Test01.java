package com.a_hello;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Test01 {
	/**
	 * 查找
	 */
	@Test
	public void search(){
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//方法1：get()获取
		User user = (User) session.get(User.class, 1);
		
		//方法2：load()获取
		//User user = (User) session.load(User.class, 1);
		
		System.out.println(user);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	
	/**
	 * 删除
	 */
	@Test
	public void delete(){
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//获取到当前线程的session对象
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//方法1：
			//获取要删除的对象
			//User user = (User)session.get(User.class, 2);
		//方法2：
			User user = new User();
			user.setId(4);
			
		session.delete(user);
			
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * 更新表中数据
	 */
	@Test
	public void Update(){
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//获取到当前线程的session对象
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//查询出要修改的对象
		User user = (User) session.get(User.class, 2);
		user.setName("汤姆");
		session.update(user); 
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * 查询所有
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void show(){
		//加载Hibernate配置文件
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		//创建SessionFactory对象
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//得到Session对象
		Session session = sessionFactory.openSession();
		//得到Transaction（事务）对象
		Transaction transaction = session.beginTransaction();
		
		//方式1：
/*		Criteria criteria = session.createCriteria(User.class);
		List<User> list = criteria.list();							*/
		
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

	/**
	 * 将数据放到数据库
	 */
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
