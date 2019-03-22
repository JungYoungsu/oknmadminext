package com.kcb.oknmadminext.biz.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public User selectUserById(String id) {
		User vo = new User("test", "test_name", "passwd");
		return vo;
	}

	@Override
	public List<User> selectUserAll() {
		User vo = new User("test", "test_name", "passwd");
		User vo2 = new User("test2", "test_name2", "passwd2");
		List<User> list = new ArrayList<>();
		list.add(vo);
		list.add(vo2);
		return list;
	}
}
