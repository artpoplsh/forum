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
	private String orderBy;//��ʲô��ʽ����
	private String order;//����������
	private String id;//����id
	private String teacherId;//��ʦid
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
		//�����״ν��뵽���ҳ��
		if (mid == 0) {
			//List invitationList=null;
			int totalNum=this.studentDao.getStudentCount(id, teacherId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
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
		//��һҳ
		else if(mid==1){
			
			this.pageCut.nextPage();
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
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
		//ͨ��ĳһ������
		else if(mid==2){
			
		}
		//��һҳ
		else if(mid==3){

			this.pageCut.previousPage();
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
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
		//��ת��ĳҳ
		else if(mid==4){
			int page=Integer.parseInt(request.getParameter("page"));
			this.pageCut.turnTo(page);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
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
		//��ͨ��ĳһ�����ӣ���ɾ����
		else if(mid==5){
			
		}
		//��������
		if (mid == 6) {
			//List invitationList=null;
			this.orderBy=request.getParameter("orderBy");
			this.order=request.getParameter("order");
			System.out.println("orderBy"+orderBy);
			int totalNum=this.studentDao.getStudentCount(id, teacherId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
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
		//�޸�ĳ������
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
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
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
		//�޸�ȫ����Ȩ��
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
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
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
				int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
				int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
				int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
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
		//�鿴ѧ������
		else if(mid==11){
			String studentid=request.getParameter("studentId");
			//����studentdao��Ѱ��
			StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
			Student student=studentDaoImpl.getStudentById(studentid);
			request.setAttribute("student", student);
			request.setAttribute("studentList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getTotalNum());
			request.getRequestDispatcher("/view.admin/studentManager.jsp?rid=0").forward(request,
					response);
		}
		//�鿴��ʦ����
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
