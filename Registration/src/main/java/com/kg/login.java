package com.kg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class login extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myEmail = req.getParameter("email1");
		String myPass = req.getParameter("pass1");
		PrintWriter out = resp.getWriter();	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/katta_gang", "root", "root");
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM members where email=? and password=?");
			
			stm.setString(1, myEmail);
			stm.setString(2, myPass);
			
		ResultSet rs =	stm.executeQuery();
		if (rs.next()) {
			HttpSession session = req.getSession();
			session.setAttribute("sess_name", rs.getString("name"));
			
			RequestDispatcher rd = req.getRequestDispatcher("/Welcome.jsp");
			rd.forward(req, resp);
			
			
		} else {
				resp.setContentType("text/html");
				out.print("<h3> Email id and password not matched</h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
				
				
		}

			
		} catch (Exception e) {
			// TODO: handle exception
			resp.setContentType("text/html");
			out.print("<h3> "+e.getMessage()+"</h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
		}
	}

}
