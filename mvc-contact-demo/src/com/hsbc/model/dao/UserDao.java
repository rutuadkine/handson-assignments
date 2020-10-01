package com.hsbc.model.dao;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.ContactNotPresentException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.Profile;
import com.hsbc.exception.UserNotFoundException;

public interface UserDao {
	public Profile authenticate(int userId, String password) throws AuthenticationException;
	
	public Profile store(Profile user);
	public Contacts add(Profile user, String name, long phone);
	public List<Profile> fetchAllProfiles();
	public Profile updatePhone(int userId, long phone)throws UserNotFoundException;
	public Profile updatePassword(int userId, String password)throws UserNotFoundException;
	public Profile fetchById(int userId)throws UserNotFoundException;
	public Contacts updateContactName(int contact_id, String name)throws ContactNotPresentException;
	public Contacts updateContactNum(int contact_id, long number)throws ContactNotPresentException;
	public void deleteProfile(int profile_id);
	public void deleteContact(int contact_id);
	public List<Contacts> fetchAllContacts();

	public Contacts fetchByContactId(int contact_id)throws ContactNotPresentException;
	
	
}
