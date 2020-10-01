package com.hsbc.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.model.beans.Profile;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterProfile")
public class RegisterProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		int id = Integer.parseInt(userId);
		
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		
		String phoneS = request.getParameter("phone");
		String dob = request.getParameter("dob");
		long phone = Long.parseLong(phoneS);
		Profile user=new Profile();
		//user.setProfile_id(id);
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		user.setDob(dob);
		UserService service = (UserService)UserFactory.getInstance("service");
		Profile user1 = service.createProfile(user);
		HttpSession session = request.getSession();
		session.setAttribute("newProfile", user1);
		
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}

	
}
