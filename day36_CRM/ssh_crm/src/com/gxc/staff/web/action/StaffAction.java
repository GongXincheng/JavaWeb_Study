package com.gxc.staff.web.action;

import com.gxc.staff.domain.CrmStaff;
import com.gxc.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {
	private static final long serialVersionUID = -6809768982930373723L;
	
	//封装数据
	private CrmStaff staff = new CrmStaff();
	public CrmStaff getModel() {
		return staff;
	}
	
	//Service( Spring自动注入 )
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	///////////////////////////////////////////
	
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		//1.查询员工
		CrmStaff findStaff = staffService.login(staff);
		//2.是否登录成功
		if(findStaff!=null){
			//保存到session
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			//重定向到首页---xml
			return "success";
		}
		
		//3.不成功
		addFieldError("","用户名与密码不匹配!");
		//请求转发显示
		return "login";
	}
	
	//为了显示JSP页面(首页)
	public String home(){
		return "home";
	}
}
