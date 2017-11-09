package com.gxc.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gxc.coursetype.dao.CourceTypeDao;
import com.gxc.coursetype.domain.CrmCourseType;
import com.gxc.coursetype.service.CourseTypeService;

public class CourseTypeServiceImpl implements CourseTypeService {

	
	private CourceTypeDao courceTypeDao;
	public void setCourceTypeDao(CourceTypeDao courceTypeDao) {
		this.courceTypeDao = courceTypeDao;
	}
	
	@Override
	public List<CrmCourseType> findAll() {
		return courceTypeDao.findAll();
	}

	@Override
	public List<CrmCourseType> findAll(CrmCourseType courseType) {
		//1.1拼凑查询条件
		StringBuilder builder = new StringBuilder();
		
		//1.2拼凑实际参数,可以重复,有顺序->List
		List<Object> paramsList = new ArrayList<Object>();
		
		//2.过滤条件
		//2.1：课程类别
		if(StringUtils.isNotBlank(courseType.getCourseName())){
			builder.append(" and courseName like ?");
			paramsList.add("%"+courseType.getCourseName()+"%");
		}
		//2.1：课程简介
		if(StringUtils.isNotBlank(courseType.getRemark())){
			builder.append(" and remark like ?");
			paramsList.add("%"+courseType.getRemark()+"%");
		}
		//2.3：总学时
		if(StringUtils.isNotBlank(courseType.getTotalStart())){
			builder.append(" and total >= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if(StringUtils.isNotBlank(courseType.getTotalEnd())){
			builder.append(" and total <= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		//2.4：费用
		if(StringUtils.isNotBlank(courseType.getCourseCostStart())){
			builder.append(" and courseCost >= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		if(StringUtils.isNotBlank(courseType.getCourseCostEnd())){
			builder.append(" and courseCost <= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}
		
		return courceTypeDao.findAll(builder.toString(),paramsList.toArray());
	}

	@Override
	public CrmCourseType findById(String courseTypeId) {
		return this.courceTypeDao.findById(courseTypeId);
	}

	@Override
	public void saveOrUpdate(CrmCourseType courseType) {
		this.courceTypeDao.saveOrUpdate(courseType);
	}
	
	
}
