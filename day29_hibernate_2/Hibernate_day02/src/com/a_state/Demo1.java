package com.a_state;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.domain.User;
import com.utils.HibernateUtils;

public class Demo1 {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		//----------------------------------------------------
		
		User user = new User();		//瞬时态
		user.setName("Tom");		//瞬时态
		user.setPassword("123");	//瞬时态
		
		session.save(user);		//持久态
		
		//----------------------------------------------------
		
		transaction.commit();	//持久态
		session.close();
								//游离态(session关闭后)
	}
	
}
