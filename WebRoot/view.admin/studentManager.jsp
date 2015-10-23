<%@ page import="forum.admin.domain.Teacher"%>
<%@ page import="forum.admin.controller.PageCut"%>
<%@ page import="forum.admin.domain.Invitation" %>
<%@ page import="forum.admin.domain.Student" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>《软件工程》教学论坛</title>
	 <link rel="stylesheet" href="admincss/style.css?version=1" type="text/css" media="all" />
	 <script type="text/javascript" language="javascript" src="js/jquery-1.9.1.js"></script>
	<style type="text/css">
	</style>
</head>


<body>
<!-- Header -->
<% 
	request.setCharacterEncoding("UTF-8");
	String rid = request.getParameter("rid");
	List studentList=(List)request.getAttribute("studentList");
	PageCut pageCut=(PageCut)request.getAttribute("pageCut");
	//列表的第一个的数字
	int first=(pageCut.getCurPage()-1)*pageCut.getPAGESIZE();
%>
<script type="text/javascript">
        
			var total=<%=pageCut.getTotalNum() %>;
			var num=<%=pageCut.getPAGESIZE() %>;
			var from=<%=first %>;
			var totalpage=<%=pageCut.getTotalPage() %>;
			var n=<%=studentList.size() %>;
			//alert("n"+n);
		function deleteShowDiv(){
			$("#showdiv").remove();
		}
		function previousPage()
		{
			    window.location.assign("studentMgrChen?mid=3");
		}
		function nextPage()
		{
			    window.location.assign("studentMgrChen?mid=1");
		}
		function turnTo()
		{
			     var page=document.getElementById("turnTo").value;
			     //alert(page);
			     if(value!=''&&value>='1'&&value<='totalpage') 
			     window.location.assign("studentMgrChen?mid=4&page="+page);
		}
		function editOne(id)
		{
			   window.location.assign("studentMgrChen?mid=11&studentId="+id);
		}
		
		function seeTeacher(id)
		{
				//alert(id);
			    window.location.assign("studentMgrChen?mid=10&teacherId="+id);
		}
		
		function seeStudent(id)
		{
			    window.location.assign("studentMgrChen?mid=11&studentId="+id);
		}
		
    </script>
<div id="header">
	<div class="shell">
		<!-- Logo + Top Nav -->
		<div id="top">
			<h1>教学论坛后台管理</h1>
			<div id="top-navigation">
				欢迎， <a href="#"><strong><%
              String name = (String)session.getAttribute("name");
              out.println(name);
           %></strong></a>
				<span>|</span>
				<a href="#">帮助</a>
				<span>|</span>
				<a href="#">信息设置</a>
				<span>|</span>
				<a href="logicMgr?mid=0">退出</a>
			</div>
		</div>
		<!-- End Logo + Top Nav -->
		
		<!-- Main Nav -->
		<div id="navigation">
			<ul>
			    <li><a href="logicMgr?mid=1" ><span>首页</span></a></li>
			    <li><a href="logicMgr?mid=2" class="active"><span>用户管理</span></a></li>
			    <li><a href="logicMgr?mid=3"><span>帖子管理</span></a></li>
			    <li><a href="logicMgr?mid=4"><span>回复管理</span></a></li>
			</ul>
		</div>
		<!-- End Main Nav -->
	</div>
</div>
<!-- End Header -->

<!-- Container -->
<div id="container">
	<div class="shell">
		
		<!-- Small Nav -->
		<div class="small-nav">
			<a href="#">用户管理</a>
			<span>&gt;</span>
			用户权限管理
		</div>
		<!-- End Small Nav 
		
		 Message OK -->		
		<!--<div class="msg msg-ok">
			<p><strong>Your file was uploaded succesifully!</strong></p>
			<a href="#" class="close">close</a>
		</div>-->
		<!-- End Message OK -->		
		
		<!-- Message Error -->
		
		<!-- End Message Error -->
		<br />
		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>
			
			<!-- Content -->
			<div id="content">
				
				<!-- Box -->
				<div class="box">
					<!-- Box Head -->
					<div class="box-head">
						<h2 class="left"></h2>
						<div class="right">
						<form action="studentMgrChen?mid=9" method="post">
							<label>学生ID：</label>
						    <input name="studentId" type="text" id="studentId" class="field small-field" />
							
							<label>老师ID：</label>
							<input name="teacherId" type="text" id="studentId" class="field small-field" />
							<input type="submit" class="button" value="search" />
							</form>
						</div>
					</div>
					<!-- End Box Head -->	

					<!-- Table -->
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th >学号</th>
								<th >教师</th>
								<th >权限</th>
								<th width="110" class="ac">操作</th>
							</tr>
							<% for(int i=0;i<studentList.size();i++){
							%>
							<tr <% if((i%2)!=0) out.print("class='odd'"); %>>
								<td><h3><a onclick="seeStudent(<%=((Student)studentList.get(i)).getId() %>)">
								<%=((Student)studentList.get(i)).getId() %></a></h3></td>
								<td><h3><a onclick="seeTeacher(<%=((Student)studentList.get(i)).getTeacherId() %>)">
								<%=((Student)studentList.get(i)).getTeacherId() %></a></h3></td>
								<td><% 
								    String limit="";
									if(((Student)studentList.get(i)).isCreateInvitation()) limit+="发帖  ";
									if(((Student)studentList.get(i)).isLeaveInvitation()) limit+="回复  ";
									if(((Student)studentList.get(i)).isHandInMaterial()) limit+="上传资料";
									out.print(limit);
									 
								%></td>
								<td><a onclick="editOne(<%=((Student)studentList.get(i)).getId() %>)" class="ico edit">修改权限</a></td>
							</tr>
							<% 
							}
							%>
						</table>
						
						
						<!-- Pagging -->
						<div class="pagging">
							<div class="left">共<%=pageCut.getTotalPage() %>页,当前显示第<%=pageCut.getCurPage() %>页</div>
							<div class="right">
								<a onclick="previousPage()">上一页</a>
								<span>...</span>
								<a  id="nextPage" onclick="nextPage()"  > 下一页</a><span>转到</span><input type="text" id="turnTo" size="1"/><a class="aright" onclick="turnTo()">go</a>
							</div>
						</div>
						<!-- End Pagging -->
						
					</div>
					<!-- Table -->
					
				</div>
				<!-- End Box -->

			</div>
			<!-- End Content -->
			
			<!-- Sidebar -->
			<div id="sidebar">
				
				<!-- Box -->
				<div class="box">
					
					<!-- Box Head -->
					<div class="box-head">
						<h2>总管理区</h2>
					</div>
					<!-- End Box Head-->
					
					<div class="box-content">
						<!--  <a href="#" class="add-button"><span>Add new Article</span></a>-->
						<div class="cl">&nbsp;</div>
						<form action="studentMgrChen?mid=8" method="post" >
						<p  class="select-all">
							<input value="createInvitation" name="limit"  type="checkbox" class="checkbox" /><label>发帖</label>
							<input value="leaveInvitation" name="limit"  type="checkbox" class="checkbox"  /><label>回复</label>
							<input value="handinMaterial" name="limit"  type="checkbox" class="checkbox" /><label>上传资料</label>
						</p>
						<p><input type="submit" value="应用于全部用户" /></p>
						</form>
						
						<!-- Sort -->
						<div class="sort">
							<label>选择排序方式</label>
							<form action="studentMgrChen?mid=6" method="post">
							<select name="orderBy" class="field">
								<option value="id">学号</option>
								<option value="name">姓名</option>
							</select>
							<select name="order" class="field">
								<option value="asc">升序</option>
								<option value="desc">降序</option>
							</select> 
							<br />
							<input type="submit" value="进行排序" />
							</form>
						</div>
						<!-- End Sort -->
						
					</div>
				</div>
				<!-- End Box -->
			</div>
			<!-- End Sidebar -->
			
			<div class="cl">&nbsp;</div>			
		</div>
		<!-- Main -->
	</div>
</div>
<!-- End Container -->

<!-- Footer -->
<div id="footer">
	<div class="shell">
		<span class="left">&copy; 2015 - FZU</span>
		<span class="right">
			Design by <a href="http://chocotemplates.com" target="_blank" title="The Sweetest CSS Templates WorldWide">ChenYuting</a>
		</span>
	</div>
</div>
<%
    int ridNum=-1;
	if(rid!=null) ridNum=Integer.parseInt(request.getParameter("rid"));
	//显示一个消息
	if(ridNum==0){
		Student student=(Student)request.getAttribute("student");
 %>
 	<div id="showdiv" >
 		<div id="showtop" ><div id="showtopimage" onclick="deleteShowDiv()"/><img src="admincss/images/iknow.png"/></div>
 		<div id="showcontent" >
 		 <span>学生信息:</span>
 		 <br /><br />
 		 <span>学号:</span><span><%=student.getId() %></span><br /><br />
 		 <span>姓名:</span><span><%=student.getName() %></span><br /><br />
 		 <span>性别:</span><span><%=student.getSex() %></span><br /><br />
 		 <span>教师:</span><span><%=student.getTeacherId() %></span><br /><br />
 		 <form action="studentMgrChen?mid=7&studentId=<%=student.getId() %>" method="post" >
 		 	<span>权限:</span><br /><br />
						<p  class="select-all">
							<input value="createInvitation" name="limit"  type="checkbox" class="checkbox" <% if(student.isCreateInvitation()) out.print("checked='checked'"); %>/><label>发帖</label>
							<input value="leaveInvitation" name="limit"  type="checkbox" class="checkbox"  <% if(student.isLeaveInvitation()) out.print("checked='checked'"); %>/><label>回复</label>
							<input value="handinMaterial" name="limit"  type="checkbox" class="checkbox" <% if(student.isHandInMaterial()) out.print("checked='checked'"); %>/><label>上传资料</label>
						</p>
						<br />
						<p><input type="submit" value="修改" /></p>
						</form>
 		</div>
 	</div>
 <%}else if(ridNum==1){
 	Teacher teacher=(Teacher)request.getAttribute("teacher");
 	
  %>
  	<div id="showdiv" >
 		<div id="showtop" ><div id="showtopimage" onclick="deleteShowDiv()"/><img src="admincss/images/iknow.png"/></div>
 		<div id="showcontent" >
 		 <span>教师信息:</span>
 		 <br /><br />
 		 <span>教工号:</span><span><%=teacher.getId() %></span><br /><br />
 		 <span>姓名:</span><span><%=teacher.getName() %></span><br /><br />
 		 <span>性别:</span><span><%=teacher.getSex() %></span><br /><br />
 		</div>
 	</div>
  <%} %>
<!-- End Footer -->
	
</body>
</html>

    
    
