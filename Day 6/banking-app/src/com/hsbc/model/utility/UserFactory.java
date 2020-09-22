package com.hsbc.model.utility;

import com.hsbc.model.dao.AccountArrayDao;
import com.hsbc.model.service.AccountServiceImpl;

public class UserFactory {
	
	public static Object getInstance(Type type)
	{
		Object obj = null;
		
		switch(type)
		{
		case DAO:
			obj = new AccountArrayDao();
			break;
		case SERVICE:
			obj = new AccountServiceImpl();
			break;
		}
		
		return obj;
	}

}
