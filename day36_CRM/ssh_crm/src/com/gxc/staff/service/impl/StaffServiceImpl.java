package com.gxc.staff.service.impl;

import java.util.List;
import com.gxc.staff.dao.StaffDao;
import com.gxc.staff.domain.CrmStaff;
import com.gxc.staff.service.StaffService;
import com.gxc.utils.MyStringUtils;

/**
 * @author GXC
 */
public class StaffServiceImpl implements StaffService {

	/**
	 * Spring 注入
	 */
	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	/**
	 * 登录
	 */
	@Override
	public CrmStaff login(CrmStaff staff) {
		//MD5加密
		String loginPwd = MyStringUtils.getMD5Value(staff.getLoginPwd());
		return staffDao.find(staff.getLoginName(), loginPwd);
	}

	/**
	 * 查询全部
	 */
	@Override
	public List<CrmStaff> findAll() {
		List<CrmStaff> list = staffDao.findAll();
		return list;
	}

	/**
	 * 根据Id
	 */
	@Override
	public CrmStaff findById(String staffId) {
		return staffDao.findById(staffId);
	}

	/**
	 * 更新
	 */
	@Override
	public void updateStaff(CrmStaff staff) {
		/*
		 * 1. 方案一：判断密码是否是32长度
		 * 		如果是，密码没有修改，(加密后的)
		 * 		如果不是，密码已经修改，需呀加密
		 * 
		 * 2. 方案二：不更新密码
		 * 		dao.update(staff),默认更新所有
		 * 	 * CrmStaff.hbm.xml,配置密码不参加更新
		 * 
		 * 3. 方案3：先通过ID查询，比较密码是否一致
		 * 		如果不一致，对密码进行MD5加密
		 * 		将除了OID之外的数据全部设置
		 */
		CrmStaff findStaff = staffDao.findById(staff.getStaffId());
		if( !(findStaff.getLoginPwd().equals(staff.getLoginPwd())) ){
			//将修改后的密码,MD5加密,并设置
			findStaff.setLoginPwd(MyStringUtils.getMD5Value(staff.getLoginPwd()));
		}
		
		//自动更新，原因：一级缓存被修改，快照不一致，自动执行update
		findStaff.setLoginName(staff.getLoginName());
		findStaff.setStaffName(staff.getStaffName());
		findStaff.setGender(staff.getGender());
		findStaff.setOnDutyDate(staff.getOnDutyDate());
		findStaff.setPost(staff.getPost());
		
	}
	
}
