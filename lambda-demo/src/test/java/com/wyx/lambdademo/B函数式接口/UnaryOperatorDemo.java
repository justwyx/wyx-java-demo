package com.wyx.lambdademo.B函数式接口;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 输入输出类型相同的 Function
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class UnaryOperatorDemo {

	@Test
	public void testApply() {
		UnaryOperator<String> u = str -> "hello " + str;
		System.out.println(u.apply("world")); // hello world
	}

	@Test
	public void testAndThen() {
		UnaryOperator<Integer> fun1 = i -> 2 * i;
		UnaryOperator<Integer> fun2 = i -> i * i;

		// andThen 先执行 fun1, 将fun1的结果当做 fun2的入参，在执行fun2
		// (2 * i) * (2 * i) = 100
		System.out.println(fun1.andThen(fun2).apply(5));
	}

	@Test
	public void testCompose() {
		UnaryOperator<Integer> fun1 = i -> 2 * i;
		UnaryOperator<Integer> fun2 = i -> i * i;

		// compose 先执行 fun2, 将fun2的结果当做 fun1的入参，在执行fun1
		// 2 * (i * i) = 50
		System.out.println(fun1.compose(fun2).apply(5));
	}

	@Test
	public void testIdentity() {
		// 这是 Function 接口包含的静态方法，其返回结果为该 Function 的输入参数值。
		System.out.println(UnaryOperator.identity().apply(1)); // 1
		System.out.println(UnaryOperator.identity().apply(10));// 10
	}

}
