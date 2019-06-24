package com.kcb.oknmadminext.biz.company;

import java.util.List;

import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class CompanyService {
	public CompanyService(CompanyRepository companyRepo) {
		this.companyRepo = companyRepo;
	}

	private final CompanyRepository companyRepo;
	
	@GraphQLQuery(name = "company")
	public Company getComapnyByCpcd(@GraphQLArgument(name = "cpcd") String cpcd) {
		return companyRepo.findOne(cpcd);
	}
	
	@GraphQLQuery(name = "companies")
	public List<Company> getComapaniesByName(@GraphQLArgument(name = "name") String name) {
		return companyRepo.findByNameContainingIgnoreCase(name);
	}
	
	@GraphQLQuery(name = "companies")
	public List<Company> getCompanies() {
		return companyRepo.findAll();
	}
}
