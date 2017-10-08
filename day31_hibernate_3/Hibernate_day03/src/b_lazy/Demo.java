package b_lazy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.domain.Customer;
import com.util.HibernateUtil;

public class Demo {
	
	@Test	//类级别懒加载:load方法
	// <class name="Customer" table="t_customer" lazy="true">
	public void fun1(){
		
		Session session = HibernateUtil.openSession(  );
		Transaction transaction = session.beginTransaction();
		//---------------------------------------------------
		Customer c = (Customer)session.load(Customer.class, 1);		
		System.out.println(c.getName());
		//---------------------------------------------------
		transaction.commit();
		session.close();
		
	}
	
}
