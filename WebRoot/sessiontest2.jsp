<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sessiontest2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%request.setCharacterEncoding("UTF-8");%>
     <%	
     
     	String username = request.getParameter("username");
     	session.setAttribute("username",username);
      %>
      你好!<%=username %>，你最想去的地方是
      <p>
      <form method=post action=sessiontest3.jsp>
      	<input type=test name="place">
      	<p>
      	<input type=submit value="submit">
      </form>
  </body>
</html>
