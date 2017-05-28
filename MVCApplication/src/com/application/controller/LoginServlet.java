package com.application.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.application.model.User;
import com.application.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService();
		
		boolean result = loginService.authenticateUser(userId,password);
		User user = loginService.getUserByUserId(userId);
		if(result == true)
		{
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/WEB-INF/view/home.jsp");
		}
		else
		{
			response.sendRedirect("/WEB-INF/view/error.jsp");
		}
	}

}
