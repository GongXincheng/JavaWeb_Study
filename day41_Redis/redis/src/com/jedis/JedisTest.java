package com.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 通过Java程序访问redis数据库
 * @author 宫新程
 */
public class JedisTest {

	//获得单一的jedis对象操作数据库
	@Test
	public void testName() throws Exception {
		
		//1.获得连接对象
		Jedis jedis = new Jedis("192.168.11.128", 6379);
		//2.获得数据
		String username = jedis.get("username");
		System.out.println(username);
		//3.存储
		jedis.set("addr", "滕州");
		System.out.println(jedis.get("addr"));
		
		//3.关闭资源
		jedis.close();
	}
	
	
	//通过jedis的pool过的jedis连接对象
	@Test
	public void test2(){
		//0.创建pool的配置对象
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(30);	//最大闲置个数
		poolConfig.setMinIdle(10);	//最小闲置个数
		poolConfig.setMaxTotal(50);	//最大连接数
		
		//1.创建一个redis的连接池
		JedisPool pool = new JedisPool(poolConfig, "192.168.11.128", 6379);
		//2.获取redis连接，从pool中
		Jedis jedis = pool.getResource();
		System.out.println(jedis.get("addr"));
		
		//3.关闭资源
		jedis.close();
		pool.close();
	}
	
	//使用 JedisPoolUtils 类
	@Test
	public void test3() throws Exception {
		Jedis jedis = JedisPoolUtils.getJedis();
		jedis.set("username", "zhangsan");
		String string = jedis.get("username");
		System.out.println(string);
		JedisPoolUtils.Jedis(jedis);
	}
	
	
	//集群
	@Test
	public void testJedisCluster() throws Exception {
		//创建JedisCluster对象 ，参数nodes为Set类型HostAndPort
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.11.128", 7001));
		nodes.add(new HostAndPort("192.168.11.128", 7002));
		nodes.add(new HostAndPort("192.168.11.128", 7003));
		nodes.add(new HostAndPort("192.168.11.128", 7004));
		nodes.add(new HostAndPort("192.168.11.128", 7005));
		nodes.add(new HostAndPort("192.168.11.128", 7006));
		//直接使用 JedisCluster 操作redis
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("test", "123");
		String string = jedisCluster.get("test");
		System.out.println(string);
		jedisCluster.close();
	}

}
