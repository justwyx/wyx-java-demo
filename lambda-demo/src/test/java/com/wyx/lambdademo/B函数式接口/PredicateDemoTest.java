package com.wyx.lambdademo.B函数式接口;


import org.junit.Test;

import java.util.function.*;

/**
 * @Description : 断言
 * 该接口用于判断输入的对象是否符合某个条件。该接口中只有一个抽象方法 test()，
 * 三个默认方法 and(与)、or(或)、negate(非)，还有一个静态方法 isEqual()。
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class PredicateDemoTest {

	@Test
	public void testPredicate() {
		// 返回值 Boolean 入参 Integer
		Predicate<Integer> predicate = i -> i > 100;
		System.out.println(predicate.test(90)); // false
		System.out.println(predicate.test(190)); // true
	}

	@Test
	public void testIntPredicate() {
		// IntPredicate 与 Predicate 接口没有任何关系，是另外一种全新的接口，仅仅是为了使用 方便。
		IntPredicate predicate = i -> i > 100;
		System.out.println(predicate.test(90)); // false
		System.out.println(predicate.test(190)); // true
	}

	@Test
	public void testDoublePredicate() {
		// DoublePredicate 与 Predicate 接口没有任何关系，是另外一种全新的接口，仅仅是为了使用 方便。
		DoublePredicate predicate = i -> i > 100;
		System.out.println(predicate.test(90)); // false
		System.out.println(predicate.test(190)); // true
	}

	@Test
	public void testLongPredicate() {
		// LongPredicate 与 Predicate 接口没有任何关系，是另外一种全新的接口，仅仅是为了使用 方便。
		LongPredicate predicate = i -> i > 100;
		System.out.println(predicate.test(90)); // false
		System.out.println(predicate.test(190)); // true
	}

	@Test
	public void testBiPredicate() {
		// BiPredicate 与 Predicate 接口没有任何关系，是另外一种全新的接口，仅仅是为了使用 方便。
		// BiPredicate 两个入参
		BiPredicate<String, Integer> predicate = (str, i) -> "hello".equals(str) && i > 100;
		System.out.println(predicate.test("hello", 90)); // false
		System.out.println(predicate.test("hello", 190)); // true
	}


	@Test
	public void testAnd() {
		Predicate<Integer> p1 = i -> i > 100;
		Predicate<Integer> p2 = i -> i < 200;

		// and 两个断言都满足
		System.out.println(p1.and(p2).test(90)); // false
		System.out.println(p1.and(p2).test(150)); // true
		System.out.println(p1.and(p2).test(300)); // false
	}

	@Test
	public void testOr() {
		Predicate<Integer> p1 = i -> i > 100;
		Predicate<Integer> p2 = i -> i < 200;

		// or 两个断言都满足其一
		System.out.println(p1.or(p2).test(90)); // true
		System.out.println(p1.or(p2).test(150)); // true
		System.out.println(p1.or(p2).test(300)); // true
	}

	@Test
	public void testNegate() {
		Predicate<Integer> p1 = i -> i > 100;

		// negate 非 对结果取反
		System.out.println(p1.negate().test(90)); // true
		System.out.println(p1.negate().test(150)); // false
		System.out.println(p1.negate().test(300)); // false
	}

}
