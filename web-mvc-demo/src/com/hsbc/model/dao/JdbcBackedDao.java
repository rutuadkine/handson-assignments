package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.util.DBUtility;

public class JdbcBackedDao implements UserDao{

	private List<User> list=getList();
	
	public List<User> getList()
	{
		try
		{
			Connection connection = DBUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement("Select * from user_table");
			ResultSet rs = ps.executeQuery();
			
			list = new ArrayList<User>();
			while(rs.next())
			{
				User user = new User();
				user.setUsername(rs.getString("name"));
				user.setUserId(rs.getInt("user_id"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getInt("phone"));
				list.add(user);
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public User authenticate(int userId, String password) throws AuthenticationException {
		User user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from user_table where user_id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setUsername(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				return user;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			if(user == null) {
				throw new AuthenticationException("Sorry Username or Password is Incorrect");
			} 
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User store(User user) {
		list.add(user);
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for user_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			if(seq == 0) {
				// throw some exception to the client
			} 
			PreparedStatement insertStatement=connection.prepareStatement("insert into user_table values(next value for user_seq, ?, ?, ?)");
			//In first question mark insert userId
			insertStatement.setInt(1, seq);
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter name:");
			insertStatement.setString(1,sc.next());
			System.out.println("Enter password:");
			insertStatement.setString(2,sc.next());
			System.out.println("Enter phone:");
			insertStatement.setInt(3,(int) sc.nextLong());
			int resultSet=insertStatement.executeUpdate();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> fetchAllUsers() {
		list=getList();
		
		return list;
	}

	@Override
	public User updatePhone(int userId, long phone) throws UserNotFoundException{
		Iterator<User> it1=list.iterator();
		User user = fetchById(userId);
		if(user == null)
		{
			throw new UserNotFoundException("User not found!");
		}
		while(it1.hasNext()) {
			try {
				Connection connection=DBUtility.getConnection();
				PreparedStatement updateStatement=connection.prepareStatement("update user_table set phone=? where user_id=?");
				updateStatement.setInt(1,(int)phone);
				updateStatement.setInt(2,userId);
				user.setPhone(phone);
				int resultSet=updateStatement.executeUpdate();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		
		return user;
	}
	@Override
	public User updatePassword(int userId, String password) throws UserNotFoundException {
		Iterator<User> it1=list.iterator();
		User user = fetchById(userId);
		if(user == null)
		{
			throw new UserNotFoundException("User not found!");
		}
		while(it1.hasNext()) {
			try {
				Connection connection=DBUtility.getConnection();
				PreparedStatement updateStatement=connection.prepareStatement("update user_table set password=? where user_id=?");
				updateStatement.setString(1,password);
				updateStatement.setInt(2,userId);
				user.setPassword(password);
				int resultSet=updateStatement.executeUpdate();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		
		}
		return user;

	}
	
	public User fetchById(int userId) throws UserNotFoundException
	{
		User found=null;
		Iterator<User> it1=list.iterator();
		while(it1.hasNext()) {
		User u=it1.next();
		if(u.getUserId()==userId) {
			found=u;
			break;
		}
		}
		if(found == null)
		{
			throw new UserNotFoundException("User not found!");
		}
		return found;
	}
	

}
