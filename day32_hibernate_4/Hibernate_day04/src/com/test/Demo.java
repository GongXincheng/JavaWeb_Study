package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.domain.Customer;
import com.util.HibernateUtil;

public class Demo {
	
	@Test
	public void fun1(){
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println(session);
		
		transaction.commit();
		session.close();
		
	}
	
	
	@Test
	public void fun2(){
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer c = new Customer();
		c.setName("Tom");
		session.save(c);
		
		transaction.commit();
		session.close();
		
	}
}
