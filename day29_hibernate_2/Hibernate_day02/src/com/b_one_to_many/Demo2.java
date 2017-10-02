package com.b_one_to_many;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.domain.Customer;
import com.domain.Order;
import com.utils.HibernateUtils;
//测试 一对多关系
public class Demo2 {

	@Test
	//增加
	//希望保存Customer时，自动将未保存的Orders当中的Order保存
	//cascade="save-update"  inverse="true"
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
		
		c.getOrders().add(o1);	//弃维护外键关系
		c.getOrders().add(o2); 		
		o1.setCustomer(c);		//维护外键关系
		o2.setCustomer(c);
		
		session.save(c);
		
		//----------------------------------------------------
		transaction.commit();
		session.close();
		
	}
	
	@Test
	//修改
	//cascade="save-update" inverse="true"
	public void fun2(){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		//----------------------------------------------------
		
		Customer c = (Customer)session.get(Customer.class, 14);//1条select

		Set<Order> set = c.getOrders();//1条select
		for(Order s : set){
			s.setName("娃哈哈");	//修改订单
		}
		
		//----------------------------------------------------
		transaction.commit();	//设置了级联修改，自动将订单的修改保存到数据库：update语句
		session.close();
	}
	
	@Test
	//删除
	//cascade="delete"	inverse="false"
	//删除Customer时，会将Customer下的订单一并删除.
	public void fun3(){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		//----------------------------------------------------
		
		Customer c = (Customer) session.get(Customer.class, 10);//1条select
		session.delete(c);
		
		//----------------------------------------------------
		
		transaction.commit();
		session.close();
	}
	
	@Test
	//删除 ( 操作的两方 cascade="delete" )
	//注意：千万不要在两方配置级联删除,删除任何一方,会导致整个关系链全部删除
	public void fun4(){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		//----------------------------------------------------
		
		Order o = (Order) session.get(Order.class, 17);
		session.delete(o);
		
		//----------------------------------------------------
		
		transaction.commit();
		session.close();
	}
}
