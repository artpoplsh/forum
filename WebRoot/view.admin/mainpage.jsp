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
	List invitationList=(List)request.getAttribute("invitationList");
	PageCut pageCut=(PageCut)request.getAttribute("pageCut");
	Boolean selectAllChecked=(Boolean)request.getAttribute("selectAllChecked");
	ArrayList<Boolean> checkedList=(ArrayList<Boolean>)request.getAttribute("checkedList");
	String checked="";
	for(int i=0;i<checkedList.size();i++)
	{
		if(checkedList.get(i).booleanValue()) checked+="1";
		else checked+="0";
	}
	//列表的第一个的数字
	int first=(pageCut.getCurPage()-1)*pageCut.getPAGESIZE();
%>
<script type="text/javascript">
        
            var checkedL="<%=checked %>" ;
			var total=<%=pageCut.getTotalNum() %>;
			var num=<%=pageCut.getPAGESIZE() %>;
			var from=<%=first %>;
			var totalpage=<%=pageCut.getTotalPage() %>;
			var n=<%=invitationList.size() %>;
			//alert("n"+n);
		function deleteShowDiv(){
			$("#showdiv").remove();
		}
		function previousPage()
		{
			for(var i=0;i<n;i++){ 
			    //alert("in"+n);
				if(document.getElementsByName("uncheckedInvitationChecked")[i].checked){
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					//alert(checkedL);
			     }
			     else{
			     	var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(i+checkedL);
			     }
			     }
			     var selectAll;
			     if(document.getElementById("selectAll").checked) selectAll="true";
			     else selectAll="false";
			     //alert("yes");
			    window.location.assign("uncheckedInvitationMgrChen?mid=3&checked="+checkedL+"&selectAll="+selectAll);
		}
		function nextPage()
		{
			//alert(""+checkedL+selectAll);
			for(var i=0;i<n;i++){ 
			    //alert("in"+n);
				if(document.getElementsByName("uncheckedInvitationChecked")[i].checked){
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					//alert(checkedL);
			     }
			     else{
			     	var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(i+checkedL);
			     }
			     }
			     var selectAll;
			     if(document.getElementById("selectAll").checked) selectAll="true";
			     else selectAll="false";
			     //alert(checkedL+selectAll);
			    window.location.assign("uncheckedInvitationMgrChen?mid=1&checked="+checkedL+"&selectAll="+selectAll);
		}
		function turnTo()
		{
			//alert(""+checkedL);
			for(var i=0;i<n;i++){ 
			    //alert("in"+n);
				if(document.getElementsByName("uncheckedInvitationChecked")[i].checked){
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					//alert(checkedL);
			     }
			     else{
			     	var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(i+checkedL);
			     }
			     }
			     var selectAll;
			     if(document.getElementById("selectAll").checked) selectAll="true";
			     else selectAll="false";
			     //alert("yes");
			     var page=document.getElementById("turnTo").value;
			     //alert(page);
			     if(value!=''&&value>='1'&&value<='totalpage') 
			     window.location.assign("uncheckedInvitationMgrChen?mid=4&page="+page+"&checked="+checkedL+"&selectAll="+selectAll);
		}
		function passOne(id)
		{
			//alert(""+checkedL);
			for(var i=0;i<n;i++){ 
			    //alert("in"+n);
				if(document.getElementsByName("uncheckedInvitationChecked")[i].checked){
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					//alert(checkedL);
			     }
			     else{
			     	var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(i+checkedL);
			     }
			     }
			     var selectAll;
			     if(document.getElementById("selectAll").checked) selectAll="true";
			     else selectAll="false";
			     //alert("yes");
			    window.location.assign("uncheckedInvitationMgrChen?mid=2&id="+id+"&checked="+checkedL+"&selectAll="+selectAll);
		}
		function nopassOne(id)
		{
			//alert(""+checkedL);
			for(var i=0;i<n;i++){ 
			    //alert("in"+n);
				if(document.getElementsByName("uncheckedInvitationChecked")[i].checked){
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					//alert(checkedL);
			     }
			     else{
			     	var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(i+checkedL);
			     }
			     }
			     var selectAll;
			     if(document.getElementById("selectAll").checked) selectAll="true";
			     else selectAll="false";
			     //alert("yes");
			    window.location.assign("uncheckedInvitationMgrChen?mid=5&id="+id+"&checked="+checkedL+"&selectAll="+selectAll);
		}
		function passAll()
		{
			for(var i=0;i<n;i++){ 
			    //alert("in"+n);
				if(document.getElementsByName("uncheckedInvitationChecked")[i].checked){
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					//alert(checkedL);
			     }
			     else{
			     	var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(i+checkedL);
			     }
			     }
			     var selectAll;
			     if(document.getElementById("selectAll").checked) selectAll="true";
			     else selectAll="false";
			     //alert("yes");
			    window.location.assign("uncheckedInvitationMgrChen?mid=7&checked="+checkedL+"&selectAll="+selectAll);
		}
		function nopassAll()
		{
			for(var i=0;i<n;i++){ 
			    //alert("in"+n);
				if(document.getElementsByName("uncheckedInvitationChecked")[i].checked){
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					//alert(checkedL);
			     }
			     else{
			     	var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(i+checkedL);
			     }
			     }
			     var selectAll;
			     if(document.getElementById("selectAll").checked) selectAll="true";
			     else selectAll="false";
			     //alert("yes");
			    window.location.assign("uncheckedInvitationMgrChen?mid=8&checked="+checkedL+"&selectAll="+selectAll);
		}
		function seeInvitation(id)
		{
			//alert("id"+id);
			for(var i=0;i<n;i++){ 
			    //alert("in"+n);
				if(document.getElementsByName("uncheckedInvitationChecked")[i].checked){
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					//alert(checkedL);
			     }
			     else{
			     	var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(i+checkedL);
			     }
			     }
			     var selectAll;
			     if(document.getElementById("selectAll").checked) selectAll="true";
			     else selectAll="false";
			     //alert("yes");
			    window.location.assign("uncheckedInvitationMgrChen?mid=10&id="+id+"&checked="+checkedL+"&selectAll="+selectAll);
		}
		
		function seeStudent(id)
		{
			//alert("id"+id);
			for(var i=0;i<n;i++){ 
			    //alert("in"+n);
				if(document.getElementsByName("uncheckedInvitationChecked")[i].checked){
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					//alert(checkedL);
			     }
			     else{
			     	var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(i+checkedL);
			     }
			     }
			     var selectAll;
			     if(document.getElementById("selectAll").checked) selectAll="true";
			     else selectAll="false";
			     //alert("yes");
			    window.location.assign("uncheckedInvitationMgrChen?mid=11&id="+id+"&checked="+checkedL+"&selectAll="+selectAll);
		}
		
		function selectAll(){
		    //alert(document.getElementById("selectAll").checked);
			if(document.getElementById("selectAll").checked){
			   var i=0;
				for(i=0;i<total;i++){ 
			        
				    if(i<n) document.getElementsByName("uncheckedInvitationChecked")[i].checked=true;
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"1"+back;
					
			     }
			     }
			else{
			    //alert("here");
				for(var i=0;i<total;i++){ 
			    //alert("in"+n);
				    if(i<n) document.getElementsByName("uncheckedInvitationChecked")[i].checked=false;
					var front=checkedL.substr(0,i);
					var back;
					if((i+1)!=total) back=checkedL.substr(i+1);
					else back="";
					checkedL=front+"0"+back;
					//alert(checkedL);
			     }
			     
			     }
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
			    <li><a href="logicMgr?mid=1" class="active"><span>首页</span></a></li>
			    <li><a href="logicMgr?mid=2"><span>用户管理</span></a></li>
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
			<a href="#">首页</a>
			<span>&gt;</span>
			未审核帖子管理
		</div>
		<!-- End Small Nav 
		
		 Message OK -->		
		<!--<div class="msg msg-ok">
			<p><strong>Your file was uploaded succesifully!</strong></p>
			<a href="#" class="close">close</a>
		</div>-->
		<!-- End Message OK -->		
		
		<!-- Message Error -->
		<div class="msg msg-error">
			<p><strong>你有<%=pageCut.getTotalNum() %>条帖子未审核</strong></p>
			<a href="#" class="close">close</a>
		</div>
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
						<form action="uncheckedInvitationMgrChen?mid=9" method="post">
							<label>添加者ID号：</label>
							
							<input name="authorIdsearch" type="text" id="authorIDsearch" class="field small-field" />
							<input type="submit" class="button" value="search" />
							</form>
						</div>
					</div>
					<!-- End Box Head -->	

					<!-- Table -->
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th width="13"> </th>
								<th>帖子内容</th>
								<th>日期</th>
								<th>添加者ID号</th>
								<th width="110" class="ac">操作</th>
							</tr>
							<% for(int i=0;i<invitationList.size();i++){
							%>
							<tr <% if((i%2)!=0) out.print("class='odd'"); %>>
								<td><input type="checkbox" name="uncheckedInvitationChecked" class="checkbox" <%
										if(checkedList.get(first+i)) out.print("checked='checked'");
										%>/></td>
								<td><h3><a onclick="seeInvitation(<%=i %>)">
								<% 
									String title=((Invitation)invitationList.get(i)).getTitle();//((Invitation)invitationList.get(i)).getTitle();
									if(title.length()>10) out.print(title.substring(0, 10)+"..."); 
									else out.print(title);
								%></a></h3></td>
								<td><%=((Invitation)invitationList.get(i)).getDate() %></td>
								<td><a onclick="seeStudent(<%=((Invitation)invitationList.get(i)).getAuthorId() %>)"><%=((Invitation)invitationList.get(i)).getAuthorId() %></a></td>
								<td><a onclick="passOne(<%=i %>)" class="ico pass">通过</a><a onclick="nopassOne(<%=i %>)" class="ico nopass">拒绝</a></td>
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
						
						<p  class="select-all"><input id="selectAll" onclick="selectAll()"  type="checkbox" class="checkbox" <%if(selectAllChecked) out.print("checked='checked'"); %> /><label>全选</label></p>
						<p><a onclick="passAll()" class="ico pass">通过</a><a onclick="nopassAll()" class="ico nopass">拒绝</a></p>
						
						<!-- Sort -->
						<div class="sort">
							<label>选择排序方式</label>
							<form action="uncheckedInvitationMgrChen?mid=6" method="post">
							<select name="orderBy" class="field">
								<option value="title">帖子内容</option>
								<option value="date">日期</option>
								<option value="authorid">添加者ID号</option>
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
		Invitation invitation=(Invitation)request.getAttribute("invitation");
		String content="";
		if(invitation==null) content="cuola";
		else content=invitation.getTitle();
 %>
 	<div id="showdiv" >
 		<div id="showtop" ><div id="showtopimage" onclick="deleteShowDiv()"/><img src="admincss/images/iknow.png"/></div>
 		<div id="showcontent" >
 		 <span>帖子内容:</span>
 		 <br /><br />
 		 <p><%=content %></p>
 		</div>
 	</div>
 <%}else if(ridNum==1){
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
 		</div>
 	</div>
  <%} %>
<!-- End Footer -->
	
</body>
</html>

    
    
    