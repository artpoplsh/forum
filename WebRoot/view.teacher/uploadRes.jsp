<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadRes.jsp' starting page</title>
    
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
			    request.setCharacterEncoding("UTF-8");
			    String rid = request.getParameter("rid");
			    if (rid.equals("1")){
			%>
		<script>
				alert("上传成功！");
				window.location.assign("TeacherServlet?mid=1");
			</script>
		<%}
			    else if (rid.equals("0"))
			    {
			    	%>
		<script>
						alert("更新失败！");
						history.go(-1);
					</script>
		<%
			    }%>
	</body>
  
  
</html>
