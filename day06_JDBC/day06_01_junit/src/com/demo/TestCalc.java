package com.demo;
import org.junit.Assert;
/*
 * 测试方法要求：
 * 		不能有返回值
 * 		不能有参数
 */
import org.junit.Test;

public class TestCalc {
	
	@Test
	public void test1(){
		Calc c = new Calc();
		Assert.assertEquals(9, c.add(4, 5),0.5);	//期望值，实际值，浮动值
	}
	
	@Test
	public void test2(){
		Calc c = new Calc();
		int sum = c.add(5, 8);
		System.out.println(sum);
	}
	
}
