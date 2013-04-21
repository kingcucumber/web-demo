<%@ page import="java.util.HashMap" %>
<%@ page import="java.net.HttpCookie" %>
<%--
  Created by IntelliJ IDEA.
  User: jinhuawa
  Date: 4/21/13
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String,String> cookieMap = new HashMap<String, String>();
    HttpCookie[] cookies = HttpServletRequest.getCookies();
    if(cookies != null)
    {
        for(int i=0;i<cookies.length;i++)
        {
            Cookie cookie = cookies[i];
            cookieName = cookie.getName();
            cookieValue = cookie.getValue();
            cookieMap.put(cookieName,cookieValue);
        }
    } else{
        cookieMap == null;
    }
    HttpCookie
    response.
%>
<html>
<head>
    <title>All cookies</title>
</head>
<body>
    <div align="center">
        <fieldset>
            <legend>cookies:</legend>

        </fieldset>
    </div>
</body>
</html>