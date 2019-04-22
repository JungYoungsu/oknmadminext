package com.kcb.oknmadminext.biz.company;

import java.util.List;

import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class CompanyService {
	public CompanyService(CompanyDAO companyDAO) {
		super();
		this.companyDAO = companyDAO;
	}

	private final CompanyDAO companyDAO;
	
	@GraphQLQuery(name = "companies")
	public List<Company> getCompanies() {
		return companyDAO.selectCompanyAll();
	}
	
	@GraphQLQuery(name = "company")
	public Company getComapnyByCpcd(@GraphQLArgument(name = "cpcd") String cpcd) {
		return companyDAO.selectCompanyByCpcd(cpcd);
	}
	
	@GraphQLQuery(name = "company")
	public Company getComapnyByName(@GraphQLArgument(name = "name") String name) {
		return companyDAO.selectCompanyByName(name);
	}
}
