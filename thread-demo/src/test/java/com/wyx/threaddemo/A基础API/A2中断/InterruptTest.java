package com.wyx.threaddemo.A基础API.A2中断;

import org.junit.jupiter.api.Test;

/**
 * @Description : 中断测试
 * @author : Just wyx
 * @Date : 2020/11/17
 */
public class InterruptTest{

	/**
	 * 中断不会有异常
	 * Thread实例方法:必须由其它线程获取被调用线程的实例后，进行调用。
	 * 实际上，只是改变了被调用线 程的内部中断状态;
	 */
	@Test
	public void test() {
		Thread thread = new Thread(() -> System.out.println(111));
		// 启动
		thread.start();
		// 执行中断
		thread.interrupt();
	}


	/**
	 * java.lang.Thread类有一个 interrupt 方法，该方法直接对线程调用。
	 * 当被interrupt的线程正在 sleep或wait时，会抛出 InterruptedException 异常。
	 * 事实上，interrupt方法只是改变目标线程的中断状态(interrupt status)，
	 * 而那些会抛出 InterruptedException 异常的方法，
	 * 如wait、sleep、join等，都是在方法内部不断地检查中断状 态的值。
	 */
	@Test
	public void testError() {
		Thread thread = new Thread(() -> {
			System.out.println(111);
			// 执行了sleep,如果中断会出现异常
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		// 启动
		thread.start();
		// 执行中断
		thread.interrupt();
	}
}
