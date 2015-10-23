<%@ page import="java.io.File"%>
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
              String dirName = new String(request.getParameter("dirName").getBytes("iso8859-1"),"UTF-8");
              out.println(id);
           %></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse"><div align="left"> 
          </div><ul class="nav navbar-nav">
          	<li ><a href="postServlet?mid=0">论坛</a></li>
            <li><a href="./view.student/studentDownload.jsp">&nbsp;下&nbsp;&nbsp;载&nbsp;&nbsp;资&nbsp;&nbsp;料&nbsp;</a></li>
            <li class="active"><a href="./view.student/lookHomeworkDir.jsp">&nbsp;上&nbsp;&nbsp;传&nbsp;&nbsp;作&nbsp;&nbsp;业&nbsp;</a></li>

            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<!-- 模态开始 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">上传作业</h4>
      </div>
      <div class="modal-body">
        <form action="StudentUploadServlet?dirName=<%=dirName %>" method="post" enctype="multipart/form-data">
                               作业文件：<br/>
          <input type="file" name="material" required="required"/><br/>
          <input type="text" name="description" id = "description" class="form-control" placeholder="请输入文件描述" />
          <br/>
          <input type="submit" type="button" class="btn btn-primary" value="确认上传"/>
         </form>
      </div>
    
    </div>
  </div>
</div>
<!-- 模态结束 -->
    <div class="container theme-showcase" role="main">
    
    <div class="jumbotron">
       <div style="margin-top: 9px; height: 0px;">
        <h3 style="display:inline ">作业列表</h3>
        <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">上传作业</button>
      </div>
    </div>
    
	<div>
    <table class="table table-hover">
    	<tr><td Style="width:70%;">标题</td></tr>
	    	<%
				request.setCharacterEncoding("UTF-8");
		    	File file=new File(application.getRealPath("/homework/"+dirName));
				File[] files=file.listFiles();
				if (files != null)
				{
     				for (File f : files)
     				{
			%>
						<tr>
							<td><%=f.getName() %></td>
							
						</tr>
			<%		}
				}
			%>
	</table> 
	</div>
	</div>
	<script src="../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="js/jquery-1.11.2.js"></script>
    <script src="js/bootstrap.js"></script> 
  </body>
</html>
