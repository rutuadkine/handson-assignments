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
import com.hsbc.exception.ContactNotPresentException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.Profile;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.util.DBUtility;

public class JdbcBackedDao implements UserDao{
	
private List<Profile> list=getList();
private List<Contacts> list2=getListContacts();
	
	public List<Profile> getList()
	{
		try
		{
			Connection connection = DBUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from profile");
			ResultSet rs = ps.executeQuery();
			
			list = new ArrayList<Profile>();
			while(rs.next())
			{
				Profile user = new Profile();
				user.setName(rs.getString("name"));
				user.setProfile_id(rs.getInt("profile_id"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getLong("phone"));
				user.setDob(rs.getString("dob"));
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
	
	public List<Contacts> getListContacts()
	{
		try
		{
			Connection connection = DBUtility.getConnection();
			PreparedStatement ps = connection.prepareStatement("Select * from contacts");
			ResultSet rs = ps.executeQuery();
			
			list2 = new ArrayList<Contacts>();
			while(rs.next())
			{
				Contacts contact = new Contacts();
				contact.setName(rs.getString("name"));
				contact.setContact_id(rs.getInt("contact_id"));
				contact.setContact_no(rs.getLong("phone"));
				contact.setPid(rs.getInt("pid"));
				list2.add(contact);
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
		return list2;
	}

	@Override
	public Profile authenticate(int userId, String password) throws AuthenticationException {
		Profile user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from profile where profile_id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new Profile();
				user.setProfile_id(resultSet.getInt("profile_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				user.setDob(resultSet.getString("dob"));
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
	public Profile store(Profile user) {
		list.add(user);
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for profile_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			if(seq == 0) {
				
				return null;
			} 
			PreparedStatement insertStatement=connection.prepareStatement("insert into profile values(next value for profile_seq, ?, ?, ?, ?)");
			//In first question mark insert userId
			insertStatement.setInt(1, seq);
			//Scanner sc =new Scanner(System.in);
			//System.out.println("Enter name:");
			insertStatement.setString(1,user.getName());
			//System.out.println("Enter password:");
			insertStatement.setString(2,user.getPassword());
			//System.out.println("Enter phone:");
			insertStatement.setLong(3, user.getPhone());
			insertStatement.setString(4, user.getDob());
			int resultSet=insertStatement.executeUpdate();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Contacts add(Profile user, String name, long phone) {
		//list2.add(contact);
		Scanner sc = new Scanner(System.in);
		
		try {
			Connection connection=DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for contact_seq2)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			if(seq == 0) {
				System.out.println("Seq is 0");
				return null;
			} 
			PreparedStatement insertStatement=connection.prepareStatement("insert into contacts values(?, ?, ?, ?)");
			//In first question mark insert userId
			insertStatement.setInt(1, seq);
			//Scanner sc =new Scanner(System.in);
			//System.out.println("Enter name:");
			insertStatement.setString(2,name);
			//System.out.println("Enter password:");
			insertStatement.setLong(3,phone);
			System.out.println("Enter pid:");
			int pid = sc.nextInt();
			insertStatement.setInt(4, pid);
			Contacts contact = new Contacts();
			contact.setContact_id(seq);
			contact.setContact_no(phone);
			contact.setName(name);
			
			contact.setPid(pid);
			//System.out.println("Enter phone:");
			int resultSet=insertStatement.executeUpdate();
			return contact;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Profile> fetchAllProfiles() {
		list=getList();
		
		return list;
	}

	@Override
	public Profile updatePhone(int userId, long phone) throws UserNotFoundException {
		Iterator<Profile> it1=list.iterator();
		Profile user = fetchById(userId);
		if(user == null)
		{
			throw new UserNotFoundException("User not found!");
		}
		while(it1.hasNext()) {
			try {
				Connection connection=DBUtility.getConnection();
				PreparedStatement updateStatement=connection.prepareStatement("update profile set phone=? where profile_id=?");
				updateStatement.setLong(1,phone);
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
	public Profile updatePassword(int userId, String password) throws UserNotFoundException {
		Iterator<Profile> it1=list.iterator();
		Profile user = fetchById(userId);
		if(user == null)
		{
			throw new UserNotFoundException("User not found!");
		}
		while(it1.hasNext()) {
			try {
				Connection connection=DBUtility.getConnection();
				PreparedStatement updateStatement=connection.prepareStatement("update profile set password=? where profile_id=?");
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

	@Override
	public Profile fetchById(int userId) throws UserNotFoundException {
		Profile found=null;
		Iterator<Profile> it1=list.iterator();
		while(it1.hasNext()) {
		Profile u=it1.next();
		if(u.getProfile_id()==userId) {
			found=u;
			break;
		}
		}
		if(found == null)
		{
			throw new UserNotFoundException("Profile not found!");
		}
		return found;
	}
	
	public Contacts fetchByContactId(int userId) throws ContactNotPresentException {
		Contacts found=null;
		Iterator<Contacts> it1=list2.iterator();
		while(it1.hasNext()) {
		Contacts u=it1.next();
		if(u.getContact_id()==userId) {
			found=u;
			break;
		}
		}
		if(found == null)
		{
			throw new  ContactNotPresentException("Conatact not found!");
		}
		return found;
	}

	@Override
	public Contacts updateContactName(int contact_id, String name) throws ContactNotPresentException {
		Iterator<Contacts> it1=list2.iterator();
		Contacts contact = fetchByContactId(contact_id);
		if(contact == null)
		{
			throw new ContactNotPresentException("Contact not found!");
		}
		while(it1.hasNext()) {
			try {
				Connection connection=DBUtility.getConnection();
				PreparedStatement updateStatement=connection.prepareStatement("update contacts set name=? where contact_id=?");
				updateStatement.setString(1,name);
				updateStatement.setInt(2,contact_id);
				contact.setName(name);
				int resultSet=updateStatement.executeUpdate();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		
		}
		return contact;
	}

	@Override
	public Contacts updateContactNum(int contact_id, long number) throws ContactNotPresentException {
		Iterator<Contacts> it1=list2.iterator();
		Contacts contact = fetchByContactId(contact_id);
		if(contact == null)
		{
			throw new ContactNotPresentException("Contact not found!");
		}
		while(it1.hasNext()) {
			try {
				Connection connection=DBUtility.getConnection();
				PreparedStatement updateStatement=connection.prepareStatement("update contacts set phone=? where contact_id=?");
				updateStatement.setLong(1,number);
				updateStatement.setInt(2,contact_id);
				contact.setContact_no(number);
				int resultSet=updateStatement.executeUpdate();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		
		}
		return contact;
	}

	@Override
	public void deleteProfile(int profile_id) {
		try {
			Connection connection=DBUtility.getConnection();
			 
			PreparedStatement insertStatement=connection.prepareStatement("delete from profile where profile_id=?");
			//In first question mark insert userId
			insertStatement.setInt(1, profile_id);
			
			
			int resultSet=insertStatement.executeUpdate();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteContact(int contact_id) {
		try {
			Connection connection=DBUtility.getConnection();
			 
			PreparedStatement insertStatement=connection.prepareStatement("delete from contacts where contact_id=?");
			//In first question mark insert userId
			insertStatement.setInt(1, contact_id);
			
			
			int resultSet=insertStatement.executeUpdate();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Contacts> fetchAllContacts() {
		list2=getListContacts();
		
		return list2;
	}

	
}
