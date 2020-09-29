package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.util.UserFactory;

public class UserServiceImpl implements UserService{

	private UserDao dao = null;
	public UserServiceImpl()
	{
		dao = (UserDao)UserFactory.getInstance("dao");
	}
	@Override
	public User login(int userId, String password) throws AuthenticationException {
		User user = dao.authenticate(userId, password);
		if(user==null)
		{
			throw new AuthenticationException("Sorry! User not found");
		}
		return user;
	}

	@Override
	public User createUser(User user) {
		User user1 = dao.store(user);
		return user1;
	}
	@Override
	public User updatePhone(int userId, long phone)  {
		
		try {
			return dao.updatePhone(userId, phone);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public User updatePassword(int userId, String password) {
		try {
			return dao.updatePassword(userId, password);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public User getUser(int userId) {
		try {
			return dao.fetchById(userId);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<User> fetchAllUsers() {
		return dao.fetchAllUsers();
	}

}
