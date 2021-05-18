package com.capgemini.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Employee;

@RestController
@RequestMapping("/api/hello/")
public class HelloController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello!";
	}
	
	
	@GetMapping("/{id}")
	public Employee findEmployee(@PathVariable int id) {
		
		Employee e = new Employee();
		e.setId(id);
		e.setName("rohit a");
		e.setEmail("rohit@gmail.com");
		e.setMobile("1122334455");
		
		return e;
	}
}
