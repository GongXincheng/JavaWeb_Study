package com.gxc.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxc.common.utils.Page;
import com.gxc.crm.pojo.BaseDict;
import com.gxc.crm.pojo.Customer;
import com.gxc.crm.pojo.QueryVo;
import com.gxc.crm.service.BaseDictService;
import com.gxc.crm.service.CustomerService;

/**
 * 客户管理
 * @author 宫新程
 */
@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	//读取properties文件,注入在成员变量上
	@Value("${fromType.code}")
	private String fromTypeCode;
	
	@Value("${industryType.code}")
	private String industryTypeCode;
	
	@Value("${levelType.code}")
	private String levelTypeCode;
	
	//入口
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo,Model model){
		
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		
		//通过条件查询条件
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//通过四个条件查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		
		//数据回显
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	/**
	 * 显示要修改客户的数据  ajax
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/customer/edit")
	public @ResponseBody
	Customer toEdit(Integer id){
		return customerService.selectCustomerById(id);
	}
	
	@RequestMapping(value="/customer/update")
	public @ResponseBody
	String update (Customer customer){
		customerService.updateCustomerById(customer);
		return "OK";
	}
	
	@RequestMapping(value="/customer/delete")
	public @ResponseBody
	String delete (Integer id){
		customerService.deleteCustomerById(id);
		return "OK";
	}
	
}
