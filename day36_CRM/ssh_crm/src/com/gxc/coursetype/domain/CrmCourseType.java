package com.gxc.coursetype.domain;

import java.util.HashSet;
import java.util.Set;

import com.gxc.classes.domain.CrmClasses;

public class CrmCourseType {

	private String courseTypeId;
	private Double courseCost;	//费用
	private Integer total; 	//总课时 
	private String courseName;	//课程类别名称
	private String remark;	
	
	//一个课程类型对应多个班级(一对多)
	private Set<CrmClasses> classSet = new HashSet<CrmClasses>();

	
	public String getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public Double getCourseCost() {
		return courseCost;
	}

	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<CrmClasses> getClassSet() {
		return classSet;
	}

	public void setClassSet(Set<CrmClasses> classSet) {
		this.classSet = classSet;
	}
	
}
