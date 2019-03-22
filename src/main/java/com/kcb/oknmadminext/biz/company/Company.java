package com.kcb.oknmadminext.biz.company;

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
public class Company {
	@GraphQLQuery(name = "cpcd", description = "A company's cpcd")
	private String cpcd;
	@GraphQLQuery(name = "name", description = "A company's name")
	private String name;
}
