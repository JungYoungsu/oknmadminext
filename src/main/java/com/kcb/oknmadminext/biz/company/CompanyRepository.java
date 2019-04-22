package com.kcb.oknmadminext.biz.company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String>{
	List<Company> findByNameContainingIgnoreCase(String name);
}
