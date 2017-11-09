package com.gxc.post.web.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.gxc.post.domain.CrmPost;
import com.gxc.post.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {
	private static final long serialVersionUID = -3835266769987710028L;
	
	//模型驱动
	private CrmPost post = new CrmPost();
	@Override
	public CrmPost getModel() {
		return post ;
	}
	
	//service
	public PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	/** ---------------------------------------------------- */
	
	/**
	 * Ajax 通过部门，查询所有的职务
	 * @return
	 * @throws IOException 
	 */
	public String findAllWithDepartment() throws IOException{
		//1.查询
		List<CrmPost> allPost = this.postService.findAll(post.getDepartment());

		//2.将java对象转换为json数据
		//2.1排除不需要的数据
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"department","staffSet"});
		
		//2.2转换
		String jsonData = JSONArray.fromObject(allPost,jsonConfig).toString();
		
		//3.1：响应中文乱码问题
		ServletActionContext.getResponse().setContentType("text/html; charset=UTF-8");
		//3.2：将json数据发送给浏览器
		ServletActionContext.getResponse().getWriter().print(jsonData);
		
		return "none";
	}
}
