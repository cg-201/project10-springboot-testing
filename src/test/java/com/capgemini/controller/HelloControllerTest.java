package com.capgemini.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloController.class)
class HelloControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void test() throws Exception {
		mockMvc.perform(get("/api/hello/"))
				.andExpect(MockMvcResultMatchers.content().string(containsString("Hello!")));
	}
	
	
	@Test
	void findEmployeeTest() throws Exception {
		mockMvc.perform(get("/api/hello/12"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("rohit a"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("rohit@gmail.com"));
				
	}

}
