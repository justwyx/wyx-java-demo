package com.wyx.lambdademo.CStream.中间操作.无状态操作;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 这是一个无状态操作。其功能是将流中的元素映射为另一个值。由于其参数为 Function， 有一个输入与输出。
 * 由于有输出，所以 map()操作会流中元素产生影响
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class MapDemoTest {

	/**
	 * 将指定字符串中每个单词映射为每个单词的长度
	 * 注意这些是无状态操作，输出结果为
	 * Beijing
	 * 7
	 * welcome
	 * 7
	 * 3
	 * you
	 * 1
	 * i
	 * love
	 * 4
	 * china
	 * 5
	 */
	@Test
	public void testMap(){
		String words = "Beijing welcome you i love china";
		Stream.of(words.split(" "))
				.peek(System.out::println)
				.map(word -> word.length())
				.forEach(System.err::println);
	}


}
