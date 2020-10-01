package com.hsbc.model.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FetchAll
 */
@WebServlet("/FetchAll")
public class FetchAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = (UserService)UserFactory.getInstance("service");
		List<Profile>list = service.fetchAllProfiles();
		//User user = new User();
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("profileListKey", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("displayAll.jsp");
		rd.forward(request, response);
	}

}
