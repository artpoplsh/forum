<%@ page language="java" import="java.util.*" import = "forum.global.domain.Material" pageEncoding="ISO-8859-1"%>
<%@ page import="forum.global.service.MaterialService" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
         Material m = new Material();
        
         MaterialService s = new MaterialService();
         ArrayList<Material> list = s.getAllMaterial();
         out.println(list.get(0).getId());
     %>
  </body>
</html>
