<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userBean.jsp' starting page</title>
    
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
   	<jsp:useBean id="person" class="com.demo.jsp.Person" scope="page" />
   	<jsp:setProperty name="person" property="*" />
   	<div align="center">
   		<form action="userBean.jsp" method="get" >
   			<fieldset style='width:300' >
   				<legend>请填写Person的信息</legend>
   				<table align="center" width="400" >
   					<tr>
   						<td align="right" style="font-weight:bold;"> 姓名：</td>
   						<td><jsp:getProperty property="name" name="person"/></td>
   					</tr>
   					<tr>
   						<td align="right" style="font-weight:bold;" >年龄：</td>
   						<td><jsp:getProperty name="person" property="age" /></td>
   					</tr>
   					<tr>
   						<td align="right" style="font-weight:bold;" >性别：</td>
   						<td><jsp:getProperty name="person" property="sex" /></td>
   					</tr>
   					<tr>
   						<td align="right" style="font-weight:bold;" ></td>
   						<td>
   						<input type="button" onclick="history.go(-1);" value="返回" class="button" >
   						</td>
   					</tr>
   				</table>
   			</fieldset>
   		</form>
   	</div>
  </body>
</html>
