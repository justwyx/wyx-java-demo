package com.wyx.lambdademo.CStream.惰性求值;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class DemoTest {
	/**
	 * Stream 流编程中对于中间方法的执行，存在一个惰性求值问题:
	 * 多个中间操作可以连 接起来形成一个链式调用，除非链式调用的最后执行了终止操作，
	 * 否则中间操作是不会执行 任何处理的。
	 * 即只有当终止操作执行时才会触发链式调用的执行，这种方法调用方式称为惰 性求值。
	 */
	private static int square(int i) {
		System.out.println("求i的平方：" + i);
		return i * i;
	}

	@Test
	public void test() {
		int[] nums = {1, 2, 3};
		IntStream stream = IntStream.of(nums);
		System.out.println(stream.map(i -> square(i)).sum());
	}

	/**
	 * 惰性求值，不进行结束操作，不会执行中间操作
	 * 所以这里不会执行square()方法
	 */
	@Test
	public void test1() {
		int[] nums = {1, 2, 3};
		IntStream stream = IntStream.of(nums);
		stream.map(i -> square(i));
	}
}
