package com.wyx.threaddemo.A基础API.A2中断;

import org.junit.jupiter.api.Test;

/**
 * @Description :
 * @author : Just wyx
 * @Date : 2020/11/17
 */
public class InterruptedTest {

	/**
	 * Thread类方法:必须在当前执行线程内调用，该方法返回当前线程的内部中断状态，然后清除中断状态
	 */
	@Test
	public void test() {
		// false 现在还非中断
		System.out.println(Thread.currentThread().interrupted());// false
		// 中断主线程
		Thread.currentThread().interrupt();
		// true 第一次是中断状态，interrupted()会返回是否中断状态
		// 然后清除中断状态,所以后续的都是非中断状态了
		System.out.println(Thread.currentThread().interrupted());// true
		System.out.println(Thread.currentThread().interrupted());// false
		System.out.println(Thread.currentThread().interrupted());// false
	}
}
