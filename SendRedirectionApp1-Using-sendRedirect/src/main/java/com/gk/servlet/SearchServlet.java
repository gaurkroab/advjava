package com.gk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// read form data
		String ss = req.getParameter("ss");
		String engine = req.getParameter("engine");
		// decide the url for sendRedirection
		String url = null;
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+ss;
		else
			url="https://www.yahoo.com/search?q="+ss;
		
		// perform sendRedirection
		System.out.println("before sendRd(-) method");
		res.sendRedirect(url);
		System.out.println("after sendRd(-) method");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
