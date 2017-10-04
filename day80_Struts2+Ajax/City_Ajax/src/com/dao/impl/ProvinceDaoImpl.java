package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProvinceDao;
import com.entity.Province;
import com.util.DBUtil;

public class ProvinceDaoImpl extends DBUtil implements ProvinceDao {
	String SQL_SELECT = "SELECT PROVINCECODE,PROVINCENAME FROM  PROVINCE";

	@Override
	public List<Province> getAllProvince() {
		// TODO Auto-generated method stub
		this.getConnection();
		ResultSet rs=this.executeQuery(SQL_SELECT, new String[]{});
		List<Province> provList=new ArrayList<Province>();
		try {
			while(rs.next()){
				Province prov=new Province();
				prov.setPrivinceCode(rs.getString("provincecode"));
				prov.setPrivinceName(rs.getString("provincename"));
				provList.add(prov);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return provList;
	}

	@Override
	public Province getProvinceByCode(String provinceCode) {
		// TODO Auto-generated method stub
		this.getConnection();
		String sql=SQL_SELECT+" where provincecode=?";
		String[] param={provinceCode};
		ResultSet rs=this.executeQuery(sql, param);
		Province province=null;
		try {
			if(rs.next()){
				province=new Province();
				province.setPrivinceCode(rs.getString("provincecode"));
				province.setPrivinceName(rs.getString("provincename"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return province;
	}

}
