package com.kcb.oknmadminext.graphql;

import org.springframework.stereotype.Service;

import graphql.ExecutionResult;

@Service
public class UserUseCase {
	private final UserDetails userDetails;

	public UserUseCase(UserDetails userDetails) {
		this.userDetails = userDetails;
	}	
	
	public ExecutionResult execute(String query) {
		return userDetails.execute(query);
	}
}
