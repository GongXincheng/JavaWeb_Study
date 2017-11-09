package com.gxc.post.service.impl;

import java.util.List;
import com.gxc.department.domain.CrmDepartment;
import com.gxc.post.dao.PostDao;
import com.gxc.post.domain.CrmPost;
import com.gxc.post.service.PostService;

public class PostServiceImpl implements PostService {

	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	
	@Override
	public List<CrmPost> findAll(CrmDepartment department) {
		return postDao.findAll(department);
	}
	
	
}
