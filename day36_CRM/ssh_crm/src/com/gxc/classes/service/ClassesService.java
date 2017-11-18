package com.gxc.classes.service;

import java.util.List;
import com.gxc.classes.domain.CrmClasses;

public interface ClassesService {

	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmClasses> findAll();
	
	/**
	 * 根据Id查询详情
	 * @param classesId
	 * @return
	 */
	public CrmClasses findById(String classesId);

	/**
	 * 更新上传
	 * @param model
	 */
	public void updateUpload(CrmClasses model);
}
