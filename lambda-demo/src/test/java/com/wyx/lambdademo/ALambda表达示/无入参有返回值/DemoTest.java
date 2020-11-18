package com.wyx.lambdademo.ALambda表达示.无入参有返回值;

import org.junit.jupiter.api.Test;

/**
 * @Description : 无入参有返回值 demo
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class DemoTest {
	interface Some {
		long doSome();
	}

	@Test
	void test() {
		Some some = () -> {
			return System.nanoTime();
		};
		System.out.println(some.doSome());
	}

	@Test
	void test1() {
		Some some = () -> System.nanoTime();
		System.out.println(some.doSome());
	}
}
