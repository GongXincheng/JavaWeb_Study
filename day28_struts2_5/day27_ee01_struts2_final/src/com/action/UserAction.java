package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
	private List<User> users; 		//用于存放所有用户
	private File upload;		 	//保存文件的file
	private String uploadFileName;  //文件名
	
//编辑用户--------------------------------------------------------------------
	public String edit(){
		if(upload == null){
			//没有选择上传文件 使用原来的文件上传
			User dbUser = service.findUserById(user.getUserID());
			user.setPath(dbUser.getPath());
			user.setFilename(dbUser.getFilename());
			int res = service.modifyUser(user);
			if(res>0)
				return SUCCESS;
			return null;
		}
		else{
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
			boolean b = upload.renameTo(new File(filePath+ File.separator+ dir, fileName));
			System.out.println("上传是否成功:"+b);
			//step5:保存用户
			int res = service.modifyUser(user);
			if(res>0)
				return SUCCESS;
			return null;
		}
	}
	
//显示编辑页面的动作方法------------------------------------------------------
	public String editUI(){
		user = service.findUserById(user.getUserID());
		//把user对象压入栈顶
		ActionContext.getContext().getValueStack().push(user);
		return SUCCESS;
	}
	
//删除用户---------------------------------------------------------------------
	public String delete(){
		int res = service.removeUser(user.getUserID());
		if(res>0){
			return SUCCESS;			
		}
		return null;
	}
	
//文件下载---------------------------------------------------------------------
	private InputStream inputStream;
	private String oldFilename;
	
	public String download() throws Exception{
		//1.获取用户的信息
		User dbUser = service.findUserById(user.getUserID());
		
		//2.文件存放的路径
		String filePath = ServletActionContext.getServletContext().getRealPath("/files");
		//原文件名称
		oldFilename = dbUser.getFilename().substring(dbUser.getFilename().indexOf("_")+1);
		
		//3.给字节输入流赋值	
		inputStream = new FileInputStream(filePath + File.separator + dbUser.getPath() + File.separator + dbUser.getFilename());
		
		//4.返回成功
		return SUCCESS;
		//5.剩下的交给stream类型的结果视图
	}
	
//查看用户详情---------------------------------------------------------------------
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
		boolean b = upload.renameTo(new File(filePath+ File.separator+ dir, fileName));
		System.out.println("上传是否成功:"+b);
		
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getOldFilename() {
		return oldFilename;
	}

	public void setOldFilename(String oldFilename) {
		this.oldFilename = oldFilename;
	}
	
}
