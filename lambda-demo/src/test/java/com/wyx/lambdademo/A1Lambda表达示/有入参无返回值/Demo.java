package com.wyx.lambdademo.A1Lambda表达示.有入参无返回值;

import org.junit.jupiter.api.Test;

/**
 * @Description : 有入参无返回值 demo
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class Demo {
	interface Some {
		void doSome(int i);
	}

	@Test
	void test() {
		Some some = i -> {
			System.out.println("hello: " + i);
		};
		some.doSome(10);
	}

	@Test
	void test1() {
		Some some = i -> System.out.println("hello: " + i);
		some.doSome(10);
	}
}
