package com.a_ont_to_one;

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
			Company c = new Company();
			c.setName("潍坊学院");
			Address addr = new Address();
			addr.setName("奎文区");
			
			addr.setCompany(c);
			
			session.save(c);
			session.save(addr);
		//----------------------------------------------------
		transaction.commit();
		session.close();
		
	}
	
}
