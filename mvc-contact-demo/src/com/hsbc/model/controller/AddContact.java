package com.hsbc.model.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.Profile;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class AddContact
 */
@WebServlet("/AddContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("contactname");
		String phoneS = request.getParameter("contactphone");
		Long phone = Long.parseLong(phoneS);
		
		String idS = request.getParameter("contactid");
		int id = Integer.parseInt(idS);
		
		HttpSession session = request.getSession();
		Profile user =  (Profile) session.getAttribute("newProfile");
		//String name1 = user.getName();
		
		
		Contacts contact = new Contacts();
		contact.setContact_id(id);
		contact.setName(name);
		contact.setContact_no(phone);
		//contact.setPid(pid);
		//int pid = ;
		//int pid=102;
		//HttpSession session = request.getSession();
		session.setAttribute("contact", contact);
		
		UserService service = (UserService)UserFactory.getInstance("service");
		Contacts c = service.addContacts(user,name,phone);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("addedContact.jsp");
		rd.forward(request, response);
		
	}

}
