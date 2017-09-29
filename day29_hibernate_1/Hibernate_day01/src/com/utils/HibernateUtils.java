package com.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	static{
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		
		//关闭资源
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				 System.out.println("虚拟机关闭，释放资源");
				 sessionFactory.close();
			}
		}));
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/*
	 	public static void main(String[] args) {
			System.out.println(openSession());
		}
	*/
}
