package com.wyx.java.util.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Just wyx
 * @Date : 2020/12/22
 */
public class MapDemoTest {

	/**
	 * containsKey : 已经包含返回 true
	 * 不包含返回 false
	 */
	@Test
	public void containsKeyTest() {
		Map<Integer, Integer> map = new HashMap();
		map.put(1, 1);
		System.out.println(map.containsKey(1));
		System.out.println(map.containsKey(2));
		assert map.containsKey(1);
	}
}
