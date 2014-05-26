package com.example.tutorial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExample
 */
@WebServlet("/servletexample")
public class ServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("firstname").equals("") || request.getParameter("lastname").equals("")){
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		String firstName= request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);

		getServletContext().getRequestDispatcher("/output.jsp").forward(request,response);
	}

}
