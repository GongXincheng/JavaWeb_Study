package com.gxc.post.service;

import java.util.List;

import com.gxc.department.domain.CrmDepartment;
import com.gxc.post.domain.CrmPost;

public interface PostService {

	/**
	 * 查询指定部门的所有职务
	 * @param department
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment department);
	
}
