package forum.global.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forum.admin.domain.Admin;
import forum.admin.service.AdminServiceImpl;
import forum.student.dao.StudentsDaoImpl;
import forum.student.domain.Student;
import forum.student.service.StudentService;
import forum.student.service.StudentServiceImpl;
import forum.teacher.domain.Teacher;
import forum.teacher.service.TeacherService;
import forum.teacher.service.TeacherServiceImpl;

public class GlobalServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GlobalServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentService ss=new StudentServiceImpl();
		request.setCharacterEncoding("utf-8");
		int mid = Integer.parseInt(request.getParameter("mid"));
		//midΪ0�����¼
		if (mid == 0) {
//			request.setCharacterEncoding("utf-8");
//			String role = request.getParameter("role");
//			if(role.equals("student")){
//			request.getRequestDispatcher("/view.student/studentIndex.jsp")
//			.forward(request, response);
//			}
			request.setCharacterEncoding("utf-8");
			String errMsg = "";
			RequestDispatcher rd;
			String id = request.getParameter("id");
			String pass = request.getParameter("password");
			String role = request.getParameter("role");
			if(role.equals("student")){
				//StudentService ss=new StudentServiceImpl();
				Student student=ss.getStudentByIdCard(id);
				//Student student=ss.getStudentByName(id);
				if(student==null){errMsg="��ѧ����Ϣ��֤����";System.out.println("wrong"+id);}
				else{
					//��֤��ȷ
					if(pass.equals(student.getPassword())){
						HttpSession session=request.getSession(true);
						session.setAttribute("studentid", student.getId());
						session.setAttribute("teacherid", null);
						session.setAttribute("name", student.getName());
						//��ȡת������
						rd=request.getRequestDispatcher("postServlet?mid=0");//������һ��ת���ĵط�
						rd.forward(request, response);
					}
					else{
						errMsg="�����û������벻���ϣ�����������!";		
						}
				}
				
			}
			else if(role.equals("teacher"))
			{
				TeacherService ts=new TeacherServiceImpl();
				Teacher teacher=ts.getTeacherByIdCard(id);
				if(teacher==null){errMsg="�˽�ʦ��Ϣ��֤����";System.out.println("wrong"+id);}
				else{
					//��֤��ȷ
					if(pass.equals(teacher.getPassword())){
						HttpSession session=request.getSession(true);
						session.setAttribute("name", teacher.getName());
						
						session.setAttribute("teacherid", teacher.getId());
						session.setAttribute("studentid", null);
						//��ȡת������
						response.sendRedirect("postServlet?mid=0");
						/*rd=request.getRequestDispatcher("/view.teacher/teacherIndex.jsp");//������һ��ת���ĵط�
						rd.forward(request, response);*/
					}
					else{
						errMsg="�����û������벻���ϣ�����������!";		
						}
				}
				
			}else if(role.equals("admin"))
			{
				AdminServiceImpl ts=new AdminServiceImpl();
				Admin admin=ts.getAdminById(id);
				if(admin==null){errMsg="此管理员信息验证有误！";System.out.println("wrong"+id);}
				else{
					//验证正确
					if(pass.equals(admin.getPassword())){
						HttpSession session=request.getSession(true);
						session.setAttribute("name", admin.getName());
						
						session.setAttribute("adminid", admin.getId());
						//获取转发对象
						rd=request.getRequestDispatcher("uncheckedInvitationMgrChen?mid=0");//这里添一下转发的地方
						rd.forward(request, response);
					}
					else{
						errMsg="您的用户名密码不符合，请重新输入!";		
						}
				}
				
			}
//			if(errMsg!=null&&!errMsg.equals(""));
//			{
//				rd=request.getRequestDispatcher("/index.jsp");
//				request.setAttribute("err", errMsg);
//				rd.forward(request, response);
//			}
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
