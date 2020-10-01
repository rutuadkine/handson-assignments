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
 * Servlet implementation class UpdatePhone
 */
@WebServlet("/UpdatePhone")
public class UpdatePhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Profile user =  (Profile) session.getAttribute("newProfile");
		String phoneS = request.getParameter("updatephone1");
		long phone = Long.parseLong(phoneS);
		user.setPhone(phone);
		UserService service = (UserService)UserFactory.getInstance("service");
		service.updatePhone(user.getProfile_id(), phone);
		//session.setAttribute("updatedphoneUser", user);
	
		RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
		//request.setAttribute("err", e.getMessage());
		rd.include(request, response);
	}

}
