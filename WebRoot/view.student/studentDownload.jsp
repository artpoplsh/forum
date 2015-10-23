<%@page import="java.io.File"%>
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
            <li class="active"><a href="./view.student/studentDownload.jsp">&nbsp;下&nbsp;&nbsp;载&nbsp;&nbsp;资&nbsp;&nbsp;料&nbsp;</a></li>
            <li><a href="./view.student/lookHomeworkDir.jsp">&nbsp;上&nbsp;&nbsp;传&nbsp;&nbsp;作&nbsp;&nbsp;业&nbsp;</a></li>
            
          </ul>
        </div><!--/.nav-collapse -->
         
      </div>
    </nav>
    
    <div class="container theme-showcase" role="main">
    
    <div class="jumbotron">
       <div style="margin-top: 9px; height: 0px;">
        <h3 style="display:inline ">资料列表</h3>
      </div>
    </div>
    
	<div>
    <table class="table table-hover">
    	<tr><td Style="width:70%;">标题</td><td>信息描述</td><td>操作</td></tr>
	    	<%
				request.setCharacterEncoding("UTF-8");
		    	File file=new File(application.getRealPath("/uploadMaterial"));
				File[] files=file.listFiles();
				if (files != null)
				{
     				for (File f : files)
     				{
			%>
						<tr>
							<td Style="width:300px;"><%=f.getName() %></td>
							<td />
							<td><a href="StudentDownloadServlet?fileName=<%=f.getName() %>">下载</a></td>
						</tr>
			<%		}
				}
			%>
	</table> 
	</div>
	</div>
  </body>
</html>
