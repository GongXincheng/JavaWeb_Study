package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utils.HibernateUtil;

public class TransactionFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//注意：获取当前线程的Session
		Session session = HibernateUtil.getCurrenSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			
			chain.doFilter(request, response);
			
			if(session!=null && session.isOpen()){
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(session!=null && session.isOpen()){
				transaction.rollback();
			}
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
