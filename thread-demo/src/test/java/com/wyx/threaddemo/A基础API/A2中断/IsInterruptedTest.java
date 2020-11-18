package com.wyx.threaddemo.A基础API.A2中断;

import org.junit.jupiter.api.Test;

/**
 * @Description :
 * @author : Just wyx
 * @Date : 2020/11/17
 */
public class IsInterruptedTest {

	/**
	 * Thread实例方法:用来检查指定线程的中断状态。当线程为中断状态时，
	 * 会返回true;否则返回 false。
	 */
	@Test
	public void test() {
		System.out.println(Thread.currentThread().isInterrupted());// false 现在还非中断
		// 中断主线程
		Thread.currentThread().interrupt();
		System.out.println(Thread.currentThread().isInterrupted());// true 获取是否是中断状态
		System.out.println(Thread.currentThread().isInterrupted());// true
		System.out.println(Thread.currentThread().isInterrupted());// true
	}
}
