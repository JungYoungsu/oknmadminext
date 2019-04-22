package com.kcb.oknmadminext.biz.user;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
	public User(String id, String name, String passwd) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
	}

	@GraphQLQuery(name = "id", description = "A user's id")
	private String id;
	@GraphQLQuery(name = "name", description = "A user's name")
	private String name;
	@GraphQLQuery(name = "passwd", description = "A user's password")
	private String passwd;
}
