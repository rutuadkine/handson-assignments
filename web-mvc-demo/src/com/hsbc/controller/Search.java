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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("idsearch");
		int id = Integer.parseInt(userId);
		
		HttpSession session = request.getSession();
		
		UserService service = (UserService)UserFactory.getInstance("service");
		User user = service.getUser(id);
		
		session.setAttribute("searchUser", user);
		
		RequestDispatcher rd = request.getRequestDispatcher("fetchbyid.jsp");
		rd.forward(request, response);
	}

}
