package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.model.beans.User;
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
		List<User>list = service.fetchAllUsers();
		
		PrintWriter pw = response.getWriter();
		pw.print("<html><body><p>");
		
		for(int i=0;i<list.size();i++)
		{
			pw.print(list.get(i));
			pw.print("<br/>");
		}
		pw.print("</p></body></html>");
	}

}
