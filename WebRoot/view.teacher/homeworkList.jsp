<!-- 
詹宝煌15-4-28 创建
 -->
<%@ page language="java" import="java.util.*" import="java.util.ArrayList" import="forum.global.domain.Releasehomework" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>《软件工程》教学论坛</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="../css/studentIndex.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
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
              String name = (String)session.getAttribute("name");
              out.println(name);
           %></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li ><a href="postServlet?mid=0">论坛</a></li>
            <li ><a href="TeacherServlet?mid=1">上传空间</a></li>
            <li class="active"><a href="TeacherServlet?mid=4">作业情况</a></li>
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <!-- 模态开始 
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">发布作业</h4>
      </div>
      <div class="modal-body">
        <form action="teacher/releasehomework" method="post"enctype="multipart/form-data">
                               
          作业文件：<br/>
          <input type="file" name="material" required="required"/><br/>
       
          截止时间：
          <input type="date" name="deadline" class="form-control"  required="required"/><br/>
          <input type="submit" type="button" class="btn btn-primary" value="确认上传"/>
         </form>
      </div>
    
    </div>
  </div>
</div>
<!-- 模态结束 -->
    <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
       <div style="margin-top: 9px; height: 10px;">
        <h3  style="display:inline "><%=request.getAttribute("url") %>作业的上交列表</h3>
        
      </div>
      </div>
      <!-- list -->
   
         <script type="text/javascript"> 
         window.onload=function()
{
  var olink=document.getElementById("del");
  olink.onclick=function()
  {
    if(confirm("是否删除?")){return true;}
    return false;
  }
} 
   </script>
      <div >
      <%
                    String[] list = (String[])request.getAttribute("result");
                    int size = list.length;
                    
                    %>
      <p>共上交<%=size %>份：</p>
          <table class="table table-striped">
                
                 <tr><td >标题</td><td>操作</td></tr>
                  <%
                  for(String hw : list){
                  
                  %>
                  <tr>
                      <td ><a href="homework/<%=request.getAttribute("url") %>/<%=hw %>"> <%=hw %></a></td>
                      
                  
                      <td>
                          <a  href="homework/<%=request.getAttribute("url") %>/<%=hw %>" class="btn btn-success">下载 </a>
                         
                      </td>
                  </tr>
                  
                  <%
                  }
                 %>
          </table>
      </div>
      
      



      <!-- FOOTER -->
      <footer>
        <!-- <p class="pull-right"><a href="#">Back to top</a></p> -->
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../assets/js/ie10-viewport-bug-workaround.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.2.js"></script>
    <script src="js/bootstrap.js"></script> 
  </body>
</html>
