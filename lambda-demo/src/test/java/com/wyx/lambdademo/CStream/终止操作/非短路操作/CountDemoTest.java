package com.wyx.lambdademo.CStream.终止操作.非短路操作;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 统计流中的元素个数。
 *
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class CountDemoTest {

	@Test
	public void testForEachOrdered(){
		String words = "Beijing welcome you i love china";
		long count = Stream.of(words.split(" "))
				.count();
		System.out.println(count);
	}
}
