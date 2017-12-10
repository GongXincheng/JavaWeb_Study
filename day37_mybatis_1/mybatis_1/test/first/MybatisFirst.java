package first;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.gxc.entity.User;

public class MybatisFirst {

	/**
	 * 根据用户Id查询用户信息 
	 * @throws IOException
	 */
	@Test
	public void findUserByIdTest() throws IOException{
		/*//全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//调用SqlSession的增删改查方法
		//第一个参数：表示 statement的唯一标识
		//第二个参数：要传的值
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		//关闭资源
		sqlSession.close();*/
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		sqlSession.close();
	}
	
	
	
	/**
	 * 根据用户名称模糊查询用户信息
	 * @throws IOException
	 */
	@Test
	public void findUserByNameTest() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource );
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> list = sqlSession.selectList("test.findUserByName", "GXC");
		
		for (User user : list) {
			System.out.println(user);
		}
		
		sqlSession.close();
	}
	
	/**
	 * @throws IOException
	 */
	@Test
	public void insertUserTest() throws IOException{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		
		//添加用户
		User user = new User();
		user.setUsername("GXC");
		sqlSession.insert("test.insertUser", user);
		
		//获取插入后的用户Id
		System.out.println("------------"+user.getId()+"-----------");
		
		
		//提交事务
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
