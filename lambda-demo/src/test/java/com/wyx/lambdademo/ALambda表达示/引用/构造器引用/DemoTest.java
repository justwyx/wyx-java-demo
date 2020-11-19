package com.wyx.lambdademo.ALambda表达示.引用.构造器引用;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class DemoTest {
	/**
	 * 无参构造器
	 */
	@Test
	public void test(){
		Supplier<Person> runnable = Person::new;
		System.out.println(runnable.get());
	}

	/**
	 * 带参构造器
	 */
	@Test
	public void test1(){
		Function<String, Person> runnable = Person::new;
		System.out.println(runnable.apply("王五"));
	}



	class Person {
		private String name;

		public Person() {
		}

		public Person(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					'}';
		}
	}
}
