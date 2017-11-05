package com.gxc.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MyStringUtils {

	/**
	 * 过得MD5加密后的数据
	 * @param value	明文
	 * @return 密文
	 */
	public static String getMD5Value(String value){
		
		try {
			//1. 获得JDK提供的消息摘要算法的工具类
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//2. 加密的结果是10进制的
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			//3. 将10进制转换为16进制
			BigInteger bigInteger = new BigInteger(1,md5ValueByteArray);
			
			return bigInteger.toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
}
