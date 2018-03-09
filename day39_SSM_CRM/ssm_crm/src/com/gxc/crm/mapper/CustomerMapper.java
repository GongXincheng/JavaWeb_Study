package com.gxc.crm.mapper;

import java.util.List;
import com.gxc.crm.pojo.Customer;
import com.gxc.crm.pojo.QueryVo;

public interface CustomerMapper {

	//总条数
	public Integer customerCount(QueryVo vo);
	
	//结果集
	public List<Customer> selectCutomerListByQueryVo(QueryVo vo);

	//通过ID查询客户
	public Customer selectCustomerById(Integer id);
	
	//修改
	public void updateCustomerById(Customer customer);

	//删除
	public void deleteCustomerById(Integer id);
}
