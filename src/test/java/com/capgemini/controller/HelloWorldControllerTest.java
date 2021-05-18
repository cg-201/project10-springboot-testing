package com.capgemini.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test() throws Exception {
		mockMvc.perform(get("/api/hello-world/"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Hello World!")));
				
	}
	
	
	@Test
	void findEmployeeTest() throws Exception {
		mockMvc.perform(get("/api/hello-world/12"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("rohit@gmail.com"));
	}
	
	
	@Test
	void createEmployeeTest() throws Exception {
		
		Employee employee = new Employee();
		employee.setName("rahul");
		employee.setEmail("rahul@gmail.com");
		employee.setMobile("22334455");
		
		mockMvc.perform(post("/api/hello-world/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsBytes(employee)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("rahul@gmail.com"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("rahul"));
	}

}
