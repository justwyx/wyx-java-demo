package com.wyx;

import com.wyx.service.SomeService;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author : Just wyx
 * @Date : 2020/11/30
 */
public class SomeServiceTest {
	@Test
	public void test() {
		ServiceLoader<SomeService> load = ServiceLoader.load(SomeService.class);

		Iterator<SomeService> iterator = load.iterator();

		while (iterator.hasNext()) {
			SomeService someService = iterator.next();
			someService.doSome();
		}
	}
}
