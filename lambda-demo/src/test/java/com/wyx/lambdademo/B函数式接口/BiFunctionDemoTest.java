package com.wyx.lambdademo.B函数式接口;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 有两个输入与一个输出的函数接口。
 * BiFunction 接口与 Function 接口没有任何关系。
 * 其 有一个抽象方法 apply()，与一个默认方法 andThen()。这两个方法的意义与前面的相同。
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class BiFunctionDemoTest {

	/**
	 * BiFunction<入参1，入参2，返回>
	 */
	@Test
	public void testApply() {
		BiFunction<Integer, Integer, String> biFunction = (i, j) -> i + " : " + j;
		System.out.println(biFunction.apply(3, 5));
	}

	/**
	 * andThen : 将 biFunction 结果的值传入 function 当入参
	 */
	@Test
	public void testAndThen() {
		BiFunction<Integer, Integer, String> biFunction = (i, j) -> i + " : " + j;
		Function<String, String> function = str -> "键值对是：" + str;
		System.out.println(biFunction.andThen(function).apply(3, 5));
	}

	/**
	 * UnaryOperator test
	 */
	@Test
	public void testAndThen1() {
		BiFunction<Integer, Integer, String> biFunction = (i, j) -> i + " : " + j;
		UnaryOperator<String> unaryOperator = str -> "键值对是：" + str;
		System.out.println(biFunction.andThen(unaryOperator).apply(3, 5));
	}
}
