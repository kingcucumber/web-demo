<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

if("POST".equals(request.getMethod())){
	Cookie usernameCookie = new Cookie("username",request.getParameter("username"));
	Cookie visitTimesCookie = new Cookie("visitTimes","0");
	
	response.addCookie(usernameCookie);
	response.addCookie(visitTimesCookie);
	
	response.sendRedirect(request.getContextPath() + "/cookie.jsp");
	return ;
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div align="center" style="margin:10px;" >
    	<fieldset>
    		<legend>Login</legend>
    		<form action="login.jsp" method="post" >
    			<table>
    				<tr>
    					<td></td>
    					<td>
    					<span><img src="images/errorstate.gif" ></span>
    					<span style="color:red;"><%=exception.getMessage() %></span>
    					</td>
    				</tr>
    				<tr>
    					<td>Account:</td>
    					<td>
    					<input type="text" name="username" style="width:200px;" >
    					</td>
    				</tr>
    				<tr>
    					<td>Password:</td>
    					<td>
    					<input type="password" name="password" style="width:200px;" >
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td>
    					<input type="submit" value="login" class="button">
    					</td>
    				</tr>
    			</table>
    		</form>
    	</fieldset>
    </div>
  </body>
</html>
