package com.kcb.oknmadminext.biz.user;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class User {
	public User(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	@Id
	@GraphQLQuery(name = "id", description = "A user's id")
	private long id;
	@GraphQLQuery(name = "name", description = "A user's name")
	private String username;
	@GraphQLQuery(name = "password", description = "A user's password")
	private String password;
	@GraphQLQuery(name = "token", description = "A user's token")
	private String token;
	@GraphQLQuery(name = "email", description = "A user's email")
	private String email;
	@GraphQLQuery(name = "role", description = "A user's role")
	private String role;
}
