package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.log("start method doGet()");
		this.execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.log("start method doPost()");
		this.execute(req, resp);
	}

	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.log("start method getLastModified()");
		return -1;
	}

	void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String requestURI = req.getRequestURI();
		String method = req.getMethod();
		String param = req.getParameter("param");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println(" use method:" + method
				+ "to visit the page ,and the params are " + param + "<br/>");

		out.println("<form action='"
				+ requestURI
				+ "' method='get'><input type='text' name='param' value='param string'><input type='submit' value=' using method get to visit pages "
				+ requestURI + "'></form>");

		out.println("<form action='"
				+ requestURI
				+ "' method='post'><input type='text' name='param' value='param string'><input type='submit' value=' using method post to visit pages "
				+ requestURI + "'></form>");
		
		out.println("<script> document.write('last modified time this page:' + document.lastModified);</script>");
		out.println("</BODY>");
		out.println("</HTML");
		out.flush();
		out.close();
	}
}
