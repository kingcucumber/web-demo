package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	private String getAccept(String accept) {
		StringBuffer buffer = new StringBuffer();
		if (accept.contains("image/gif"))
			buffer.append("GIF file,");
		if (accept.contains("image/x-xbitmap"))
			buffer.append("BMP file,");
		if (accept.contains("image/jpeg"))
			buffer.append("JPEG file,");
		if (accept.contains("application/vnd.ms-excel"))
			buffer.append("Excel file,");
		if (accept.contains("application/vnd.ms-powerpoint"))
			buffer.append("PPT file,");
		if (accept.contains("application/msword"))
			buffer.append("Word file ,");

		return buffer.toString().replace(",$", "");
	}

	private String getLocale(Locale locale) {
		if (Locale.SIMPLIFIED_CHINESE.equals(locale))
			return "简体中文";
		if (Locale.TRADITIONAL_CHINESE.equals(locale))
			return "�?体中文";
		if (Locale.ENGLISH.equals(locale))
			return "英语";
		if (Locale.JAPANESE.equals(locale))
			return "日语";
		return "Unknown Language Environment";
	}

	/*
	 * private String getAddress(String ip){ return IPUtil.getIpAddress(ip); }
	 */

	private String getNavigator(String userAgent) {
		if (userAgent.indexOf("TencentTraveler") > 0)
			return "腾讯�?览器";
		if (userAgent.indexOf("Maxthon") > 0)
			return "�?�游�?览器";
		if (userAgent.indexOf("MyIE2") > 0)
			return "MyIE2 �?览器";
		if (userAgent.indexOf("Firefox") > 0)
			return "�?��?�?览器";
		if (userAgent.indexOf("MSIE") > 0)
			return "IE�?览器";
		return "Unknown browser";
	}

	private String getOS(String userAgent) {
		if (userAgent.indexOf("Windows NT 5.1") > 0)
			return "Windows XP";
		if (userAgent.indexOf("Windows 98") > 0)
			return "Windows 98";
		if (userAgent.indexOf("Windows NT 5.0") > 0)
			return "Windows 2000";
		if (userAgent.indexOf("Unix") > 0)
			return "Unix";
		return "Unknown Operation System";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Enumeration e = this.getServletContext().getAttributeNames();
		while(e.hasMoreElements()){
			String con = (String) e.nextElement();
			System.out.println(con);
			
		}

		String servletName = this.getServletConfig().getServletName();
		System.out.println(servletName);
		
		
		
		response.setContentType("text/html");
		String authType = request.getAuthType();
		String localAddr = request.getLocalAddr();
		String localName = request.getLocalName();
		int localPort = request.getLocalPort();

		Locale locale = request.getLocale();
		String contextPath = request.getContextPath();
		String method = request.getMethod();
		String pathInfo = request.getPathInfo();
		String pathTranslated = request.getPathTranslated();
		String protocol = request.getProtocol();
		String queryString = request.getQueryString();

		String remoteAddr = request.getRemoteAddr();

		int port = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		String requestSessionId = request.getRequestedSessionId();
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();

		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String servletPath = request.getServletPath();
		Principal userPrincipal = request.getUserPrincipal();

		String accept = request.getHeader("accept");
		String referer = request.getHeader("referer");
		String userAgent = request.getHeader("user-Agent");
		String serverInfo = this.getServletContext().getServerInfo();

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Request Servlet</TITLE></HEAD>");
		out.println("<Style>body,font,td,div {font-size:12px;linx-height:18px;}</style>");
		out.println("<BODY>");
		out.println("<b> 您的ip为:</b>" + remoteAddr + "<b>;�?于:</b>"
				+ /* getAddress(remoteAddr) */"<b>;您使用</b>" + getOS(userAgent)
				+ "<b>�?作系统</b>," + getNavigator(userAgent) + "<b>。您使用</b>"
				+ getLocale(locale) + "。<br/>");
		out.println("<b>�?务器IP为</b>" + localAddr + "<b>,�?于</b>"
				+ /* getAddress(localAddr) */"<b>;�?务器使用</b>" + serverPort
				+ "<b>端�?�，您的�?览器使用了</b>" + port + "<b>端�?�访问本网页。</b><br/>");
		out.println("<b>�?务器软件为</b>:" + serverInfo + ".<b>�?务器�??称为</b>"
				+ localName + "。<br/>");
		out.println("<b>您的�?览器接�?�</b>" + getAccept(accept) + "。<br/>");
		out.println("<b>您从</b>" + referer + "<b>访问到该页�?�.</b><br/>");
		out.println("<b>使用的�??议为" + protocol + ".<b>URL�??议头</b>" + scheme
				+ ",<b>�?务器�??称</b>" + serverName + ".<b>您访问的URI为</b>"
				+ requestURI + ".<br/>");
		out.println("<b>该Servlet路径为</b>" + servletPath + ",<b>该Servlet类�??为</b>"
				+ this.getClass().getName() + ".<br/>");
		out.println("<b>本应用程�?在硬盘的根目录为</b>"
				+ this.getServletContext().getRealPath("") + ",<b>网络相对路径为</b>"
				+ contextPath + ".<br/>");
		out.println("<br/>");
		out.println("<br/><br/><a href=" + requestURI + ">打击刷新该页�?�!</a>");
		out.println("<BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();

	}
}
