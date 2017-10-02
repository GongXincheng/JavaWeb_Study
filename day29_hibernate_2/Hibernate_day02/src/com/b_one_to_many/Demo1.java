package com.b_one_to_many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.domain.Customer;
import com.domain.Order;
import com.utils.HibernateUtils;
//测试 一对多关系
public class Demo1 {

	@Test	//保存操作
	//出现2条sql语句：
	//3条：insert
	//2条：update
	public void fun1(){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		//----------------------------------------------------
		
		Customer c = new Customer();
		c.setName("tom");
		Order o1 = new Order();
		o1.setName("肥皂");
		Order o2 = new Order();
		o2.setName("蜡烛");
		
		c.getOrders().add(o1);
		c.getOrders().add(o2);
		o1.setCustomer(c);
		o2.setCustomer(c);
		
		session.save(c);
		session.save(o1);
		session.save(o2);
		
		//----------------------------------------------------
		
		transaction.commit();
		session.close();
		
	}
	
}
