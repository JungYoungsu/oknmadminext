package com.kcb.oknmadminext.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcb.oknmadminext.graphql.UserUseCase;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserUseCase userUseCase;

	public UserController(UserUseCase userUseCase) {
		super();
		this.userUseCase = userUseCase;
	}
	
	@PostMapping
	public ResponseEntity<Object> getUserByQuery(@RequestBody String query) {
		ExecutionResult execute = userUseCase.execute(query);
		
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}
}
