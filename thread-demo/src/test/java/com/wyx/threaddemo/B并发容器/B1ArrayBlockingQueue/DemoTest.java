package com.wyx.threaddemo.B并发容器.B1ArrayBlockingQueue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue 是一个线程安全的、基于数组、有界的、阻塞的、FIFO 队列。
 * 试图向已满队列中放入元素会导致操作受阻塞;
 * 试图从空队列中提取元素将导致类似阻塞。
 * 此类基于 java.util.concurrent.locks.ReentrantLock 来实现线程安全，
 * 所以提供了 ReentrantLock 所能支持的公平性选择。
 * @author : Just wyx
 * @Date : 2020/11/18
 */
public class DemoTest {
	@Test
	public void test() throws InterruptedException {
		// 创建一个10个大小的阻塞队列
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		Thread t1 = new Thread(new Producer(queue));
		Thread t2 = new Thread(new Consumer(queue));
		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}


	class Producer implements Runnable {
		private BlockingQueue<Integer> queue;

		private int value = 0;

		public Producer(BlockingQueue queue) {
			this.queue = queue;
		}

		/**
		 * 生产者线程一直生产数据
		 */
		@Override
		public void run() {
			while (true) {
				value += 1;
//				queue.add(value); // 队列满了则会异常
				queue.offer(value); // 队列满了添加失败
				System.out.println("+++++++++++++++++++++++++++++现在添加数据：" + value);

				// 休息一会
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Consumer implements Runnable{
		private BlockingQueue<Integer> queue;

		public Consumer(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				Integer value;
//				value = queue.remove(); // 队列为空时会异常
				value = queue.poll(); // 队列为空时返回
				System.out.println("--------------------现在在消费，value = " + value);
				// 休息一会
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


}
