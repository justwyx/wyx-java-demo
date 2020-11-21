package com.wyx.lambdademo.CStream.终止操作.短路操作;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 用于判断是否存在符合条件的元素，只要找到一个符合的元素，马上结束匹配并返回 true。
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class AnyMatchDemoTest {
	@Test
	public void testAnyMatch(){
		String words = "Beijing welcome you i love china";
		boolean b = Stream.of(words.split(" "))
				.anyMatch(s -> s.length() > 5);
		System.out.println("其中有一个字符长度大于5：" + b);
	}

	@Test
	public void testAllMatch1(){
		String words = "Beijing welcome you i love china";
		boolean b = Stream.of(words.split(" "))
				.anyMatch(s -> s.length() > 10);
		System.out.println("其中有一个字符长度大于10：" + b);
	}
}
