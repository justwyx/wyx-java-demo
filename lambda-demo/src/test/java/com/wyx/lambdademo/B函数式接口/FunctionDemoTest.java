package com.wyx.lambdademo.B函数式接口;

import org.junit.Test;

import java.util.function.Function;

/**
 * 只有一个输入，且有一个输出的函数接口。
 * 该接口中有一个抽象方法 apply()，
 * 有两个默认方法 andThen()与 compose()，
 * 及一个静态方法 identity()
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class FunctionDemoTest {
	@Test
	public void testApply() {
		// Function<入参类型, 出参类型>
		Function<Integer, String> function = i -> {
			i *= i;
			return "result: " + i;
		};
		System.out.println(function.apply(5));
	}

	@Test
	public void testAndThen() {
		Function<Integer, Integer> fun1 = i -> 2 * i;
		Function<Integer, Integer> fun2 = i -> i * i;

		// andThen 先执行 fun1, 将fun1的结果当做 fun2的入参，在执行fun2
		// (2 * i) * (2 * i) = 100
		System.out.println(fun1.andThen(fun2).apply(5));
	}

	@Test
	public void testCompose() {
		Function<Integer, Integer> fun1 = i -> 2 * i;
		Function<Integer, Integer> fun2 = i -> i * i;

		// compose 先执行 fun2, 将fun2的结果当做 fun1的入参，在执行fun1
		// 2 * (i * i) = 50
		System.out.println(fun1.compose(fun2).apply(5));
	}

	@Test
	public void testIdentity() {
		// 这是 Function 接口包含的静态方法，其返回结果为该 Function 的输入参数值。
		System.out.println(Function.identity().apply(1)); // 1
		System.out.println(Function.identity().apply(10));// 10
	}
}
