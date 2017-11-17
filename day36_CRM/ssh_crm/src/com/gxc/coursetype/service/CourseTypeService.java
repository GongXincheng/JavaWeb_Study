package com.gxc.coursetype.service;

import java.util.List;

import com.gxc.coursetype.domain.CrmCourseType;
import com.gxc.page.PageBean;

public interface CourseTypeService {
	/**
	 * 查询所有课程类别
	 * @return
	 */
	public List<CrmCourseType> findAll();

	/**
	 * 带有条件的查询所有
	 * @param courseType
	 * @return
	 */
	public List<CrmCourseType> findAll(CrmCourseType courseType);
	

	/**
	 * 根据id查询课程类型
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);
	
	/**
	 * 保存/更新
	 * @param courseType
	 */
	public void saveOrUpdate(CrmCourseType courseType);
	
	
	/**
	 * 分页 + 条件查询
	 * @param courseType 条件
	 * @param pageNum	当前页
	 * @param pageSize	每页显示个数
	 * @return
	 */
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType, int pageNum, int pageSize);
	
}
