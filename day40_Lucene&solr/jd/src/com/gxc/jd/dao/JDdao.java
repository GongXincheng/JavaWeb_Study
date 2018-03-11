package com.gxc.jd.dao;

import java.util.List;

import com.gxc.jd.pojo.ProductModel;

public interface JDdao {
	
	public List<ProductModel> selectProductModelListByQuery(String queryString,String catalog_name,
			   String price,String sort) throws Exception;
}
