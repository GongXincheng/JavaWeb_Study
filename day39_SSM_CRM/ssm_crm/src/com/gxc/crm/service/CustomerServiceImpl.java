package com.gxc.crm.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxc.common.utils.Page;
import com.gxc.crm.mapper.CustomerMapper;
import com.gxc.crm.pojo.Customer;
import com.gxc.crm.pojo.QueryVo;

/**
 * 客户管理
 * @author 宫新程
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	//通过四个条件查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		
		Page<Customer> page	= new Page<Customer>();
		//每页数
		page.setSize(5);
		vo.setSize(5);
		//判断当前页
		if(vo!=null){
			//设置当前页
			if(vo.getPage()!=null && vo.getPage()>0){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			//条件
			if(StringUtils.isNotBlank(vo.getCustSource())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(StringUtils.isNotBlank(vo.getCustName())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(StringUtils.isNotBlank(vo.getCustIndustry())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(StringUtils.isNotBlank(vo.getCustLevel())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			
			page.setTotal(customerMapper.customerCount(vo));
			page.setRows(customerMapper.selectCutomerListByQueryVo(vo));
		}
		return page;
	}

	@Override
	public Customer selectCustomerById(Integer id) {
		return customerMapper.selectCustomerById(id);
	}

	@Override
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
	}
}
