package com.kcb.oknmadminext.biz.user;

import java.util.List;

import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class UserService {
	private final UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	@GraphQLQuery(name = "users")
	public List<User> getUsers() {
		return userDAO.selectUserAll();
	}
	
	@GraphQLQuery(name = "user")
	public User getUser(@GraphQLArgument(name = "id") String id) {
		return userDAO.selectUserById(id);
	}
}
