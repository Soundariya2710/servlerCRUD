package com.simplilearn.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.model.Employee;


public class saveemployee extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String country = req.getParameter("Country");
		
		Employee emp = null;
		
		if(name!= null && password != null && !name.equals("")&&!password.equals("")) {
		
		emp = new Employee();
		
		emp.setName(name);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setCountry(country);
		
		}
		
		if(emp!=null) {
			
			ServletContext ctx = getServletContext();
			ctx.setAttribute("Employee", emp);
			pw.println("<br><br> "+emp+"Data Saved successfully");
			req.getRequestDispatcher("index.html").include(req, res);
		}
		else {
			
			pw.println("<br><br> Sorry.. Unable to save record");
			
		}
		pw.close();
	}

}
