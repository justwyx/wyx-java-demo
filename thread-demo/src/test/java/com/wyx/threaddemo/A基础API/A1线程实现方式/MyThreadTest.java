package com.wyx.threaddemo.A基础API.A1线程实现方式;

import org.junit.jupiter.api.Test;

/**
 * @Description : 线程实现方式1:继承Thread类
 * @author : Just wyx
 * @Date : 2020/11/17
 */
public class MyThreadTest{

	class MyThread extends Thread{
		@Override
		public void run() {
			System.out.println("run-threadName: " + Thread.currentThread().getName());
			System.out.println("hello thread run");
		}
	}

	@Test
	public void test(){
		System.out.println("main-threadName: " + Thread.currentThread().getName());
		new MyThread().start();
	}

}
