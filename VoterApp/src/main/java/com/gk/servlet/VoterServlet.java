package com.gk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		// get PrintWriter obj
		PrintWriter pw = res.getWriter();
		// set response content type 
		res.setContentType("text/html");
		// read form data (req param values from request obj)
		String name = req.getParameter("pname");
		String tage = req.getParameter("page");
		int age = Integer.parseInt(tage);
		// write b.logic
		if(age>=18) {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" u r elgible for voting</h1>");
		}
		else {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" u r not elgible for voting</h1>");
		}
		// graphical hyperlink (image as the hyperlink)
		pw.println("<a href='http://localhost:3030/VoterApp/details_form.html'><img src='images/home.png' width='100' height='200'></a>");

		// close the stream
		pw.close();
	}

}
