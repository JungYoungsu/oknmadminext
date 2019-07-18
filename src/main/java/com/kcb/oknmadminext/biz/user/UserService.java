package com.kcb.oknmadminext.biz.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kcb.oknmadminext.exception.InvalidCredentialsException;
import com.kcb.oknmadminext.security.jwt.JwtTokenUtil;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class UserService {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	private final UserRepository userDAO;

	public UserService(UserRepository userDAO) {
		this.userDAO = userDAO;
	}

	@GraphQLQuery(name = "users")
	public List<User> getUsers() {
		return userDAO.findAll();
	}

	@GraphQLQuery(name = "user")
	public User getUser(@GraphQLArgument(name = "id") String id) {
		return userDAO.findOne(id);
	}

	@GraphQLMutation(name = "signin")
	public String signin(@GraphQLArgument(name = "username") String username,
			@GraphQLArgument(name = "password") String password) throws InvalidCredentialsException {
		Optional<User> user = userDAO.findByUsername(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (user.isPresent()) {
			if (encoder.matches(password, user.get().getPassword())) {
				return jwtTokenUtil.generateToken(user.get().getUsername());
			} else {
				throw new InvalidCredentialsException("Invalid Credentials!");
			}
		} else {
			throw new InvalidCredentialsException("Invalid Credentials!");
		}
	}
}
