package com.example.demo.controller;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserNameController {

	/**
	 * This method will fetch an return the name of user from environment
	 * 
	 * @return name
	 */
	@GetMapping(value = "get-user")
	public ResponseEntity<Object> getUserName() {
		// fetching the user name from system environment and provide it in response
		return new ResponseEntity<Object>(Collections.singletonMap("name", "Hello " + System.getenv("NAME")),
				HttpStatus.OK);
	}
}
