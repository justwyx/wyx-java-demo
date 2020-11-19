package com.wyx.lambdademo.ALambda表达示.引用.实例方法引用;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class DemoTest {
	/**
	 * 实例名::实例方法名
	 */
	@Test
	public void test(){
		Person person = new Person("张三");
		Function<Integer, String> play = person::play;
		System.out.println(play.apply(1));
	}
	@Test
	public void test1(){
		Person person = new Person("张三");
		Consumer<String> study = person::study;
		study.accept("java");
	}

	/**
	 * 类名::实例方法名
	 */
	@Test
	public void test3(){
		Person person = new Person("李四");
		BiFunction<Person, Integer, String> play = Person::play;
		System.out.println(play.apply(person, 1));
	}
	@Test
	public void test4(){
		Person person = new Person("张三");
		BiConsumer<Person, String> study = Person::study;
		study.accept(person, "java");
	}



	class Person {
		private String name;

		public Person(String name) {
			this.name = name;
		}

		/**
		 * 实例方法
		 */
		public String play(int minutes) {
			return name + "已经玩了" + minutes + "分钟了";
		}

		/**
		 * 实例方法
		 */
		public void study(String course) {
			System.out.println(name + "正在学习" + course);
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					'}';
		}
	}
}
