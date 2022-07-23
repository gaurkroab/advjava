package com.gk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/headerurl")
public class HeaderServlet extends HttpServlet {
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter 
		PrintWriter pw = res.getWriter();
		// set content type 
		res.setContentType("text/html");
		// write header logic
		pw.println("<br><br><h1 style='color:red'><marquee behaviour='slide' direction='left' hspace='10'> -- T H E  N E X T  S T E P -- </marquee></h1>");
		
		
		//pw.close();
		
		
	}// doGet(-,-)
	
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
