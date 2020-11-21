package com.wyx.lambdademo.CStream.中间操作.有状态操作;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 过滤掉流中重复元素，无参数。
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class DistinctDemoTest {

	/**
	 * 过滤掉流中重复元素，无参数。
	 */
	@Test
	public void testDistinct(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.flatMap(word -> Stream.of(word.split("")))
				.distinct()
				.forEach(w -> System.out.print(w + " "));
	}
}
