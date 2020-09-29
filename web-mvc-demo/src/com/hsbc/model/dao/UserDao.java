package com.hsbc.model.dao;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.exception.UserNotFoundException;

public interface UserDao {
	public User authenticate(int userId, String password) throws AuthenticationException;
	public User store(User user);
	public List<User> fetchAllUsers();
	public User updatePhone(int userId, long phone)throws UserNotFoundException;
	public User updatePassword(int userId, String password)throws UserNotFoundException;
	public User fetchById(int userId)throws UserNotFoundException;
	
}
