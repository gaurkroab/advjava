package com.gk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StudentRegistrationServlet extends HttpServlet {
	private static final String STUDENT_INSERT_QUERY = "INSERT INTO STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?)";
			
		@Resource(name="DsJndi")   //  DataSource obj is injected to Servlet comp using Dependency Injection
		private DataSource ds;           //
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
			// Get PrintWriter 
			PrintWriter pw = res.getWriter();
			// set response content type 
			res.setContentType("text/html");
			// read form data
			String name = req.getParameter("sname");
			String addrs = req.getParameter("sadd");
			float avg = Float.parseFloat(req.getParameter("avg"));
			// write jdbc code to insert the record to db table
			
			try(Connection con = ds.getConnection(); PreparedStatement ps= con.prepareStatement(STUDENT_INSERT_QUERY);   ) {
				// set values to query params 
				ps.setString(1, name);
				ps.setString(2, addrs);
				ps.setFloat(3, avg);
				// execute the Query
				int result = ps.executeUpdate();
				if(result == 0) {
					pw.println("<h1 style='color:red;text-align:center'>Problem in Student registration</h1>");
					
				}
				else {
					pw.println("<h1 style='color:red;text-align:center'> Student register successfully</h1>");
				}
				
			}
			catch(SQLException se) {
				se.printStackTrace();
				pw.println("<h1 style='color:red;text-align:center'>DB Problem in Student registration</h1>");
			}
			catch(Exception e) {
				e.printStackTrace();
				pw.println("<h1 style='color:red;text-align:center'> Unkown Problem in Student registration</h1>");
			}
		}//doGet(-,-)
		
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doGet(req,res);
		}
		/*
		// helper method 
		private Connection getPooledjdbcConnection() throws Exception{
			// create InitialContext object
			InitialContext ic = new InitialContext();
			// get DataSource object through lookup opration
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/DsJndi");  // only in Tomcat server we need to add "java:/comp/env/prefix for jndi name
			//DataSource ds = (DataSource)ic.lookup("DsJndi"); // for GlassFish server
			// get pooled jdbc con
			Connection con = ds.getConnection();
			return con;
		}// end od getPoolecdjdbcConnection()
		*/
}// end of servelt class
