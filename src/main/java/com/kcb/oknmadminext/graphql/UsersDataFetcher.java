package com.kcb.oknmadminext.graphql;

import org.springframework.stereotype.Component;

import com.kcb.oknmadminext.dao.UserDAO;
import com.kcb.oknmadminext.model.UserVO;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UsersDataFetcher implements DataFetcher<UserVO>{

	private UserDAO userDAO;
	
	
	@Override
	public UserVO get(DataFetchingEnvironment environment) {
		String id = environment.getArgument("id");
		System.out.println(id);
		return userDAO.selectUserByUserId(id);
	}	
}