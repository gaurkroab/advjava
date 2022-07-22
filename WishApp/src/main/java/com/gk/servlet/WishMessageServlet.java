package com.gk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {
	// 2nd service(-,-) method
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		// specify the response content type
		res.setContentType("text/html");
		// get PrintWriter from response obj
		PrintWriter pw = res.getWriter();
		// get System date and time
		LocalDateTime ldt = LocalDateTime.now(); // now() is static factory method of LocalDateTime
		// LocalDateTime.now() is give LocalDAteTime obj having system date and time
		// get current hour of the day
		int hour = ldt.getHour(); // gives in 24 hours format
		// Generate wish message
		if(hour<12) {
			pw.println("<h1 style='color:orange;text-align:center'> Good Morning </h1>");
		}
		else if(hour<16) {
			pw.println("<h1 style='color:orange;text-align:center'> Good Afternoon </h1>");
		}
		else if(hour<20) {
			pw.println("<h1 style='color:orange;text-align:center'> Good Evening </h1>");
		}
		else	{
			pw.println("<h1 style='color:orange;text-align:center'> Good Night </h1>");
		}
		
		// add home hyperlink 
		// pw.println("<br><br> <a href='http://localhost:3030/WishApp/page.html'>home</a>");
		pw.println("<br><br> <a href='page.html'>home</a>");
		
		// close Stream
		pw.close();
	}// service(-,-)

}// class
