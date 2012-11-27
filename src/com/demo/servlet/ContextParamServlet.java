package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextParamServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
/*		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>读�?�上下文�?�数</TITLE></HEAD>");
		out.println(" <link rel='stylesheet' type='text/css' href='../css/style.css'>");	
		out.println("  <BODY>");
		out.println("<div align=center><br/>");
		out.println("<fieldset style='width:90%'><legend>所有的上下文�?�数</legend><br/>");
		
		ServletContext servletContext = getServletConfig().getServletContext();
		String uploadFolder = servletContext.getInitParameter("upload folder");
		String allowedFileType = servletContext.getInitParameter("allowed file type");
		
		out.println("<div class='line'>");
		out.println(" <div align = 'left' class='leftDiv'>上传文件夹</div>");
		out.println(" <div align = 'left' class='rightDiv'>" + uploadFolder + "</div>");
		out.println("</div>");
		
		out.println("<div class = 'line'>");
		out.println("<div align = 'left' class='leftDiv'>实际�?盘路径</div>");
		out.println("<div align = 'left' class='rightDiv'>" + servletContext.getRealPath(uploadFolder) + "</div>");
		out.println("</div>");
		
		out.println("<div class = 'line'>");
		out.println("<div align = 'left' class='leftDiv'>�?许上传的类型</div>");
		out.println("<div align = 'left' class='rightDiv'>" + allowedFileType + "</div>");
		out.println("</div>");
		
		out.println("</fieldset></div>");
		out.println("  </BODY>");
		out.println("</HTML>");*/
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>读�?�上下文�?�数</TITLE></HEAD>");	
		out.println("  <BODY>");
		out.println("<fieldset style='width:90%'><legend>所有的上下文�?�数</legend><br/>");
		
		ServletContext servletContext = getServletConfig().getServletContext();
		String uploadFolder = servletContext.getInitParameter("upload folder");
		String allowedFileType = servletContext.getInitParameter("allowed file type");
		
		out.println("上传文件夹:" + uploadFolder + "<br/>");
		out.println("实际�?盘路径:" + servletContext.getRealPath(uploadFolder) + "<br/>");
		out.println("�?许上传的类型:" + allowedFileType + "<br/>");
	
		out.println("</fieldset>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
