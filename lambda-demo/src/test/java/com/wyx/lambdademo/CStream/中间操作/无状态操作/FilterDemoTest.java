package com.wyx.lambdademo.CStream.中间操作.无状态操作;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 用于过滤掉不适合指定条件的流中的元素。其参数为 Predicate 断言，用于设置过滤条件。
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class FilterDemoTest {

	/**
	 * 过滤掉长度为小于 5 的单词，即保留所有长度大于 4 的单词。
	 */
	@Test
	public void testFilter(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.filter(word -> word.length() > 4)
				.forEach(System.err::println);
	}


}
