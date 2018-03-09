package com.gxc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.gxc.entity.Orders;
import com.gxc.entity.QueryVo;
import com.gxc.entity.User;
import com.gxc.mapper.OrderMapper;

public class MybatisTest2 {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException{
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}

	/**
	 * 查询订单表order的所有数据   练习 手动映射 resultMap
	 * @throws Exception
	 */
	@Test
	public void testSelectOrdersList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> ordersList = orderMapper.selectOrdersList();
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}
	
	/**
	 * 根据性别和姓名查询用户   联系 where if 标签
	 * @throws Exception
	 */
	@Test
	public void testSelectUserBySexAndUsername() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("小");
		List<User> users = orderMapper.selectUserBySexAndUsername(user);
		for (User user2 : users) {
			System.out.println(user2);
		}
	}
	
	/**
	 * 根据多个ID查询用户    联系 foreach 标签
	 * @throws Exception
	 */
	@Test
	public void testSelectUserByIds1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		QueryVo vo = new QueryVo();
		List<Integer> idsList = new ArrayList<Integer>();
		idsList.add(10);
		idsList.add(16);
		idsList.add(22);
		vo.setIdsList(idsList);
		List<User> users = orderMapper.selectUserByIds1(vo);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testSelectUserByIds2() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		Integer[] ids = new Integer[]{10,16,22};
		
		List<User> users = orderMapper.selectUserByIds2(ids);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testSelectUserByIds3() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Integer> idsList = new ArrayList<Integer>();
		idsList.add(10);
		idsList.add(16);
		idsList.add(22);
		List<User> users = orderMapper.selectUserByIds3(idsList);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	/**
	 * 一对一
	 * @throws Exception
	 */
	@Test
	public void testSelectOrders() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> orders = orderMapper.selectOrders();
		for (Orders orders2 : orders) {
			System.out.println(orders2.getId()+"："+orders2.getUserId()+"："+orders2.getUser().getUsername());
		}
	}
	
	
	/**
	 * 一对一
	 * @throws Exception
	 */
	@Test
	public void testSelectUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<User> users = orderMapper.selectUserList();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
	
}
