<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'for.jsp' starting page</title>

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
		<%
			Object[][] letters = {
					{ true, "恭喜您注册的信息已经生效", "e_inn@163.com",
							"helleheaven@gmail.com", "2007-8-8" },
					{ false, "Java EE 5. release!!", "admin@sun.com",
							"helleheaven@gmail.com", "2007-6-24" },
					{ true, "来信已经收到，下周末见面商谈", "foo@bar.com",
							"helleheaven@gmail.com", "2007-5-18" },
					{ true, "您的博客有新的留言", "blog@foo.bar.com",
							"helleheaven@gmail.com", "2007-3-1" } };
			String[] colors = { "#DDDDDD", "#AAAAAA" };
		%>

		<table border=0 cellspacing=1 cellpadding=2 width=700 align=center>
			<tr style="background: url(images/vertical_line.gif);">
				<td align="center" style="line-height: 22px;">
					&nbsp;
				</td>
				<td align="center" style="line-height: 22px;">
					标题&nbsp;
				</td>
				<td align="center" style="line-height: 22px;">
					发信人&nbsp;
				</td>
				<td align="center" style="line-height: 22px;">
					收信人&nbsp;
				</td>
				<td align="center" style="line-height: 22px;">
					时间&nbsp;
				</td>
			</tr>
			<%
				for (int i = 0; i < letters.length; i++) {
					Object[] letter = letters[i];
			%>
			<tr style='background:<%=colors[i % 2]%>'>
				<td align="center">
					<%
						if (letter[0] == Boolean.TRUE) {
					%>
					<img src="images/mail.gif" />
					<%
						} else {
								out.println("&nbsp;");
							}
					%>
				</td>
				<td>
					<a href="#"><%=letter[1]%></a>
				</td>
				<td><%=letter[2]%></td>
				<td><%=letter[3]%></td>
				<td align="center"><%=letter[4]%></td>
			</tr>
			<%
				}
			%>
		</table>
	</body>
</html>
