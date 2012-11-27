<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	errorPage="login.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String username = "";
	int visitTimes = 0;

	Cookie[] cookies = request.getCookies();
	for (int i = 0; i < cookies.length; i++) {
		Cookie cookie = cookies[i];
		if ("username".equals(cookie.getName())) {
			username = cookie.getValue();
		} else if ("visitTimes".equals(cookie.getName())) {
			visitTimes = Integer.parseInt(cookie.getValue());
		}
	}
	if (username == null || username.trim().equals("")) {
		throw new Exception("You haven't login,please sign in!");
	}
	Cookie visitTimesCookie = new Cookie("visitTimes",
			Integer.toString(++visitTimes));
			response.addCookie(visitTimesCookie);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>cookie.jsp</title>

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
		<div align="center" style="margin: 10px;">
			<fieldset>
				<legend>
					login info
				</legend>
				<form action="login.jsp" method="post">
					<table>
						<tr>
							<td>
								Your Account:
							</td>
							<td><%=username%></td>
						</tr>
						<tr>
							<td>
								Times for Login:
							</td>
							<td><%=visitTimes%>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="button" value="reflesh"
									onclick="location='<%= request.getRequestURI() %>?ts=' + new Date().getTime();"
									class="button">
							</td>
						</tr>
					</table>
				</form>
			</fieldset>
		</div>
	</body>
</html>
