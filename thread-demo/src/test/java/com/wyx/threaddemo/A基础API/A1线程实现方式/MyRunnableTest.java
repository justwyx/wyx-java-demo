package com.wyx.threaddemo.A基础API.A1线程实现方式;

import org.junit.jupiter.api.Test;

/**
 * @Description : 线程实现方式2:实现Runnable接口
 * @author : Just wyx
 * @Date : 2020/11/17
 */
public class MyRunnableTest {

	class MyRunnable implements Runnable{
		@Override
		public void run() {
			System.out.println("run-threadName: " + Thread.currentThread().getName());
			System.out.println("hello Runnable run");
		}
	}

	/**
	 * 简单的启动一个线程
	 */
	@Test
	public void test() {
		System.out.println("main-threadName: " + Thread.currentThread().getName());
		new Thread(new MyRunnable()).start();
	}

	/**
	 * lambda方式创建启动
	 */
	@Test
	public void test1() {
		new Thread(() -> {
			System.out.println("run-threadName: " + Thread.currentThread().getName());
			System.out.println("hello Runnable run");
		}).start();
	}
}
