package com.kcb.oknmadminext.biz.company;

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
public class Company {
	public Company(String cpcd, String name) {
		super();
		this.cpcd = cpcd;
		this.name = name;
	}
	@Id
	@GraphQLQuery(name = "cpcd", description = "A company's cpcd")
	private String cpcd;
	@GraphQLQuery(name = "name", description = "A company's name")
	private String name;
}
