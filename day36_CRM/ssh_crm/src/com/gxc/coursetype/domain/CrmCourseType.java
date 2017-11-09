package com.gxc.coursetype.domain;

import java.util.HashSet;
import java.util.Set;

import com.gxc.classes.domain.CrmClasses;

/**
 * @author GXC
 */
public class CrmCourseType {

	private String courseTypeId;
	private Double courseCost;
	private Integer total; 	
	private String courseName;	
	private String remark;	
	
	/**
	 * 一个课程类型对应多个班级(一对多)
	 */
	private Set<CrmClasses> classSet = new HashSet<CrmClasses>();

	/**
	 * 查询条件,一般都是字符串
	 */
	//1.总学时
	private String totalStart;
	private String totalEnd;
	//2.课程费用
	private String courseCostStart;
	private String courseCostEnd;
	
	
	public String getTotalStart() {
		return totalStart;
	}

	public void setTotalStart(String totalStart) {
		this.totalStart = totalStart;
	}

	public String getTotalEnd() {
		return totalEnd;
	}

	public void setTotalEnd(String totalEnd) {
		this.totalEnd = totalEnd;
	}

	public String getCourseCostStart() {
		return courseCostStart;
	}

	public void setCourseCostStart(String courseCostStart) {
		this.courseCostStart = courseCostStart;
	}

	public String getCourseCostEnd() {
		return courseCostEnd;
	}

	public void setCourseCostEnd(String courseCostEnd) {
		this.courseCostEnd = courseCostEnd;
	}

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
