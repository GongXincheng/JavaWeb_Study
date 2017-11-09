package com.gxc.staff.web.action;

import java.util.List;
import com.gxc.department.domain.CrmDepartment;
import com.gxc.department.service.DepartmentService;
import com.gxc.staff.domain.CrmStaff;
import com.gxc.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {
	private static final long serialVersionUID = -6809768982930373723L;
	
	//封装数据
	private CrmStaff staff = new CrmStaff();
	@Override
	public CrmStaff getModel() {
		return staff;
	}
	
	//员工Service( Spring自动注入 )
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	//部门Service( Spring自动注入 )
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
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
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		//1.查询所有
		List<CrmStaff> allStaff = staffService.findAll();
		//2. 将结果放到值栈，方便jsp获取
		//方式一：Context(Map)中：#key的方式获取：
		//		ActionContext.getContext().put(key, value); 
		//方式二：放root(值栈中)中：push(obj); jsp获取"属性名 或 key",一般数据为javaBean或Map时使用，
		//		ActionContext.getContext().getValueStack().push(allStaff);
		//方式三：放root(值栈中)中：set(key, value); 一般数据为集合的时候 ，js获取：key
		//		ActionContext.getContext().getValueStack().set("", allStaff);
		
		//使用方式一：
		ActionContext.getContext().put("allStaff",allStaff);
		
		return "findAll";
	}
	
	/**
	 * 编辑前UI显示
	 * @return
	 */
	public String preEdit(){
		//1、通过id查询员工 
		CrmStaff findStaff = this.staffService.findById(staff.getStaffId());
		//使用压栈！使用方式2
		ActionContext.getContext().getValueStack().push(findStaff);
		
		//2、查询所有的部门
		List<CrmDepartment> allDepartment = departmentService.findAll();
		//JSP通过"key"获得
		ActionContext.getContext().getValueStack().set("allDepartment", allDepartment);
		
		return "editUI";
	}
	
	/**
	 * 更新操作
	 * @return
	 */
	public String edit(){
		this.staffService.updateStaff(staff);
		return "edit";
	}
}
