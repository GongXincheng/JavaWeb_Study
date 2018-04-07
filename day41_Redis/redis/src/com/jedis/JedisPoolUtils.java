package com.jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {

	private static JedisPool pool= null;
	
	static{
		
		//加载配置文件
		InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
			
			JedisPoolConfig poolConfig = new JedisPoolConfig();
			poolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("redis.maxIdle")));
			poolConfig.setMinIdle(Integer.parseInt(pro.getProperty("redis.minIdle")));
			poolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("redis.maxTotal")));
			
			//获得JedisPool对象
			pool = new JedisPool(poolConfig, pro.getProperty("redis.url"), Integer.parseInt(pro.getProperty("redis.port")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获得jedis资源的方法
	public static Jedis getJedis(){
		Jedis jedis = pool.getResource();
		return jedis;
	}
	
	//关闭Jedis资源
	public static void Jedis(Jedis jedis){
		if(jedis!=null){
			jedis.close();
		}
	}
	
	//测试
	public static void main(String[] args) {
		Jedis jedis = getJedis();
		System.out.println(jedis.get("username")); //zhangsan
		Long del = jedis.del("addr");
		if(del>0){
			System.out.println("删除成功");
			System.out.println(jedis.get("addr"));	//null
		}
		else{
			System.out.println("删除失败");
		}
		
	}
}
