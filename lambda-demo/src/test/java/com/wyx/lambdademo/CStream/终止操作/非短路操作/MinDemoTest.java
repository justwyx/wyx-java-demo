package com.wyx.lambdademo.CStream.终止操作.非短路操作;

import org.junit.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 求取小值
 *
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class MinDemoTest {

	@Test
	public void testMax(){
		String words = "Beijing welcome you i a love china";
		Optional<String> max = Stream.of(words.split(" "))
				.min(Comparator.comparingInt(String::length));
		System.out.println(max.orElse(null)); // 只会取第一个找到的最小值 i
	}
}
