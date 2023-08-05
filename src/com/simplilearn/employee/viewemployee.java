package com.simplilearn.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.model.Employee;

public class viewemployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		ServletContext ctx = getServletContext();
		
		
		Employee emp = (Employee) ctx.getAttribute("Employee");
		
		pw.print("<table border='1' width='100%'>");
		pw.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th></tr>");
		pw.print("<tr><td>" + emp.getId() + "</td><td>" + emp.getName() + "</td><td>" + emp.getPassword() + "</td><td>" + emp.getEmail()
		+ "</td><td>" + emp.getCountry() + "</td></tr>");
        pw.print("</table>");

	     pw.close();
	}

	
}
