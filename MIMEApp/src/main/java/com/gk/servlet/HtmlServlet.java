package com.gk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res )throws ServletException,IOException{
		// set response content type
		res.setContentType("text/html");
		//get PrintWriter
			
			PrintWriter pw = res.getWriter();
			// write content response obj using PrintWriter
			pw.println("<table border ='1' bgcolor='cyan' align='center'>");
			pw.println("<tr><th> IPL Team </th><th>Captain</th><th>Management</th><tr>");
			pw.println("<tr><td>MI</td><td>Rohit Sharma</td><td>Reliance</td></tr>");
			pw.println("<tr><td>CSK</td><td>Dhoni</td><td>Indian Cement</td></tr>");
			pw.println("<tr><td>RCB</td><td>Duplissis</td><td>UBL</td></tr>");
			pw.println("<tr><td>GT</td><td>Hardik Pandya</td><td>CVC Capitals</td></tr>");
			pw.println("<tr><td>SRH</td><td>Williamson</td><td>Sun Network</td></tr>");
			pw.println("</table>");
			// close stream 
			pw.close();
			
	}// service 

}
