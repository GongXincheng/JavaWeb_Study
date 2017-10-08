package a_com.many_to_many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.domain.Course;
import com.domain.Student;
import com.util.HibernateUtil;

public class Demo {
	
	@Test
	// Student维护外键:
	// 		Student.hbm.xml => inverse="false" cascade="all"
	//		Course.hbm.xml => inverse="true"
	public void fun1(){
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		//---------------------------------------------------
		
		Student s1 = new Student();
		s1.setName("Tom");
		Student s2 = new Student();
		s2.setName("Jerry");
		
		Course c1 = new Course();
		c1.setName("Struts2");
		Course c2 = new Course();
		c2.setName("Hibernate");
		Course c3 = new Course();
		c3.setName("Spring");
		
		s1.getCourses().add(c1);
		s1.getCourses().add(c2);
		s1.getCourses().add(c3);
		s2.getCourses().add(c1);
		s2.getCourses().add(c2);
		s2.getCourses().add(c3);
		
		session.save(s1);
		session.save(s2);
		
		//---------------------------------------------------
		transaction.commit();
		session.close();
		
	}
	
}
