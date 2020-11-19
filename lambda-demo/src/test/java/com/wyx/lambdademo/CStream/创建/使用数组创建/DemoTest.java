package com.wyx.lambdademo.CStream.创建.使用数组创建;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class DemoTest {

	/**
	 * 使用数组创建 Stream
	 */
	@Test
	public void test() {
		int[] nums = {1, 2, 3, 4, 5};
		IntStream nums1 = IntStream.of(nums);
		IntStream stream = Arrays.stream(nums);
	}
}
