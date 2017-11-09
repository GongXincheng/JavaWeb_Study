package com.gxc.coursetype.service;

import java.util.List;

import com.gxc.coursetype.domain.CrmCourseType;

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
}
