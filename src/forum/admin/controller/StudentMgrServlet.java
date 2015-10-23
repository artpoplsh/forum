package forum.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import forum.admin.dao.InvitationDao;
import forum.admin.dao.StudentDao;
import forum.admin.dao.StudentDaoImpl;
import forum.admin.dao.TeacherDao;
import forum.admin.dao.TeacherDaoImpl;
import forum.admin.domain.Invitation;
import forum.admin.domain.Student;
import forum.admin.domain.Teacher;

public class StudentMgrServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private StudentDao studentDao;
	private PageCut pageCut;
	private List allList;
	private List limitList;
	//private boolean selectAllChecked;
	//private List checkedList;
	private String orderBy;//按什么方式排序
	private String order;//降序还是升序
	private String id;//搜索id
	private String teacherId;//教师id
	public StudentMgrServlet() {
		super();
		this.studentDao=new StudentDaoImpl();
		this.orderBy="id";
		this.order="asc";
		this.id="";
		this.teacherId="";
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
		// get inputClient.jsp
		//代表首次进入到这个页面
		if (mid == 0) {
			//List invitationList=null;
			int totalNum=this.studentDao.getStudentCount(id, teacherId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//现在在第几页
			int totalPage=this.pageCut.getTotalPage();//总共有几页
			int restNum=this.pageCut.getRestNum();//还有几条未读的记录
			this.allList=this.studentDao.getAllStudent(id, teacherId, orderBy, order);
			
			if(currPage==totalPage) this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp").forward(request,
					response);
		}
		//下一页
		else if(mid==1){
			
			this.pageCut.nextPage();
			int currPage=this.pageCut.getCurPage();//现在在第几页
			int totalPage=this.pageCut.getTotalPage();//总共有几页
			int restNum=this.pageCut.getRestNum();//还有几条未读的记录
			System.out.println("rest"+this.pageCut.getLastNum()+totalPage+currPage);
			if(currPage==totalPage) this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp").forward(request,
					response);
			
		}
		//通过某一条帖子
		else if(mid==2){
			
		}
		//上一页
		else if(mid==3){

			this.pageCut.previousPage();
			int currPage=this.pageCut.getCurPage();//现在在第几页
			int totalPage=this.pageCut.getTotalPage();//总共有几页
			int restNum=this.pageCut.getRestNum();//还有几条未读的记录
			//System.out.println("rest"+this.pageCut.getLastNum()+totalPage+currPage);
			if(currPage==totalPage) this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp").forward(request,
					response);
			
		}
		//跳转到某页
		else if(mid==4){
			int page=Integer.parseInt(request.getParameter("page"));
			this.pageCut.turnTo(page);
			int currPage=this.pageCut.getCurPage();//现在在第几页
			int totalPage=this.pageCut.getTotalPage();//总共有几页
			int restNum=this.pageCut.getRestNum();//还有几条未读的记录
			//System.out.println("rest"+this.pageCut.getLastNum()+totalPage+currPage);
			if(currPage==totalPage) this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp").forward(request,
					response);
			
		}
		//不通过某一条帖子，机删除它
		else if(mid==5){
			
		}
		//进行排序
		if (mid == 6) {
			//List invitationList=null;
			this.orderBy=request.getParameter("orderBy");
			this.order=request.getParameter("order");
			System.out.println("orderBy"+orderBy);
			int totalNum=this.studentDao.getStudentCount(id, teacherId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//现在在第几页
			int totalPage=this.pageCut.getTotalPage();//总共有几页
			int restNum=this.pageCut.getRestNum();//还有几条未读的记录
			this.allList=this.studentDao.getAllStudent(id, teacherId, orderBy, order);
			
			if(currPage==totalPage) this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp").forward(request,
					response);
		}
		//修改某个帖子
		else if(mid==7){
			String studentId=request.getParameter("studentId");
			String[] limit=request.getParameterValues("limit");
			int limits=0;
			for(String l:limit)
			{
				if(l.equals("createInvitation")) limits+=1;
				if(l.equals("leaveInvitation")) limits+=2;
				if(l.equals("handinMaterial")) limits+=4;
			}
			this.studentDao.updateStudent(studentId, limits);
			
			
			int totalNum=this.studentDao.getStudentCount(id, teacherId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//现在在第几页
			int totalPage=this.pageCut.getTotalPage();//总共有几页
			int restNum=this.pageCut.getRestNum();//还有几条未读的记录
			this.allList=this.studentDao.getAllStudent(id, teacherId, orderBy, order);
			
			if(currPage==totalPage) this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp").forward(request,
					response);
			
		}
		//修改全部的权限
		else if(mid==8){
			String[] limit=request.getParameterValues("limit");
			int limits=0;
			for(String l:limit)
			{
				if(l.equals("createInvitation")) limits+=1;
				if(l.equals("leaveInvitation")) limits+=2;
				if(l.equals("handinMaterial")) limits+=4;
			}
			for(int i=0;i<this.allList.size();i++)
			{
				//System.out.println("id"+((Student)this.allList.get(i)).getId()+"limits"+limits);
				this.studentDao.updateStudent(((Student)this.allList.get(i)).getId(), limits);
			}
			
			int totalNum=this.studentDao.getStudentCount(id, teacherId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//现在在第几页
			int totalPage=this.pageCut.getTotalPage();//总共有几页
			int restNum=this.pageCut.getRestNum();//还有几条未读的记录
			this.allList=this.studentDao.getAllStudent(id, teacherId, orderBy, order);
			
			if(currPage==totalPage) this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp").forward(request,
					response);
		}
		else if (mid == 9) {
			   this.id = request.getParameter("studentId");
			   this.teacherId=request.getParameter("teacherId");
			
			   int totalNum=this.studentDao.getStudentCount(id, teacherId);
				this.pageCut=new PageCut(totalNum);
				int currPage=this.pageCut.getCurPage();//现在在第几页
				int totalPage=this.pageCut.getTotalPage();//总共有几页
				int restNum=this.pageCut.getRestNum();//还有几条未读的记录
				this.allList=this.studentDao.getAllStudent(id, teacherId, orderBy, order);
				
				if(currPage==totalPage) this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
						(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
				else this.limitList=this.studentDao.getLimitStudent(id, teacherId, 
						(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
				request.setAttribute("studentList", limitList);
				request.setAttribute("pageCut", pageCut);
				System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
				request.getRequestDispatcher("/view.admin/studentManager.jsp").forward(request,
						response);
		}
		//查看学生内容
		else if(mid==11){
			String studentid=request.getParameter("studentId");
			//利用studentdao来寻找
			StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
			Student student=studentDaoImpl.getStudentById(studentid);
			request.setAttribute("student", student);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getTotalNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp?rid=0").forward(request,
					response);
		}
		//查看老师内容
		else if(mid==10){
			String teacherid=request.getParameter("teacherId");
			TeacherDao teacherDao=new TeacherDaoImpl();
			Teacher teacher=teacherDao.getTeacherById(teacherid);
			System.out.println("teacherid"+teacherid);
			request.setAttribute("teacher", teacher);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getTotalNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp?rid=1").forward(request,
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
