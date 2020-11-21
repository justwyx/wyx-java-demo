package com.wyx.lambdademo.CStream.中间操作.无状态操作;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 这是一个无状态操作。其功能是将流中的元素映射为多个值，即扁平化 map。
 * 其适用场 景为流中原来的每个元素为集合，该方法用于将每个集合元素全部打散，然后添加到流中。
 * 由于其参数为 Function，有输入与输出，所以 flatMap()操作会对流中元素产生影响。
 * 需 要注意的是，该 Function 的输出类型为 Stream。
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class FlatMapDemoTest {

	/**
	 * 输出指定字符串中的所有字母。
	 */
	@Test
	public void testFlatMap(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.flatMap(word -> word.chars().boxed())
				.forEach(ch -> System.out.print((char)ch.intValue() + " "));
	}

	@Test
	public void testFlatMap2(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.flatMap(word -> Stream.of(word.split("")))
				.forEach(w -> System.out.print(w + " "));
	}

}
