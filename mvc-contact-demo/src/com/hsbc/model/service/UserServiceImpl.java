package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.ContactNotPresentException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.Profile;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.util.UserFactory;

public class UserServiceImpl implements UserService{

	private UserDao dao = null;
	public UserServiceImpl()
	{
		dao = (UserDao)UserFactory.getInstance("dao");
	}

	@Override
	public Profile login(int userId, String password) throws AuthenticationException {
		Profile user = dao.authenticate(userId, password);
		if(user==null)
		{
			throw new AuthenticationException("Sorry! User not found");
		}
		return user;
	}

	@Override
	public Profile createProfile(Profile user) {
		Profile user1 = dao.store(user);
		return user1;
	}

	@Override
	public List<Profile> fetchAllProfiles() {
		return dao.fetchAllProfiles();
	}

	@Override
	public Profile updatePhone(int userId, long phone) {
		try {
			return dao.updatePhone(userId, phone);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Profile updatePassword(int userId, String password) {
		try {
			return dao.updatePassword(userId, password);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Profile getProfile(int userId) {
		try {
			return dao.fetchById(userId);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteProfile(int profile_id) {
		dao.deleteProfile(profile_id);
		
	}

	@Override
	public Contacts addContacts(Profile user,String name,long phone) {
		Contacts contact1 = dao.add(user,name,phone);
		return contact1;
	}

	@Override
	public Contacts updateContactName(int contact_id, String name) {
		try {
			return dao.updateContactName(contact_id, name);
		} catch (ContactNotPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Contacts updateContactNum(int contact_id, long number) {
		try {
			return dao.updateContactNum(contact_id, number);
		} catch (ContactNotPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteContact(int contact_id) {
		dao.deleteContact(contact_id);
		
	}

	@Override
	public List<Contacts> fetchAllContacts() {
		return dao.fetchAllContacts();
	}

	@Override
	public Contacts getContact(int contact_id) {
		try {
			return dao.fetchByContactId(contact_id);
		} catch (ContactNotPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
}
