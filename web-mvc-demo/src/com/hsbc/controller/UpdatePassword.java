package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.model.beans.User;
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
		User user =  (User) session.getAttribute("userKey");
		String password = request.getParameter("updatepwd");
		user.setPassword(password);
		
		UserService service = (UserService)UserFactory.getInstance("service");
		service.updatePassword(user.getUserId(),password);
		session.setAttribute("updatedpwdUser", user);
		RequestDispatcher rd = request.getRequestDispatcher("pwdupdated.jsp");
		rd.forward(request, response);
	}

}
