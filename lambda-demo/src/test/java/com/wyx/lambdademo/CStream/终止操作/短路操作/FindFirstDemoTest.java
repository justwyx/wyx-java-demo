package com.wyx.lambdademo.CStream.终止操作.短路操作;

import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * findFirst()与 findAny()方法均会将从流中查找到的元素封装到 Optional 容器对象中。若没
 * 有找到，则 Optional 容器对象中的值会为空，Optional 对象的 isPresent()方法返回值会为 false。
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class FindFirstDemoTest {

	/**
	 * FindFirst 只要找到一个元素，马上停止查找
	 */
	@Test
	public void testFindFirst(){
		String words = "Beijing welcome you i love china";
		String s = Stream.of(words.split(" "))
				.findFirst()
				.orElse("没有一个元素");
		System.out.println(s);
	}

	/**
	 * FindFirst 只要找到一个元素，马上停止查找
	 */
	@Test
	public void testFindFirst1(){
		String words = "Beijing welcome you i love china";
		String s = Stream.of(words.split(" "))
				.filter(w -> w.length() > 10)
				.findFirst()
				.orElse("没有一个元素");
		System.out.println(s);
	}

}
