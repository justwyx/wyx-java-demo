package com.wyx.lambdademo.ALambda表达示.引用.静态方法引用;


import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class DemoTest {
	@Test
	public void test(){
		Consumer<Integer> consumer = Person::sleeping;
		consumer.accept(8);
	}

	@Test
	public void test1(){
		Runnable sleep = Person::sleep;
		sleep.run();
	}

	@Test
	public void test2(){
		BiConsumer<Integer, String> integerStringBiConsumer = Person::sleeping;
		integerStringBiConsumer.accept(1,"222");
	}

	@Test
	public void test3(){
		Supplier<Integer> get = Person::get;
		System.out.println(get.get());
	}




	static class Person {
		/**
		 * 静态方法 有入参无返回值
		 */
		public static void sleeping(int hours) {
			System.out.println("我们每天需要睡" + hours + "个小时");
		}
		/**
		 * 静态方法 多个入参无返回值
		 */
		public static void sleeping(int hours, String name) {
			System.out.println(name + "我们每天需要睡" + hours + "个小时");
		}
		/**
		 * 静态方法 无入参无返回值
		 */
		public static void sleep() {
			System.out.println("在睡觉中");
		}
		/**
		 * 静态方法 有入参有返回值
		 */
		public static int get() {
			return 1;
		}
	}
}
