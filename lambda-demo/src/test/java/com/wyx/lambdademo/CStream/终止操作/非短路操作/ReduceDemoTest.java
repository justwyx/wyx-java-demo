package com.wyx.lambdademo.CStream.终止操作.非短路操作;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Stream;

/**
 * reduce，减少，缩减。该方法的作用是将集合流最终转换为一个指定类型的数据。
 * 其参 数为二元接口 BinaryOperator，即两个输入一个输出，且类型相同。
 * 由两个输入最终变为了 一个输出，就达到了缩减 reduce 的效果了。
 *
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class ReduceDemoTest {

	@Test
	public void testForEachOrdered(){
		String words = "Beijing welcome you i love china";
		OptionalLong reduce = Stream.of(words.split(" "))
				.mapToLong(word -> word.length())
				.reduce((l1, l2) -> l1 + l2); // 计算单词长度之和
		System.out.println(reduce.getAsLong());
	}

	@Test
	public void testForEachOrdered1(){
		String words = "Beijing welcome you i love china";
		OptionalLong reduce = Stream.of(words.split(" "))
				.mapToLong(word -> word.length())
				.filter(l -> l > 20)
				.reduce((l1, l2) -> l1 + l2); // 计算单词长度之和
		System.out.println(reduce.orElse(0));
	}

	@Test
	public void testForEachOrdered3(){
		String words = "Beijing welcome you i love china";
		Optional<String> reduce = Stream.of(words.split(" "))
				.reduce((l1, l2) -> l1 + "," + l2);// 单词用逗号相连接
		System.out.println(reduce.orElse(""));
	}
}
