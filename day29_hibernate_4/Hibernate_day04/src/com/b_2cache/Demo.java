package com.b_2cache;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.domain.Address;
import com.domain.Company;
import com.util.HibernateUtil;

public class Demo {
	
	@Test
	public void fun1(){
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		//----------------------------------------------------
		

		
		//----------------------------------------------------
		transaction.commit();
		session.close();
		
	}
	
}
