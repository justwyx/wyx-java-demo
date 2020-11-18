package com.wyx.lambdademo.A1Lambda表达示.无入参有返回值;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description : 无入参有返回值 demo
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class Demo {
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
