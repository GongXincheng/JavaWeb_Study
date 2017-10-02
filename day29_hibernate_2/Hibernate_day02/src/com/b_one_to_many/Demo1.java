package com.b_one_to_many;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.domain.Customer;
import com.domain.Order;
import com.utils.HibernateUtils;
//测试 一对多关系
public class Demo1 {

	@Test	//保存操作
	//(inverse="false") 3条：insert，2条：update
	//=>(inverse="true") 3条：insert ：外键由Order维护
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
		
/*		c.getOrders().add(o1);	//Customer不再维护外键关系
		c.getOrders().add(o2); 						*/		
		
		o1.setCustomer(c);
		o2.setCustomer(c);
		
		session.save(c);
		session.save(o1);
		session.save(o2);
		
		//----------------------------------------------------
		
		transaction.commit();
		session.close();
		
	}
	
	@Test //删除							^	
	//结论：维护一方的对象时，会自动维护另一方的关系	|
	//如果将Customer配置文件中的 inverse="true"时，会报错
		//原因：Customer不再维护外键，直接删除Customer违反外键约束
	public void fun2(){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		//----------------------------------------------------
		
		Customer c = (Customer)session.get(Customer.class, 4);
		
		//当 inverse="true" 时
		Set<Order> set = c.getOrders();
		for(Order o : set){
			o.setCustomer(null);
		}
		
		session.delete(c);
		
		//----------------------------------------------------
		
		transaction.commit();
		session.close();
		
	}
}
