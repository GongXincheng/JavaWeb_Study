package com.gxc.jd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxc.jd.dao.JDdao;
import com.gxc.jd.pojo.ProductModel;

@Service
public class JDServiceImpl implements JDService {

	@Autowired
	private JDdao jdDao;
	
	@Override
	public List<ProductModel> selectProductModelListByQuery(String queryString, String catalog_name, String price,
			String sort) throws Exception {
		return jdDao.selectProductModelListByQuery(queryString, catalog_name, price, sort);
	}

}
