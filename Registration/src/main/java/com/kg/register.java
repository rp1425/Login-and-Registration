package com.kg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

@WebServlet("/registerForm")
public class register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
		PrintWriter out = resp.getWriter();
		
		
	
		try {
			

			String myName = req.getParameter("name1");
			

			String myEmail = req.getParameter("email1");
			String myPass = req.getParameter("pass1");
			
			String myCity = req.getParameter("city1");
			String myGender = req.getParameter("gender1");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/katta_gang", "root", "root");
			PreparedStatement stm = conn.prepareStatement("insert into members values (?,?,?,?,?) ");

			stm.setString(1, myName);
			stm.setString(2, myEmail);
			stm.setString(3, myPass);
			stm.setString(4, myCity);
			stm.setString(5, myGender);

			int count = stm.executeUpdate();
			if (count > 0) {
				
				

				resp.setContentType("text/html");
				out.print("<h3 style='color:green'> User registered successfully </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/Welcome.jsp");
				rd.include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> User not registered  </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
				rd.include(req, resp);

			}
			
			System.out.println("Inserted successfully");

		} catch (Exception e) {
			e.printStackTrace();

			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>" + e.getMessage() + " </h3>");

			RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
			rd.include(req, resp);

		}
		
				
				
		

	}
	
	
	
}

