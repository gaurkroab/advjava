package com.gk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
               //get PrintWriter
		    PrintWriter pw=res.getWriter();
		    // set response content type
		     res.setContentType("text/html");
		     // write message 
		     pw.println("<h1 style='color:red;text-align:center'> Internal Problem -- Try again </h1>");
		     pw.println("<br><a href='form.html'> Home</a>");
		   
		     
		     //close stream
		     pw.close();
		     
	}//doGet(-,-)

}//class
