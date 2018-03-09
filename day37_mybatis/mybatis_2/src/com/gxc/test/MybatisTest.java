package com.gxc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.gxc.entity.QueryVo;
import com.gxc.entity.User;
import com.gxc.mapper.UserMapper;

public class MybatisTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException{
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void test1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.findUserByUsername("小");
		for (User user : users) {
			System.out.println(user);
		}
	}
	@Test
	public void test2() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("GXC");
		user.setAddress("TZ");
		user.setBirthday(new Date());
		user.setSex("n");
		int num = userMapper.insertUser(user);
		sqlSession.commit();
		if(num > 0){
			System.out.println("用户添加成功！userID = "+user.getId());
		}
	}
	@Test
	public void test3() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(25);
		user.setUsername("2");
		user.setAddress("2");
		user.setBirthday(new Date());
		user.setSex("2");
		int num = userMapper.updateUser(user);
		sqlSession.commit();
		if(num > 0){
			System.out.println("用户更新成功！");
		}
	}
	@Test
	public void test4() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int num = userMapper.deleteUserById(32);
		sqlSession.commit();
		if(num > 0){
			System.out.println("用户删除成功！");
		}
	}
	
    /*************************************************************/
	@Test
	public void testFindByQueryVo() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("小");
		vo.setUser(user);
		List<User> users = userMapper.findUserByQuery(vo);
		for (User user2 : users) {
			System.out.println(user2);
		}
	}
	
	@Test
	public void testCountUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Integer bum = userMapper.countUser();
		System.out.println(bum);
	}
	
}
