package com.gxc.jd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxc.jd.pojo.ProductModel;
import com.gxc.jd.service.JDService;

/**
 * 查询商品列表
 * @author 宫新程
 */
@Controller
public class JDController {

	@Autowired
	private JDService jdService;
	
	//商品列表
	@RequestMapping(value = "/item/list.action")
	public String list(String queryString,String catalog_name,
					   String price,String sort,Model model) throws Exception{
		
		//通过上面四个条件查询对应的商品结果集
		List<ProductModel> productModels = jdService.selectProductModelListByQuery(queryString, catalog_name, price, sort);
		
		model.addAttribute("productModels", productModels);
		
		//条件回显
		model.addAttribute("queryString", queryString);
		model.addAttribute("catalog_name", catalog_name);
		model.addAttribute("price", price);
		model.addAttribute("sort", sort);
		
		return "product_list";
	}
	
}
