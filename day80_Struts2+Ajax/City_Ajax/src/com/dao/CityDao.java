package com.dao;

import java.util.List;

import com.entity.City;

public interface CityDao {
	public List<City> getALLCity();
	public List<City> getCityByProvinceCode(String provinceCode);
	public City getCityByCityCode(String cityCode);
}
