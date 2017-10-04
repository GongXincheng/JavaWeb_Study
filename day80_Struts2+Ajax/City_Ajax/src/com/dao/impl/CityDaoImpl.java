package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CityDao;
import com.entity.City;
import com.util.DBUtil;

public class CityDaoImpl extends DBUtil implements CityDao {
	String SQL_SELECT = "SELECT CITYCODE,CITYNAME,PROVINCECODE FROM  CITY";
	@Override
	public List<City> getALLCity() {
		// TODO Auto-generated method stub
		this.getConnection();
		ResultSet rs=this.executeQuery(SQL_SELECT, new String[]{});
		List<City> cityList=new ArrayList<City>();
		try {
			while(rs.next()){
				City city=new City();
				city.setCityCode(rs.getString("citycode"));
				city.setCityName(rs.getString("cityname"));
				city.setProvinceCode(rs.getString("provincecode"));
				cityList.add(city);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return cityList;
	}

	@Override
	public List<City> getCityByProvinceCode(String provinceCode){
		// TODO Auto-generated method stub
		this.getConnection();
		String sql=SQL_SELECT+" where provincecode=?";
		ResultSet rs=this.executeQuery(sql, new String[]{provinceCode});
		List<City> cityList=new ArrayList<City>();
		try {
			while(rs.next()){
				City city=new City();
				city.setCityCode(rs.getString("citycode"));
				city.setCityName(rs.getString("cityname"));
				city.setProvinceCode(rs.getString("provincecode"));
				cityList.add(city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.closeAll();
		return cityList;		
	}

	@Override
	public City getCityByCityCode(String cityCode) {
		// TODO Auto-generated method stub
		this.getConnection();
		String sql=SQL_SELECT+" where citycode=?";
		ResultSet rs=this.executeQuery(sql, new String[]{cityCode});
		City city=null;
		try {
			if(rs.next()){
				city=new City();
				city.setCityCode(rs.getString("citycode"));
				city.setCityName(rs.getString("cityname"));
				city.setProvinceCode(rs.getString("provincecode"));				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return city;	
	}

}
