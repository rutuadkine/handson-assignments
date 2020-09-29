package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
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
			User user =  (User) session.getAttribute("userKey");
			String phoneS = request.getParameter("updatephone");
			long phone = Long.parseLong(phoneS);
			user.setPhone(phone);
			UserService service = (UserService)UserFactory.getInstance("service");
			service.updatePhone(user.getUserId(), phone);
			session.setAttribute("updatedphoneUser", user);
		
			RequestDispatcher rd = request.getRequestDispatcher("phoneupdated.jsp");
			//request.setAttribute("err", e.getMessage());
			rd.forward(request, response);
		
	}

}
