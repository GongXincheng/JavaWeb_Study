package com.gxc.coursetype.dao;

import java.util.List;

import com.gxc.coursetype.domain.CrmCourseType;

public interface CourceTypeDao {
	
	/**
	 * 查询所有课程类别
	 * @return
	 */
	public List<CrmCourseType> findAll();

	/**
	 * 按条件查询
	 * @param condition
	 * @param params
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition, Object[] params);
	
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
