package com.wyx.lambdademo.CStream.终止操作.短路操作;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 用于判断是否全部不符合条件，只要找到一个符合的，马上返回 false。只有所有都不
 * 符合才会返回 true。
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class NoneMatchDemoTest {
	@Test
	public void testNoneMatch(){
		String words = "Beijing welcome you i love china";
		boolean b = Stream.of(words.split(" "))
				.noneMatch(s -> s.length() > 5);
		System.out.println("字符长度大于5,是否都不满足：" + b);
	}

	@Test
	public void testNoneMatch1(){
		String words = "Beijing welcome you i love china";
		boolean b = Stream.of(words.split(" "))
				.noneMatch(s -> s.length() > 10);
		System.out.println("字符长度大于10,是否都不满足：" + b);
	}
}
