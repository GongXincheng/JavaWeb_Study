package com.gxc.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gxc.mapper.UserMapper;
import com.gxc.pojo.User;
import com.gxc.pojo.UserExample;

public class TestDemo {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void test1() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		User user = userMapper.selectByPrimaryKey(10);
		System.out.println(user.getUsername());
	}
	
	@Test
	public void test2() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		UserExample example = new UserExample();
		example.createCriteria().andSexEqualTo("1");
		List<User> list = userMapper.selectByExample(example);
		for (User user : list) {
			System.out.println(user.getUsername());
		}
	}
}
