package com.wyx.lambdademo.CStream.中间操作.无状态操作;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 其功能是将流中的元素映射为指定类型的元素，不同的流其可映射为的元素类型是不同的，
 * 即其所拥有的 mapToXxx()方法是不同的
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class MapToXxxDemoTest {

	/**
	 * 将整数转换为字符串。
	 * 1
	 * No.1
	 * 2
	 * No.2
	 * 3
	 * No.3
	 * 4
	 * No.4
	 * 5
	 * No.5
	 * 6
	 * No.6
	 * No.7
	 * 7
	 * No.8
	 * 8
	 * No.9
	 * 9
	 * 10
	 * No.10
	 */
	@Test
	public void testMapToObj(){
		IntStream.rangeClosed(1,10)
				.peek(System.err::println)
				.mapToObj(i -> "No." + i)
				.forEach(System.out::println);
	}

	/**
	 * 将数值型字符串转换为其相应的整型数。
	 */
	@Test
	public void testMapToLong(){
		Stream.of("111","222","333")
				.peek(System.err::println)
				.mapToLong(Long::valueOf)
				.forEach(System.out::println);
	}


}
