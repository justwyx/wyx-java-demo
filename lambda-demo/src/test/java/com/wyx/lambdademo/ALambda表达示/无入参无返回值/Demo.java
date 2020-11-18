package com.wyx.lambdademo.ALambda表达示.无入参无返回值;

import org.junit.jupiter.api.Test;

/**
 * @Description : 无入参无返回值 demo
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class Demo {
	interface Some {
		void doSome();
	}

	@Test
	void test() {
		Some some = () ->{
			System.out.println("hello");
		};
		some.doSome();
	}

	@Test
	void test1() {
		Some some = () -> System.out.println("hello");
		some.doSome();
	}
}
