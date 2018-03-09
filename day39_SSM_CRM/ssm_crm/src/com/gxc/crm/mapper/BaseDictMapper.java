package com.gxc.crm.mapper;

import java.util.List;

import com.gxc.crm.pojo.BaseDict;

public interface BaseDictMapper {

	/**
	 * 根据类别代码查询数据
	 * @param dictTypeCode
	 * @return
	 */
	List<BaseDict> selectBaseDictListByCode(String code);

	
}
