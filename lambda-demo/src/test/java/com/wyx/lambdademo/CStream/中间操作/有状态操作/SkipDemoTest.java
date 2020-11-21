package com.wyx.lambdademo.CStream.中间操作.有状态操作;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 从流中去除指定个数的元素。
 *
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class SkipDemoTest {

	/**
	 * 从流中去除指定个数的元素。
	 *
	 */
	@Test
	public void testSkip(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.flatMap(word -> Stream.of(word.split("")))
				.skip(7) // 路过了7个字符，正是Beijing，返回 w e l c o m e y o u i l o v e c h i n a
				.forEach(w -> System.out.print(w + " "));
	}
}
