package com.wyx.lambdademo.CStream.创建.自定义流;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class DemoTest {

	/**
	 * 自定义流 Stream
	 */
	@Test
	public void test() {
		// 首先生成一个无限流，然后又限定 5个元素（limit(5)）
		Stream<Double> limit = Stream.generate(() -> Math.random()).limit(5);
	}
}
