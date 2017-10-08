package com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	static{
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		
/*		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				System.out.println("关闭，释放资源...");
				sessionFactory.close();
			}
		}));*/
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	public static Session getCurrenSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/*public static void main(String[] args) {
		System.out.println(openSession());
	}*/
}
