package com.wyx.lambdademo.CStream.终止操作.非短路操作;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 遍历流中的元素，若流中的元素原本具有顺序，则按照原顺序排序。该方法与 forEach()
 * 方法的区别主要体现在并行操作中。forEach()在并行操作下会打乱原顺序。
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class ForEachOrderedDemoTest {
	/**
	 * Beijing welcome you i love china
	 */
	@Test
	public void testForEachOrdered(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.forEach(s -> System.out.print(s + " "));
	}

	/**
	 * Beijing welcome you i love china
	 */
	@Test
	public void testForEachOrdered2(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.forEachOrdered(s -> System.out.print(s + " "));
	}


	/**
	 * 注意多线程情况下顺序变了： i Beijing you love china welcome
	 */
	@Test
	public void testForEachOrdered3(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.parallel()
				.forEach(s -> System.out.print(s + " "));
	}

	/**
	 * 多线程情况下顺序没变
	 * Beijing welcome you i love china
	 */
	@Test
	public void testForEachOrdered4(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.parallel()
				.forEachOrdered(s -> System.out.print(s + " "));
	}

}
