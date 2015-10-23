package forum.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.admin.dao.InvitationContent;
import forum.admin.domain.Invitation;
import forum.global.domain.Releasehomework;
import forum.student.dao.InvitationContentDaoImpl;
import forum.student.dao.InvitationDaoImpl;
import forum.student.dao.InvitationcommentDao;
import forum.student.domain.Invitationcomment;
import forum.student.domain.Invitationcontent;
@WebServlet(name = "postServlet",urlPatterns={"/postServlet"})
public class PostServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PostServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int mid = Integer.parseInt(request.getParameter("mid"));

		// get inputClient.jsp
		if (mid == 0) {//帖子首页
			InvitationDaoImpl Invitation=new InvitationDaoImpl();
			ArrayList<Invitation> postlist=(ArrayList<Invitation>)Invitation.getAllInvitation();
			request.setAttribute("postlist", postlist);
			if(request.getSession(true).getAttribute("studentid")!=null)
			request.getRequestDispatcher("/view.student/post.jsp").forward(request,
					response);
			else if(request.getSession(true).getAttribute("teacherid")!=null)
				request.getRequestDispatcher("/view.teacher/post.jsp").forward(request,
					response);
		}else if(mid==1){//帖子详情
			int id = Integer.parseInt(request.getParameter("id"));
			
			InvitationContentDaoImpl invitationContentDaoImpl=new InvitationContentDaoImpl();
			Invitationcontent invitationcontent=invitationContentDaoImpl.getInvitationContentById(id);
			//System.out.println(invitationcontent.getContent());
			
			InvitationcommentDao invitationcommentDao=new InvitationcommentDao();
			ArrayList<Invitationcomment> invitationcomment=(ArrayList<Invitationcomment>)invitationcommentDao.getInvitationcommentById(id);
			//System.out.println("serlet:"+invitationcomment.get(1).getComment());
			request.setAttribute("invitationcomment",invitationcomment);
			request.setAttribute("postContent",invitationcontent.getContent());
			if(request.getSession(true).getAttribute("studentid")!=null)
			request.getRequestDispatcher("/view.student/postDetail.jsp").forward(request,
					response);
			else if(request.getSession(true).getAttribute("teacherid")!=null)
				request.getRequestDispatcher("/view.teacher/postDetail.jsp").forward(request,
					response);
		}else if(mid==2){//发帖
			try{String title = request.getParameter("title");
			String content = request.getParameter("content");
			//System.out.println("hgsg"+title+content);
			String authorId=(String)request.getSession(true).getAttribute("studentid");
			System.out.println(authorId);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			Invitation invitation=new Invitation();
			invitation.setTitle(title);
			invitation.setAuthorId(authorId);
			invitation.setDate(df.format(new Date()));
			//invitation.setId(System.currentTimeMillis());
			invitation.setIsChecked(0);
			InvitationDaoImpl invitationDaoImpl=new InvitationDaoImpl();
			invitationDaoImpl.addInvitation(invitation);
			int id=invitationDaoImpl.getLimitInvitation(invitation);
			Invitationcontent invitationContent =new Invitationcontent();
			invitationContent.setContent(content);
			invitationContent.setInvitationid(id);
			InvitationContentDaoImpl invitationContentdaoImpl=new InvitationContentDaoImpl();
			invitationContentdaoImpl.addInvitationcontent(invitationContent);
			response.sendRedirect("postServlet?mid=0");
			
			
			
			}
		 catch(Exception e){
			System.out.println("---------cuowu--------------");
		 }
		}else if(mid==3){
			String comment = request.getParameter("comment");
			//System.out.println("hgsg"+title+content);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			String commentId=(String)request.getSession(true).getAttribute("studentid");
			System.out.println(commentId+comment);
			InvitationcommentDao invitationcommentDao=new InvitationcommentDao();
		
			String str="{'comment':'"+comment+"','commentId':'"+commentId+"','time':'"+df.format(new Date())+"'}";
			response.setContentType("application/json;charset=UTF-8");//必须的设置，返回串类型指定json

			response.getWriter().print(str);
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
