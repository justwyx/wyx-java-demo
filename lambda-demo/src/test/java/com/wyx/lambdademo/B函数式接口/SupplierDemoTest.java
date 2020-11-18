package com.wyx.lambdademo.B函数式接口;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * Supplier，提供者，没有输入但有输出的函数接口。
 * 该接口只有一个抽象方法 get()，用 于获取函数接口方法的返回值。
 *
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class SupplierDemoTest {

	@Test
	public void testGet() {
		Supplier<String> supplier = () -> "hello";
		System.out.println(supplier.get());
	}
}

