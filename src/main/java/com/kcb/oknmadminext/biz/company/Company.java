package com.kcb.oknmadminext.biz.company;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Company {
	public Company(String cpcd, String name) {
		super();
		this.cpcd = cpcd;
		this.name = name;
	}
	@GraphQLQuery(name = "cpcd", description = "A company's cpcd")
	private String cpcd;
	@GraphQLQuery(name = "name", description = "A company's name")
	private String name;
}
