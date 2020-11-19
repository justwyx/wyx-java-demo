package com.wyx.lambdademo.CStream.创建.创建数字流;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class DemoTest {

	/**
	 * 使用数字流 Stream
	 */
	@Test
	public void test() {
		int[] nums = {1, 2, 3, 4, 5};
		IntStream nums1 = IntStream.of(nums);
		IntStream stream = Arrays.stream(nums);

		// 创建一个[1,5)范围的stream
		IntStream range = IntStream.range(1, 5);
		// 创建一个[1,5]范围的stream
		IntStream range1 = IntStream.rangeClosed(1, 5);

		// Random().ints() 创建一个无限流
		// limit(5) 限制流中元素个数为5个
		IntStream limit = new Random().ints().limit(5);
		// 等价上面
		IntStream ints = new Random().ints(5);
	}
}
