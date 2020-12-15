package com.wyx.java.util.list;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Just wyx
 * @Date : 2020/12/7
 */
public class SubListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);

		// [1, 3) 前开后闭
		List<Integer> newList = list.subList(0, 10);
		System.out.println("oldList:" + list); // oldList:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
		System.out.println("index-1:" + list.get(0)); // index-1:1
		System.out.println("index-3:" + list.get(10)); // index-3:11
		System.out.println("newList:" + newList); // newList:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		System.out.println("newList:" + list.subList(10, list.size())); // newList:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

		System.out.println(20/20);
	}
}
