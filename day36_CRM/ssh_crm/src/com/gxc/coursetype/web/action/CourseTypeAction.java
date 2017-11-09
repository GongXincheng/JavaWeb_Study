package com.gxc.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gxc.coursetype.domain.CrmCourseType;
import com.gxc.coursetype.service.CourseTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {
	private static final long serialVersionUID = 3438286316323631935L;
	
	//模型驱动
	private CrmCourseType courseType = new CrmCourseType();
	@Override
	public CrmCourseType getModel() {
		return courseType ;
	}
 
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	
	/***************************************************************/
	
	/**
	 * 查询所有
	 * @return
	 */ 
	public String findAll(){
		/* 
			1.简单查询
			List<CrmCourseType> allCourseType = courseTypeService.findAll();
			//将查询结果存放在值栈   JSP用过#key方式获得
			ActionContext.getContext().put("allCourseType", allCourseType); 
			
		 *  2.条件查询   */
		List<CrmCourseType> allCourseType = courseTypeService.findAll(courseType);
		//将查询结果存放在值栈   JSP用过#key方式获得
		ActionContext.getContext().put("allCourseType", allCourseType);
		
		return "findAll";
	}
	
	/**
	 * 添加/更新显示jsp页面
	 * @return
	 */
	public String addOrEditUI(){
		//如果有id -> 编辑,编辑需要查询详情
		if(StringUtils.isNotBlank(this.courseType.getCourseTypeId())){
			CrmCourseType findCourseType = this.courseTypeService.findById(courseType.getCourseTypeId());
			ActionContext.getContext().getValueStack().push(findCourseType);
		}
		
		return "addOrEditUI";
	}
	
	/**
	 * 添加或编辑功能
	 * @return
	 */
	public String addOrEdit(){
		/*
		 * 这个地方一定要注意：或者在jsp如下：
		 * 			<s:if test="courseTypeId != null">
		 *				<s:hidden name="courseTypeId" value="%{courseTypeId}"></s:hidden>
		 *			</s:if>
		 */
		if(StringUtils.isBlank(courseType.getCourseTypeId())){
			courseType.setCourseTypeId(null);
		}
		
		
		this.courseTypeService.saveOrUpdate(courseType);
		return "addOrEdit";
	}
}












