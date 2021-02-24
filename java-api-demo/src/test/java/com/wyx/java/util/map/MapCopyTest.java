package com.wyx.java.util.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于测试浅拷贝深拷贝
 * @author : Just wyx
 * @Date : 2021/1/19
 */
public class MapCopyTest {

	/**
	 * 深拷贝test
	 * putAll会进行深拷贝
	 */
	@Test
	public void deepCopyTest() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(10, 10);
		map.put(20, 20);
		System.out.println("map:" + map);

		Map<Integer, Integer> mapCopy = new HashMap<>();
		mapCopy.putAll(map);
		mapCopy.remove(10);
		System.out.println("map:" + map);
		System.out.println("mapCopy:" + mapCopy);

	}
}
