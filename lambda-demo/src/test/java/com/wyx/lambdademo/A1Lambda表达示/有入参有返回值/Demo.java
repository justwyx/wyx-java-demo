package com.wyx.lambdademo.A1Lambda表达示.有入参有返回值;

import org.junit.jupiter.api.Test;

/**
 * @author : Just wyx
 * @Description : TODO 2020/11/18
 * @Date : 2020/11/18
 */
public class Demo {
	interface Some {
		String doSome(String str, int i);
	}

	@Test
	void test() {
		Some some = (str, i) -> {
			return str + " : " + i;
		};
		System.out.println(some.doSome("hello", 520));
	}

	@Test
	void test1() {
		Some some = (str, i) -> str + " : " + i;
		System.out.println(some.doSome("hello", 520));
	}
}
