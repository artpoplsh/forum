<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>《软件工程》教学论坛</title>
    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.css" rel="stylesheet"> 
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <link href="./css/studentIndex.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body >
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">用户：<%
              String id = (String)session.getAttribute("name");
              out.println(id);
           %></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse"><div align="left"> 
          </div><ul class="nav navbar-nav">
          	<li ><a href="postServlet?mid=0">论坛</a></li>
            <li><a href="./view.student/studentDownload.jsp">&nbsp;下&nbsp;&nbsp;载&nbsp;&nbsp;资&nbsp;&nbsp;料&nbsp;</a></li>
            <li><a href="./view.student/lookHomeworkDir.jsp">&nbsp;上&nbsp;&nbsp;传&nbsp;&nbsp;作&nbsp;&nbsp;业&nbsp;</a></li>
           
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

  </body>
</html>
