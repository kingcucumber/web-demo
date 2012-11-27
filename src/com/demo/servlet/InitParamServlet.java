package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>请登录查看notice文件</TITLE></HEAD>");
		out.println("  <style>body,td,div {font-size:12px;} </style>");
		out.println("  <BODY>");

		out.println("  <form action ='" + request.getRequestURI()
				+ "' method = 'post'>");
		out.println("账�?�：<input type ='text' name = 'username' style= 'width:200px;'>");
		out.println("密�?：<input type ='password' name = 'password' style= 'width:200px;'>");
		out.println("<input type ='submit' value='登陆'>");
		out.println("</form>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Enumeration params = this.getInitParameterNames();

		while (params.hasMoreElements()) {
			String usernameParam = (String) params.nextElement();

			String passwordParam = getInitParameter(usernameParam);

			if (usernameParam.equals(username)
					&& passwordParam.equals(password)) {
				request.getRequestDispatcher("/WEB-INF/notice.html").forward(
						request, response);
				return;
			}

		}
		this.doGet(request, response);
	}

}
