package com.gxc.classes.service.impl;

import java.util.List;

import com.gxc.classes.dao.ClassesDao;
import com.gxc.classes.domain.CrmClasses;
import com.gxc.classes.service.ClassesService;

public class ClassesServiceImpl implements ClassesService {

	private ClassesDao classesDao;
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}
	
	@Override
	public List<CrmClasses> findAll() {
		return classesDao.findAll();
	}

	@Override
	public CrmClasses findById(String classesId) {
		return classesDao.findById(classesId);
	}

	@Override
	public void updateUpload(CrmClasses model) {
		//1.先查询 2.更新 3.快照一级缓存
		CrmClasses findClass = this.classesDao.findById(model.getClassId());
		findClass.setUploadFilename(model.getUploadFilename());
		findClass.setUploadPath(model.getUploadPath());
		findClass.setUploadTime(model.getUploadTime());
	}

}
