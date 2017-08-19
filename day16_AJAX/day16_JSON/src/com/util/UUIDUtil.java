package com.util;

import java.util.UUID;

public class UUIDUtil {
	public static String getUUID(){
		return UUID.randomUUID().toString();	//得到随机的字符串
	}
}
