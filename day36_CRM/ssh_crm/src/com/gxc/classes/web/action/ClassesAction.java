package com.gxc.classes.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.gxc.base.BaseAction;
import com.gxc.classes.domain.CrmClasses;
import com.gxc.utils.MyStringUtils;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class ClassesAction extends BaseAction<CrmClasses> {
	private static final long serialVersionUID = -6628080307965224486L;
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		List<CrmClasses> allClasses = this.getClassesService().findAll();
		this.set("allClasses", allClasses);
		return "findAll";
	}
	
	/**
	 * 显示上传的表单
	 * @return
	 */
	public String uploadUI(){
		CrmClasses findClasses = this.getClassesService().findById(this.getModel().getClassId());
		//压入栈顶
		this.push(findClasses);
		return "uploadUI";
	}
	
	/**
	 * 文件上传
	 * @return
	 * @throws IOException 
	 */
	
	private File schedule;	//上传的内容
	private String scheduleFileName;	//上传文件名
	@SuppressWarnings("unused")
	private String scheduleContentType;	//上传类型
	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}
	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}
	public void setScheduleContentType(String scheduleContentType) {
		this.scheduleContentType = scheduleContentType;
	}
	
	@InputConfig(resultName="uploadInput")
	public String upload() throws IOException{
		//0. 根据文件名获取文件扩展名
		String kzm = scheduleFileName.substring(scheduleFileName.lastIndexOf("."));
		
		//1.将课表保存到硬盘,位置：tomcat.../WEN-INF/upload/...  
		//1.1 (确认父目录)
		String parentDir =  ServletActionContext.getServletContext().getRealPath("/WEN-INF/upload");
		
		//1.2.文件名为随机数,且没有扩展名
		String fileName = MyStringUtils.getUUID().concat(kzm);
		
		//1.3 保存
		FileUtils.copyFile(schedule, new File(parentDir, fileName));
		
		//2.更新数据库
		this.getModel().setUploadTime(new Date());
		this.getModel().setUploadPath("/WEN-INF/upload/" + fileName);
		this.getModel().setUploadFilename(scheduleFileName);
		this.getClassesService().updateUpload(this.getModel());
		
		return "upload";
	}
}
