package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.ContactNotPresentException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.Profile;

public interface UserService {
	
	public Profile login(int userId, String password) throws AuthenticationException;
	public Profile createProfile(Profile user);
	public List<Profile> fetchAllProfiles();
	public Profile updatePhone(int userId, long phone);
	public Profile updatePassword(int userId, String password);
	public Profile getProfile(int userId);
	public void deleteProfile(int profile_id);

	public Contacts addContacts(Profile user, String name, long phone);
	public Contacts updateContactName(int contact_id, String name);
	public Contacts updateContactNum(int contact_id, long number);
	public void deleteContact(int contact_id);
	public List<Contacts> fetchAllContacts();
	public Contacts getContact(int contact_id);

}
