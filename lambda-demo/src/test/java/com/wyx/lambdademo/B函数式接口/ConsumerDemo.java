package com.wyx.lambdademo.B函数式接口;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Description :
 * Consumer，消费者，只有一个输入没有输出的函数接口。
 * 该接口有一个抽象方法 accept()，
 * 与一个默认方法 andThen()。
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class ConsumerDemo {
	@Test
	public void testAccept() {
		Consumer<Integer> consumer = i -> System.out.println("这次输入的是：" + i);
		consumer.accept(1);
	}

	/**
	 * andThen 用同样的入参，先执行 c1,在执行 c2
	 */
	@Test
	public void testAndThen() {
		Consumer<Integer> c1 = i -> System.out.println(2 * i);
		Consumer<Integer> c2 = i -> System.out.println(i * i);
		c1.andThen(c2).accept(5);
	}

}
