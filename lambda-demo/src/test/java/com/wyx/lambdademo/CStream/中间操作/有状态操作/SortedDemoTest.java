package com.wyx.lambdademo.CStream.中间操作.有状态操作;

import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 对流中的元素进行排序。没有参数的 sorted()默认是按照字典序排序的，即按照 ASCII 排序的。可以使用带参方法指定排序规则。
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class SortedDemoTest {

	/**
	 * 对于去重后的流中元素按照字典序排序。
	 */
	@Test
	public void testSorted(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.flatMap(word -> Stream.of(word.split("")))
				.distinct()
				// 非排序            	B e i j n g w l c o m y u v h a
				.sorted() // 默认排序 	B a c e g h i j l m n o u v w y
				.forEach(w -> System.out.print(w + " "));
	}

	/**
	 *  对于去重后的流中元素按照逆字典序排序。
	 */
	@Test
	public void testSorted2(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.flatMap(word -> Stream.of(word.split("")))
				.distinct()
				.sorted((o1, o2) -> o2.charAt(0) - o1.charAt(0)) // 逆字典序排序	y w v u o n m l j i h g e c a B
				.forEach(w -> System.out.print(w + " "));
	}

}
