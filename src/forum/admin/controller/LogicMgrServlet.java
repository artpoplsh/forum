package forum.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogicMgrServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LogicMgrServlet() {
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

		doPost(request, response);
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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		int mid = Integer.parseInt(request.getParameter("mid"));
		//跳转到index
		if(mid==0)
		{
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}
		//跳转到首页
		else if(mid==1)
		{
			request.getRequestDispatcher("/uncheckedInvitationMgrChen?mid=0").forward(request,
					response);
		}
		//跳转到用户权限管理页面
		else if(mid==2){
			request.getRequestDispatcher("/studentMgrChen?mid=0").forward(request,
					response);
		}
		//跳转到帖子管理界面
		else if(mid==3){
			request.getRequestDispatcher("/checkedInvitationMgrChen?mid=0").forward(request,
					response);
		}
		//跳转到帖子管理界面
		else if(mid==4){
			request.getRequestDispatcher("/checkedInvitationMgrChen?mid=0").forward(request,
					response);
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
