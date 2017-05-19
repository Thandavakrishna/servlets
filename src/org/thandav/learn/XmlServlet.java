package org.thandav.learn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		System.out.println("Inside Get Method ! "+ userName);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		writer.print("Your name is " + userName + " full Name is " + fullName + " You are a " + prof);
		
		String[] location = request.getParameterValues("location");
		writer.println("You are at " + location.length + " places");
		for(int i=0; i<location.length; i++){
			writer.println(location[i]);
		}
	}


}
