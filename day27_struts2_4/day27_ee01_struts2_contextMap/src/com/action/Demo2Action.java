package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 利用ValueStack存数据
 * @author Administrator
 *
 */
public class Demo2Action extends ActionSupport {
	private static final long serialVersionUID = 5025129812146719761L;

	public String execute() throws Exception {
		//获取ValueStack对象的引用
		
		/*//step_1：获取HttpServletRequest对象，通过对象的getAttribute(),从域中取
		HttpServletRequest request = ServletActionContext.getRequest();
		//根据Key获取ValueStack对象的引用
		ValueStack vs1 = (ValueStack)request.getAttribute("struts.valueStack");
		System.out.println(vs1.hashCode());
		
		
		//step_2：先获取ActionContext对象，再取出requestMap，然后通过map的get方法获取
		//从ActionContext中获取Key为request的Map
		ActionContext context = ActionContext.getContext();
		Map<String, Object> requestMap = (Map<String, Object>)context.get("request");
		//从request的Map中，获取key为struts.valueStack的值(ValueStack对象的引用)
		ValueStack vs2 = (ValueStack)requestMap.get("struts.valueStack");
		System.out.println(vs2.hashCode());
		
		
		//step_3：使用ActionContext对象的方法直接获取ValueStack对象的引用
		ValueStack vs3 = context.getValueStack();
		System.out.println(vs3.hashCode());*/

		//栈的操作
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		//压栈操作
		vs.push(new Student("GXC",21));
		//出栈操作
		Student stu = (Student)vs.peek();
		System.out.println(stu.getName()+":"+stu.getAge());
		
		return SUCCESS;
	}
	
}
