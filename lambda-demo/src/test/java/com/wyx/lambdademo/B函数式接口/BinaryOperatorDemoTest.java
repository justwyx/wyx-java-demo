package com.wyx.lambdademo.B函数式接口;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 有两个输入与一个输出的函数接口。
 * BiFunction 接口与 Function 接口没有任何关系。
 * 其 有一个抽象方法 apply()，与一个默认方法 andThen()。这两个方法的意义与前面的相同。
 * @author : Just wyx
 * @Date : 2020/11/19
 */
public class BinaryOperatorDemoTest {



	/**
	 * BinaryOperator:两个入参和一个返回都是相同类型
	 */
	@Test
	public void testApply() {
		BinaryOperator<Integer> biFunction = (i, j) -> i + j;
		System.out.println(biFunction.apply(3, 5));
	}

	/**
	 * andThen : 将 biFunction 结果的值传入 function 当入参
	 */
	@Test
	public void testAndThen() {
		BinaryOperator<Integer> biFunction = (i, j) -> i + j;
		Function<Integer, String> function = sum -> "相加结果是：" + sum;
		System.out.println(biFunction.andThen(function).apply(3, 5));
	}

	/**
	 * UnaryOperator test
	 */
	@Test
	public void testAndThen1() {
		BinaryOperator<Integer> biFunction = (i, j) -> i + j;
		UnaryOperator<Integer> unaryOperator = sum -> sum * 2;
		// (3 + 5) * 2
		System.out.println(biFunction.andThen(unaryOperator).apply(3, 5));
	}


	@Test
	public void testMaxMin() {
		Student s1 = new Student("张三", 12);
		Student s2 = new Student("李四", 23);

		// 比较大小
		Student max = BinaryOperator.maxBy(s1).apply(s1, s2);
		Student min = BinaryOperator.minBy(s1).apply(s1, s2);
		System.out.println("max:" + max);
		System.out.println("min:" + min);
	}


	class Student implements Comparator<Student> {
		private String name;
		private Integer age;

		public Student(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}


		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}

		@Override
		public String toString() {
			return "Student{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}
	}
}
