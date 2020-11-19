package com.wyx.lambdademo.CStream.串行并行处理;


import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class DemoTest {

	/**
	 * 串行打印 1~100
	 */
	@Test
	public void test() {
		IntStream.range(1, 100)
				.peek(DemoTest::print)
				.count();
	}
	/**
	 * 并行打印 1~100
	 */
	@Test
	public void test1() {
		IntStream.range(1, 100)
				.parallel()
				.peek(DemoTest::print)
				.count();
	}

	/**
	 * 串行并行一起使用 打印 1~100
	 * 最终执行效果以最后使用的流为准。
	 */
	@Test
	public void test2() {
		IntStream.range(1, 100)
				.parallel() // 上面的并行设置失效了
				.peek(DemoTest::print)
				.sequential()
				.peek(DemoTest::print)
				.count();
	}
	@Test
	public void test3() {
		IntStream.range(1, 100)
				.sequential()  // 上面的串行设置失效了
				.peek(DemoTest::print)
				.parallel()
				.peek(DemoTest::print)
				.count();
	}



	private static void print(int i) {
		System.out.println(i + "---" + Thread.currentThread().getName());
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void printErr(int i) {
		System.err.println(i + "---" + Thread.currentThread().getName());
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
