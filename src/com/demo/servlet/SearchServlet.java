package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yahoo.search.ImageSearchRequest;
import com.yahoo.search.ImageSearchResult;
import com.yahoo.search.ImageSearchResults;
import com.yahoo.search.SearchClient;

public class SearchServlet extends HttpServlet {

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

		String word = request.getParameter("word");
		String type = request.getParameter("type");
		String allowedAdult = request.getParameter("allowedAdult");

		boolean adultOK = "true".equals(allowedAdult);

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE> " + word + "�?�索结果</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("<div style = 'float:left; height:40px;'><img src='http://us.il.yimg.com/us.yimg.com/i/ww/beta/y3.gif'></div>");
		out.println("<form action = '" + request.getRequestURI()
				+ "'method='get'>");
		out.println("<div style='height:40px;'>");
		out.println("<input type='radio' name='type' value='web'"
				+ (type.equals("web") ? "checked" : "") + ">网页");
		out.println("<input type='radio' name='type' value='news'"
				+ (type.equals("news") ? "checked" : "") + ">新闻");
		out.println("<input type='radio' name='type' value='image'"
				+ (type.equals("image") ? "checked" : "") + ">图�?");
		out.println("<input type='radio' name='type' value='video'"
				+ (type.equals("web") ? "checked" : "") + ">视频");

		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<input type='checkbox' name='allowedAdult' value='true'"
				+ (adultOK ? "checked" : "") + ">�?许�?人内容<br/>");
		out.println("<input type='text' name='word' value='"
				+ word
				+ "' style=' width:300px;'><input type='submit' value='用雅虎�?�索' style='width:100px;'>");

		out.println(" </div>");
		out.println("</form>");

		SearchClient client = new SearchClient("javasdktest");

		try {
			if ("image".equals(type)) {
				ImageSearchRequest searchRequest = new ImageSearchRequest(
						URLEncoder.encode(word, "UTF-8"));

				searchRequest.setAdultOk(adultOK);
				searchRequest.setResults(20);
				searchRequest.setStart(BigInteger.valueOf(0));

				double startTime = System.currentTimeMillis();
				ImageSearchResults results = client.imageSearch(searchRequest);

				double endTime = System.currentTimeMillis();
				out.println("<div align=right style='widht:100%; background:#FFDDDD;height:25px;padding:2px;border-top:1px solid #FF9999;margin-bottom:5px;'>");
				out.println("总共 " + results.getTotalResultsAvailable()
						+ "�?�数�?�，总用时" + (endTime - startTime) / 1000 + "秒.");
				out.println("</div");

				for (ImageSearchResult result : results.listResults()) {
					out.println("<div class='imgDiv'>");
					out.println("<div align='center'><a href = '"
							+ result.getClickUrl()
							+ "'target=_blank><img width=160 height=120 src=\""
							+ result.getThumbnail().getUrl()
							+ "\"border='0'></a></div>");
					out.println("<div align='center'><a href=\""
							+ result.getRefererUrl() + "\" target=_blank>"
							+ result.getTitle() + "</a></div>");
					out.println("<div align='center'>" + result.getWidth()
							+ "x" + result.getHeight() + ""
							+ result.getFileFormat() + "</div>");
					out.println("<div>"
							+ (result.getSummary() == null ? "" : result
									.getSummary()) + "</div>");
					out.println("</div>");
				}
			} else if ("web".equals(type)) {
				// to do.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
