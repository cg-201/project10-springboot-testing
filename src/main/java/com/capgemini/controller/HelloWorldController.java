package com.capgemini.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Employee;

@RestController
@RequestMapping("/api/hello-world/")
public class HelloWorldController {

	@GetMapping("/")
	public ResponseEntity<String>  sayHello() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable int id) {
		
		Employee e = new Employee();
		e.setId(id);
		e.setName("rohit a");
		e.setEmail("rohit@gmail.com");
		e.setMobile("1122334455");
		
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
}
