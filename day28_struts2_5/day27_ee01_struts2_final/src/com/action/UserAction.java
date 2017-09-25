package com.action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;

	private IUserService service = new UserServiceImpl();
	private User user = new User();
	//用于存放所有用户
	private List<User> users;
	//保存文件的file
	private File upload;
	//文件名
	private String uploadFileName;
	
//查看用户详情
	public String findUserById(){
		
		user = service.findUserById(user.getUserID());
		//把user对象压入栈顶
		ActionContext.getContext().getValueStack().push(user);
		
		return SUCCESS;
	}

//查询所有用户---------------------------------------------------------------------
	public String findAll(){
		users = service.findAllUser();
		
		return SUCCESS;
	}
	
//添加用户--------------------------------------------------------------------------
	public String add(){
		
		//step1:文件保存的路径  	E:\apache-tomcat-7.0.52\webapps\day27_ee01_struts2_final\files
		String filePath = ServletActionContext.getServletContext().getRealPath("/files");	//给定虚拟路径返回包含实际路径的 String
		//子文件夹名称
		String dir = generateChildPath(filePath);	// 2017-09-24
		
		//step2:生成带有随机性的文件名
		String fileName = TokenHelper.generateGUID()+"_"+uploadFileName;	//7DCOC9YJFC7KL39WKXFM91L4DV3IGF59_head_2.jpg
		
		//step3：为user模型中缺少的属性赋值
		user.setPath(dir);
		user.setFilename(fileName);
		
		//step4：上传文件操作
		boolean b = upload.renameTo(new File(filePath+File.separator+dir,fileName));
		System.out.println(b);
		
		//step5:保存用户
		int res = service.saveUser(user);
		if(res>0)
			return SUCCESS;
		return null;
	
	}
	//生成以yyyy-MM-dd的格式名称文件夹
	private String generateChildPath(String filePath){
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dir = format.format(date);
		//根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。 
		File file = new File(filePath,dir);
		if(!file.exists()){
			file.mkdirs();
		}
		return dir;
	}
	
//登录--------------------------------------------------------------------------
	public String login(){
		User dbUser = service.login(user.getLogonName(), user.getLogonPwd());
		//登录失败
		if(dbUser == null){
			addActionError("用户名不存在，或密码错误!");
			return "input";
		}
		//如果登陆成功将dbuser存到session域中
//		ActionContext.getContext().getSession().put("user", dbUser);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);
		
		return SUCCESS;
	}

	
	
	
	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
