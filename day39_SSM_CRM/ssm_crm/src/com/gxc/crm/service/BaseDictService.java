package com.gxc.crm.service;

import java.util.List;
import com.gxc.crm.pojo.BaseDict;

public interface BaseDictService {

	/**
	 * 根据类别代码查询数据
	 * @param dictTypeCode
	 * @return
	 */
	List<BaseDict> selectBaseDictListByCode(String code);
	
}
