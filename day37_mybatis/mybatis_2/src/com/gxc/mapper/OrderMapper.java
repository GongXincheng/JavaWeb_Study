package com.gxc.mapper;

import java.util.List;

import com.gxc.entity.Orders;
import com.gxc.entity.QueryVo;
import com.gxc.entity.User;

public interface OrderMapper {

	//查询订单表order的所有数据
	public List<Orders> selectOrdersList();
	
	//根据性别和姓名查询用户
	public List<User> selectUserBySexAndUsername(User user);
	
	//根据多个ID查询用户
	public List<User> selectUserByIds2(Integer[] ids);
	public List<User> selectUserByIds3(List<Integer> ids);
	public List<User> selectUserByIds1(QueryVo vo);
	
	
	//一对一关联查询,订单为中心关联用户
	public List<Orders> selectOrders();
	
	//一对多
	public List<User> selectUserList();
	
}
