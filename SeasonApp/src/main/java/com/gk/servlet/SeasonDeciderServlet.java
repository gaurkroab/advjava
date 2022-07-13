package com.gk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.sql.rowset.serial.SerialException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SeasonDeciderServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		// set response content type
		res.setContentType("text/html");
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// Get System Date and time
		LocalDate ldt = LocalDate.now();  // static factory method
		// get current month
		int month = ldt.getMonthValue();  // gives between 1-12
		// decide the season name
		if(month>=3 && month<=6) {
			pw.println("<h1 style='color:green;text-align:center'> Season name :: Summer Season</h>");
		}
		else if(month>=7 && month<=10) {
			pw.println("<h1 style='color:green;text-align:center'> Season name :: Rainy Season</h>");
		}
		else {
			pw.println("<h1 style='color:green;text-align:center'> Season name :: Winter Season</h>");
		}
		
		// add home hyperlink
		pw.println("<br><br><a href='http://localhost:3030/SeasonApp/page.html'> Home </a>");
		// close the stream to commit the response
		pw.close();
	}// service(-,-)
}// class
