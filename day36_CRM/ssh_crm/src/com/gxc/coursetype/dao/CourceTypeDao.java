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

	/**
	 * 分页 - 查询总记录数
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition, Object[] params);

	/**
	 * 分页 - 查询结果
	 * @param condition 条件
	 * @param params	条件参数
	 * @param startIndex 开始索引
	 * @param pageSize 每页记录数
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition, Object[] params,
			int startIndex, int pageSize);
}
