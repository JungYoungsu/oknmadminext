package com.kcb.oknmadminext.biz.company;

import java.util.List;

public interface CompanyDAO {
	Company selectCompanyByCpcd(String cpcd);
	Company selectCompanyByName(String name);
	List<Company> selectCompanyAll();
}
