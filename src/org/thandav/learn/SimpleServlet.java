package org.thandav.learn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "simple servlet jsp desc", urlPatterns = { "/SimpleServletPath" },
initParams={@WebInitParam(name="defaultUser", value="Thandav")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(userName != "" && userName != null) {
			session.setAttribute("savedUser", userName);
			context.setAttribute("savedUser", userName);
		}
		writer.append("User from request is ").append(userName);
		writer.println("User from Session object is " +(String) session.getAttribute("savedUser"));
		writer.println("User from Context object is " +(String) context.getAttribute("savedUser"));
		writer.println("Default User on Initialization " + getServletConfig().getInitParameter("defaultUser"));
	}

}
