package com.wyx.lambdademo.CStream.创建.使用集合创建;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class DemoTest {
	/**
	 * 使用集合创建 Stream
	 */
	@Test
	public void test() {
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();

		Set<String> set = new HashSet<>();
		Stream<String> stream1 = set.stream();

		Map<String, String> map = new HashMap<>();
	}
}
