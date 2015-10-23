<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" import="forum.admin.domain.Invitation" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>《软件工程》教学论坛</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link href="css/bootstrap.css" rel="stylesheet">

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
          <li class="active"><a href="postServlet?mid=0">论坛</a></li>
            <li ><a href="<%=basePath %>/view.student/studentDownload.jsp">&nbsp;下&nbsp;&nbsp;载&nbsp;&nbsp;资&nbsp;&nbsp;料&nbsp;</a></li>
            <li><a href="<%=basePath %>/view.student/lookHomeworkDir.jsp">&nbsp;上&nbsp;&nbsp;传&nbsp;&nbsp;作&nbsp;&nbsp;业&nbsp;</a></li>
            
            
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
        <h4 class="modal-title" id="myModalLabel">发表帖子</h4>
      </div>
      <div class="modal-body">
        <form action="postServlet?mid=2" method="post">
                              
          <input type="text" name="title" required="required" class="form-control" placeholder="请输入帖子名称"/><br/>
          <textarea rows="7" name="content" id = "description" class="form-control" placeholder="请输入帖子内容" required="required"></textarea>
          <br/>
          <input type="submit" type="button" class="btn btn-primary" value="确认发帖"/>
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
        <h3  style="display:inline ">帖子列表</h3>
        <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">
                          发表帖子
      </button>
      </div>
      </div>
      <!-- list -->
   
      <div >
      <%
                ArrayList<Invitation> list = (ArrayList<Invitation>)request.getAttribute("postlist");
              
    %>
        <table class="table table-striped">
               
                 <tr><td Style="width:500px;">标题</td><td>发帖人</td><td>时间</td></tr>
                 <%for(int i=0;i<list.size();i++) {%>
                 <tr>
                 <td><a href="postServlet?mid=1&id=<%=list.get(i).getId()%>"><%=list.get(i).getTitle()%></a></td>
                 <td><%=list.get(i).getAuthorId()%></td>
                 <td><%=list.get(i).getDate()%></td>
                 </tr>
                  <%} %>
                </table>
                
                 
         <nav>
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
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
