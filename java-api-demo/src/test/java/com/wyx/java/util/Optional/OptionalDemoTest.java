package com.wyx.java.util.Optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author : Just wyx
 * @Date : 2021/1/12
 */
public class OptionalDemoTest {
	@Test
	public void ofNullTest() {
		Optional.of(null);
	}

	@Test
	public void ofNullableNullTest() {
		Optional.ofNullable(null);
	}
}
