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
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Profile user =  (Profile) session.getAttribute("newProfile");
		String pwd = request.getParameter("updatepwd1");
		user.setPassword(pwd);
		UserService service = (UserService)UserFactory.getInstance("service");
		service.updatePassword(user.getProfile_id(), pwd);
		//session.setAttribute("updatedphoneUser", user);
	
		RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
		//request.setAttribute("err", e.getMessage());
		rd.include(request, response);
	}

}
