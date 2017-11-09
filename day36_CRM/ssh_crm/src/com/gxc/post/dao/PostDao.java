package com.gxc.post.dao;

import java.util.List;

import com.gxc.department.domain.CrmDepartment;
import com.gxc.post.domain.CrmPost;

public interface PostDao {
	
	/**
	 * 查询指定部门的所有职务
	 * @param department
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment department);
}
