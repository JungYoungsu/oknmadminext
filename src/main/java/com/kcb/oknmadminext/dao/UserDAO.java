package com.kcb.oknmadminext.dao;

import com.kcb.oknmadminext.model.UserVO;

public interface UserDAO {
	UserVO selectUserByUserId(String id);
}
