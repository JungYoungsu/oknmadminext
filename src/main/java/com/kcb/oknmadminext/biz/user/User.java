package com.kcb.oknmadminext.biz.user;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class User {
	@GraphQLQuery(name = "id", description = "A user's id")
	private String id;
	@GraphQLQuery(name = "name", description = "A user's name")
	private String name;
	@GraphQLQuery(name = "passwd", description = "A user's password")
	private String passwd;
}
