package com.wyx.lambdademo.CStream.终止操作.非短路操作;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 将流中的最终数据收集到数组中。
 *
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class ToArrayDemoTest {

	@Test
	public void testForEachOrdered(){
		String words = "Beijing welcome you i love china";
		Object[] sArr = Stream.of(words.split(" "))
				.toArray();
		System.out.println(Arrays.toString(sArr));
	}
}
