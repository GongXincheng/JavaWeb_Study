package com.dao;

import java.util.List;

import com.entity.Province;

public interface ProvinceDao {
	public List<Province> getAllProvince();
	public Province getProvinceByCode(String provinceCode);

}
