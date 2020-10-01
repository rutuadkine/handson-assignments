package com.hsbc.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class DeleteProfile
 */
@WebServlet("/DeleteProfile")
public class DeleteProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter("idpdelete");
		int id = Integer.parseInt(idS);
		
		UserService service = (UserService)UserFactory.getInstance("service");
		service.deleteProfile(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
		rd.include(request, response);
	}

}
