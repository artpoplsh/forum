<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" import="forum.admin.domain.Invitation" import="forum.student.domain.Invitationcomment" pageEncoding="utf8"%>
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

  
    <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron" style="height: 0px; margin-top: 12px;">
       <ol class="breadcrumb">
  <li><a href="postServlet?mid=0">论坛</a></li>
  <li class="active">帖子详情</li>
</ol>
      </div>
      </div>
      <!-- list -->
   
      <div class="content container" >
      <div class="row">
      <div class="col-md-8" style="background-color:rgb(242,242,245);padding:17;left: 18px; margin-bottom:26px;">
        <%=request.getAttribute("postContent") %>
       </div>
      </div>
      
     
<div class="row">
    <div class="col-md-8">
        <form>
            <textarea  class="form-control" rows="3" id="comment" name="comment" required="required"  placeholder="文明评论"></textarea>
            <br/><input id="commentButton" onclick="getComment()" type="button"  class="btn btn-success" value="提交评论" style="margin-left: 671px;"/>
        </form>
<hr/>
    </div>
    <hr/>
</div>  

 <div class="commentDiv row">
 <script type="text/javascript">
 
 function getComment(){//评论
	 var content=$("#comment").val();
     if(content==""){
         $("#comment").focus();
     }else{
     var url="postServlet?mid=3";
     //alert(window.name);
     var data="comment="+content;
     var xhr=new XMLHttpRequest();
     xhr.open("post",url,true);
     xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
     xhr.onreadystatechange=function(){
         if(xhr.readyState==4){
             if(xhr.status==200){
                 var msg=xhr.responseText;
                 var res = eval('(' + msg + ')');
                 console.log(res.comment);
                 alert(res.comment);
                 $("textarea").val("");
                 if((length=res.length)!=0){

                     for(var i=0;i<length;i++){
                         alert("hah");
                         //$("textarea").val($("textarea").val() + "\r\n" +res[i].sender+": "+res[i].content+" "+res[i].time);
                     }
                     //$("textarea").append("<span>以上为历史消息</span>");
                     $("textarea").val($("textarea").val()+ "\r\n" + "*******以上为历史消息*******");
                 }
             }else{

             }
         }
     }
     }
     xhr.send(data);
 }
 </script>
    <div class="col-md-8">
        <button class="btn btn-primary" type="button">
            评论数  <span class="badge">2</span>
        </button>
         </div>
    <% 
    ArrayList<Invitationcomment> invitationcomment=(ArrayList<Invitationcomment>)request.getAttribute("invitationcomment");
    //invitationcomment.get(1).getComment();
    %>
    <%for(int i=0;i<invitationcomment.size();i++){ %>
       <div class="col-md-8" style="margin:15;padding:15;background-color:rgb(242,242,245);">
       <%=invitationcomment.get(i).getCommentPerson()+"回复："+invitationcomment.get(i).getComment() %>
       <a href="">回复</a>
       </div>
    <%} %>
   

</div>
      </div>
      
      



      <!-- FOOTER -->
    <!--   <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer> -->

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
