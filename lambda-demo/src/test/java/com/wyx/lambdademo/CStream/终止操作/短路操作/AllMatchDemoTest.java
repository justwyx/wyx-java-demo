package com.wyx.lambdademo.CStream.终止操作.短路操作;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 用于判断是否所有元素都符合指定的条件，只要有一个不符合，马上结束匹配并返回 false。只有所有都匹配上了才会返回 true。
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class AllMatchDemoTest {
	@Test
	public void testAllMatch(){
		String words = "Beijing welcome you i love china";
		boolean b = Stream.of(words.split(" "))
				.allMatch(s -> s.length() > 10);
		System.out.println("所有字符长度都大于10：" + b);
	}

	@Test
	public void testAllMatch1(){
		String words = "Beijing welcome you i love china";
		boolean b = Stream.of(words.split(" "))
				.allMatch(s -> s.length() < 10);
		System.out.println("所有字符长度都小于10：" + b);
	}
}
