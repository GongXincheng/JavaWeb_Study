package com.gxc.staff.web.action;

import java.util.List;

import com.gxc.base.BaseAction;
import com.gxc.department.domain.CrmDepartment;
import com.gxc.staff.domain.CrmStaff;
import com.opensymphony.xwork2.ActionContext;
 
public class StaffAction extends BaseAction<CrmStaff> {
	private static final long serialVersionUID = -6809768982930373723L;
	
	///////////////////////////////////////////
	
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		//1.查询员工
		CrmStaff findStaff = this.getStaffService().login(this.getModel());
		
		//2.是否登录成功
		if(findStaff!=null){
			//保存到session
			this.putSession("loginStaff", findStaff);
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
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		//1.查询所有
		List<CrmStaff> allStaff = this.getStaffService().findAll();
		//2. 将结果放到值栈，方便jsp获取
		//方式一：Context(Map)中：#key的方式获取：
		//		ActionContext.getContext().put(key, value); 
		//方式二：放root(值栈中)中：push(obj); jsp获取"属性名 或 key",一般数据为javaBean或Map时使用，
		//		ActionContext.getContext().getValueStack().push(allStaff);
		//方式三：放root(值栈中)中：set(key, value); 一般数据为集合的时候 ，js获取：key
		//		ActionContext.getContext().getValueStack().set("", allStaff);
		
		//使用方式一：
		this.put("allStaff",allStaff);
		
		return "findAll";
	}
	
	/**
	 * 编辑前UI显示
	 * @return
	 */
	public String preEdit(){
		//1、通过id查询员工 
		CrmStaff findStaff = this.getStaffService().findById(this.getModel().getStaffId());
		//使用压栈！使用方式2
		ActionContext.getContext().getValueStack().push(findStaff);
		
		//2、查询所有的部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		//JSP通过"key"获得
		this.set("allDepartment", allDepartment);
		
		return "editUI";
	}
	
	/**
	 * 更新操作
	 * @return
	 */
	public String edit(){
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}
}
