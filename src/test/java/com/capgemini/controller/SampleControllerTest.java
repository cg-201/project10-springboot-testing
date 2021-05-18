package com.capgemini.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SampleControllerTest {

	@Test
	void test() {
		SampleController sc = new SampleController();
		String actual = sc.sayHello();
		
		assertEquals("Hello World!", actual);
	}

}
