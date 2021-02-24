package com.wyx.java.lang;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : Just wyx
 * @Date : 2021/1/29
 */
public class StringDemoTest {

	@Test
	public void testSplit() {
		String str1 = "";
		String[] split = str1.split(" ");
		System.out.println(Arrays.toString(split));
		System.out.println(split.length);
	}
}
