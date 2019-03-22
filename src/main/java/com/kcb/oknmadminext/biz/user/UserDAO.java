package com.kcb.oknmadminext.biz.user;

import java.util.List;

public interface UserDAO {
	User selectUserById(String id);
	List<User> selectUserAll();
}
