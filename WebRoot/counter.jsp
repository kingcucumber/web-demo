<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'counter.jsp' starting page</title>
    
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
    <jsp:useBean id="personCount" class="com.demo.jsp.Counter" scope="session" />
    <jsp:useBean id="totalCount" class="com.demo.jsp.Counter" scope="application" />
    
    <div align="center">
    	<form action="counter.jsp" method="get">
    		<fieldset style='width:300'>
    			<legend>计数器</legend>
    			<table align="center" width="400">
    				<tr>
    					<td width=150 align="right" style="font-weight:bold;" >
    					您的访问次数：</td>
    					<td>
    					<jsp:getProperty name="personCount" property="count" />次
    					</td>
    				</tr>
    				<tr>
    					<td width=150 align="right" style="font-weight:bold;" >
    					您的访问次数：</td>
    					<td>
    					<jsp:getProperty name="totalCount" property="count" />次
    					</td>
    				</tr>
    			</table>
    		</fieldset>
    	</form>
    </div>
  </body>
</html>
