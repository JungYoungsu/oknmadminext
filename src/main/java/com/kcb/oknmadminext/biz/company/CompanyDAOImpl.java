package com.kcb.oknmadminext.biz.company;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	@Override
	public Company selectCompanyByCpcd(String cpcd) {
		Company vo = new Company("V0000000", "cp_name");
		return vo;
	}

	@Override
	public Company selectCompanyByName(String name) {
		Company vo = new Company("V0000001", "cp_name2");
		return vo;
	}

	@Override
	public List<Company> selectCompanyAll() {
		Company vo = new Company("V0000000", "cp_name");
		Company vo2 = new Company("V0000001", "cp_name2");
		List<Company> list = new ArrayList<>();
		list.add(vo);
		list.add(vo2);
		return list;
	}
}
