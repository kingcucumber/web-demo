<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'if.jsp' starting page</title>
    
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
  		String param = request.getParameter("param");
  		if("1".equals(param)){
  	 %>
  	 关雎•周南•诗经 <br/>
  	 关关雎鸠，在河之洲。窈窕淑女，君子好逑。<br/>
  	 参差荇菜，左右流之。窈窕淑女，寤寐求之。<br/>
  	 求之不得，寤寐思服。悠哉悠哉，辗转反侧。<br/>
  	 参差荇菜，左右采之。窈窕淑女，琴瑟友之。<br/>
  	 参差荇菜，左右芼之。窈窕淑女，钟鼓乐之。<br/>
  	 <%
  	 }
  	 else if("2".equals(param)){
  	  %>
  	  蒹葭•秦风•诗经<br/>
  	  蒹葭苍苍，白露为霜。所谓伊人，在水一方。<br/>
  	  溯洄从之，道阻且长。溯游从之，宛在水中央。<br/>
  	  蒹葭萋萋，白露未晞。所谓伊人，在水之湄。<br/>
  	  溯洄从之，道阻且跻。溯游从之，宛在水中坻。<br/>
  	  蒹葭采采，白露未已。所谓伊人，在水之涘。<br/>
  	  溯洄从之，道阻且右。溯游从之，宛在水中沚。<br/>
  	  <%
  	  }
  	  else if("3".equals(param)){
  	   %>
  	   子衿•国风•郑风<br/>
  	   青青子衿，悠悠我心。<br/>
  	   纵我不往，子宁不嗣音？<br/>
  	   青青子佩，悠悠我思。<br/>
  	   纵我不往，子宁不来？<br/>
  	   挑兮达兮，在城阙兮。<br/>
  	   一日不见，如三月兮。<br/>
  	   <%
  	   }
  	   else{
  	    %>
  	    请使用参数param=1，2,3 选择要显示的诗歌
  	    <%
  	    }
  	     %>
  </body>
</html>
