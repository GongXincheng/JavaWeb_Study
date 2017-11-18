package com.gxc.base;

import java.lang.reflect.ParameterizedType;

import com.gxc.classes.service.ClassesService;
import com.gxc.coursetype.service.CourseTypeService;
import com.gxc.department.service.DepartmentService;
import com.gxc.post.service.PostService;
import com.gxc.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author GXC
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	private static final long serialVersionUID = 5134278293138406699L;
	
	// 1.封装数据
	private T t;
	@Override
	public T getModel() {
		return t;
	}

	//1.1. 实例化t
	@SuppressWarnings("unchecked")
	public BaseAction(){
		try {
			//1.获得T运行时的Class
			ParameterizedType parameterizedType =  (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
			//2.反射创建实例
			t = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	// 2. Spring注入service
	/*
	 * 提供setter方法：让spring进行注入的
	 * 提供getter方法：让子类可以获得spring注入的对象的
	 */
	// 员 工
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	public StaffService getStaffService() {
		return staffService;
	}
	
	// 职 务
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	public PostService getPostService() {
		return postService;
	}
	
	// 部 门
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	
	// 课程类别
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	public CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}
	
	//班级
	private ClassesService classesService;
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}
	public ClassesService getClassesService() {
		return classesService;
	}
	
	//3.分页的数据
	//分页的数据
	private int pageNum = 1;
	private int pageSize = 2;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	//4.简化值栈操作
	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}
	
	public void set(String key, Object o){
		ActionContext.getContext().getValueStack().set(key, o);
	}
	
	public void put(String key, Object value){
		ActionContext.getContext().put(key, value);
	}
	
	public void putSession(String key, Object value){
		ActionContext.getContext().getSession().put(key, value);
	}
	
	public void putApplication(String key, Object value){
		ActionContext.getContext().getApplication().put(key, value);
	}
}
