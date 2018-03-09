package com.gxc.crm.service;

import com.gxc.common.utils.Page;
import com.gxc.crm.pojo.Customer;
import com.gxc.crm.pojo.QueryVo;

public interface CustomerService {

	/**
	 * 通过四个条件查询分页对象
	 * @param vo
	 * @return
	 */
	public Page<Customer> selectPageByQueryVo(QueryVo vo);

	//通过ID查询客户
	public Customer selectCustomerById(Integer id);
	
	//修改
	public void updateCustomerById(Customer customer);

	//删除
	public void deleteCustomerById(Integer id);
}
