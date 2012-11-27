package com.demo.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiePage extends HttpServlet {

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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		Book book = (Book) Db.getAll().get(id);

		out.write(book.getId() + "<br/>");
		out.write(book.getName() + "<br/>");
		out.write(book.getAuthor() + "<br/>");
		out.write(book.getDescription() + "<br/>");

		String cookieValue = buildCookie(id, request);
		Cookie cookie = new Cookie("bookHistory", cookieValue);

		cookie.setMaxAge(1 * 30 * 24 * 3600);
		cookie.setPath("/JavaWeb");

		response.addCookie(cookie);

	}

	private String buildCookie(String id, HttpServletRequest request) {
		String bookHistory = null;
		Cookie cookies[] = request.getCookies();
		//先从cookie中去 bookHistory的cookie
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("bookHistory")) {
				bookHistory = cookies[i].getValue();
			}
		}
		if (bookHistory == null) {
			return id;
		}

		LinkedList<String> list = new LinkedList(Arrays.asList(bookHistory
				.split("\\,")));
		//如果已经访问过，有cookie，则先取出
		if (list.contains(id)) {
			list.remove(id);
			list.addFirst(id);
		} else {  //如果没有则先看cookie缓冲的大小是否已经满了
			if (list.size() >= 3) {
				list.removeLast();
				list.addFirst(id);
			} else {  //如果没有满，则添加cookie
				list.addFirst(id);
			}
		}
		StringBuffer sb = new StringBuffer();
		for (String bid : list) {
			sb.append(bid + ",");
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	
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

		doGet(request, response);
	}

}
