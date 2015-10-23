<% /*林圣煌
* 2015.4.8 创建  网站首页（未登录）
*/ %>
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
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>软件工程教学论坛</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <script src="js/index.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
   
  </head>
  <body>
  
<!-- 登陆窗口start -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">登陆</h4>
      </div>
      <div class="modal-body"><!-- 模态框窗口 -->
        <form action="globalServlet?mid=0" method="post">
        <input type="text" name="id" id="username" required="required" class="form-control" placeholder="请输入账号" value="fj"/><br/><br/><br/>
        <input type="password" name="password" id="password" required="required" class="form-control" placeholder="请输入密码"/><br/><br/><br/>
        <div class="rolediv">
		<input class="roleradio " type="radio" name="role" checked="checked" value="student">&nbsp;学生&nbsp;&nbsp;&nbsp;&nbsp;</input>
		<input class="roleradio " type="radio" name="role" value="teacher">&nbsp;教师&nbsp;&nbsp;&nbsp;&nbsp;</input>
		<input class="roleradio " type="radio" name="role" value="admin">&nbsp;管理员</input>
		</div>
        <button type="submit" class="btn btn-lg btn-primary btn-block login">登陆</button>
      </form>
      </div>
      <div class="modal-footer">
    </div>
  </div>
</div>
</div>
 <!-- 登陆窗口end--> 
 
<div class="container-fluid">
 <!-- header start --> 
   <div class="row header">
  <div class="col-md-10"></div>
  <div class="col-md-1"><a class="btn btn-primary">关于我们</a></div>
  <div class="col-md-1">
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">登陆</button>
  </div>
  </div> 
  <!-- header end -->   
  
  
  <div id="myCarousel" class="carousel slide row" data-interval=5000>
   <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
   </ol>  
   <!-- 轮播（Carousel）项目 -->
   <div class="carousel-inner">
      <div class="item active">
         <img src="img/index/first.jpg" alt="First slide" class="img-responsive center-block">
         <div class="carousel-caption ">
          
         </div>
      </div>
      <div class="item">
         <img src="img/index/second.jpg" alt="Second slide" class="img-responsive center-block">
         <div class="carousel-caption">
         </div>
      </div>
      <div class="item">
      
         <img src="img/index/third.jpg" alt="Third slide" class="img-responsive center-block">
         <div class="carousel-caption">
         </div>
      </div>
   </div>
   <!-- 轮播（Carousel）导航 -->
   <a class="carousel-control left" href="#myCarousel" 
      data-slide="prev"><img alt="menuleft" src="img/index/menul.gif"></a>
   <a class="carousel-control right" href="#myCarousel" 
      data-slide="next"><img alt="menuright" src="img/index/menur.gif"></a>
</div> 
  

<!-- <div class="row footer">
  <div class="col-md-4"></div>
  <div class="col-md-4"></div>
  <div class="col-md-4">
  <h3>友情链接</h3>
  <h4><a href="http://glyphicons.com"> Glyphicons</a></h4>
  <h4><a href="http://jwch.fzu.edu.cn/"> 福大教务处</a></h4>
  <h4><a href="http://glyphicons.com"> Glyphicons</a></h4>
  <h4><a href="http://glyphicons.com"> Glyphicons</a></h4>
  </div>
  <div class="col-md-12">Copyright©软件工程第六小组</div>
</div> -->


 </div>
  
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
  </body>
</html>