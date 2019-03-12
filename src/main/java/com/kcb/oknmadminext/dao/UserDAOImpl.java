package com.kcb.oknmadminext.dao;

import org.springframework.stereotype.Repository;
import com.kcb.oknmadminext.model.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public UserVO selectUserByUserId(String id) {
		UserVO vo = new UserVO("test", "test_name", "passwd");
		return vo;
	}
}
