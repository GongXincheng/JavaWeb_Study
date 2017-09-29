package com.a_hello;

import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.utils.HibernateUtils;

public class Test02 {
	
	@Test
	public void fun1(){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from User where password = 123");
		User user = (User)query.uniqueResult();
	
		user.setName("GXC");
		user.setPassword("123");
		session.update(user);

		transaction.commit();
		session.close();
		
	}
	
}
