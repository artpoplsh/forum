package forum.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.admin.dao.InvitationDao;
import forum.admin.dao.InvitationDaoImpl;
import forum.admin.dao.StudentDaoImpl;
import forum.admin.domain.Invitation;
import forum.admin.domain.Student;

public class UncheckedInvitationMgrServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private InvitationDao invitationDao;
	private PageCut pageCut;
	private List allList;
	private List limitList;
	private boolean selectAllChecked;
	private List checkedList;
	private String orderBy;//��ʲô��ʽ����
	private String order;//����������
	private String authorId;
	public UncheckedInvitationMgrServlet() {
		super();
		this.invitationDao=new InvitationDaoImpl();
		this.authorId="";
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
			this.orderBy="date";
			this.order="asc";
			
			
			int totalNum=this.invitationDao.getInvitaionCount(this.authorId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
			this.allList=this.invitationDao.getAllInvitation(this.authorId,this.orderBy,this.order);
			
			
			this.selectAllChecked=false;
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<this.pageCut.getTotalNum();i++) this.checkedList.add(false);
			if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
					response);
		}
		//��һҳ
		else if(mid==1){
			String selectAll=request.getParameter("selectAll");
			Boolean selectAllChecked;
			if(selectAll.equals("true")) selectAllChecked=true;
			else selectAllChecked=false;
			if(selectAllChecked==null) selectAllChecked=false;
			//this.checkedList=(List) request.getAttribute("checkedList");
			String checked=(String) request.getParameter("checked");
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<checked.length();i++){
				if(checked.charAt(i)=='1') checkedList.add(true);
				else checkedList.add(false);
			}
			System.out.println("length="+checkedList.size());
			this.pageCut.nextPage();
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
			System.out.println("rest"+this.pageCut.getLastNum()+totalPage+currPage);
			if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
					response);
			
		}
		//ͨ��ĳһ������
		else if(mid==2){
			int id=Integer.parseInt(request.getParameter("id"));
			String selectAll=request.getParameter("selectAll");
			Boolean selectAllChecked;
			if(selectAll.equals("true")) selectAllChecked=true;
			else selectAllChecked=false;
			if(selectAllChecked==null) selectAllChecked=false;
			//this.checkedList=(List) request.getAttribute("checkedList");
			String checked=(String) request.getParameter("checked");
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<checked.length();i++){
				if(checked.charAt(i)=='1') checkedList.add(true);
				else checkedList.add(false);
			}
			this.checkedList.remove(((this.pageCut.getCurPage()-1)*this.pageCut.getPAGESIZE())+id);
			this.invitationDao.passInvitation(((Invitation)this.limitList.get(id)).getId());
			
			int totalNum=this.invitationDao.getInvitaionCount(this.authorId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
			this.allList=this.invitationDao.getAllInvitation(this.authorId,this.orderBy,this.order);
			
			if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getTotalNum());
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
					response);
		}
		//��һҳ
		else if(mid==3){
			String selectAll=request.getParameter("selectAll");
			Boolean selectAllChecked;
			if(selectAll.equals("true")) selectAllChecked=true;
			else selectAllChecked=false;
			if(selectAllChecked==null) selectAllChecked=false;
			//this.checkedList=(List) request.getAttribute("checkedList");
			String checked=(String) request.getParameter("checked");
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<checked.length();i++){
				if(checked.charAt(i)=='1') checkedList.add(true);
				else checkedList.add(false);
			}
			System.out.println("length="+checkedList.size());
			this.pageCut.previousPage();
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
			//System.out.println("rest"+this.pageCut.getLastNum()+totalPage+currPage);
			if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
					response);
			
		}
		//��ת��ĳҳ
		//��һҳ
		else if(mid==4){
			String selectAll=request.getParameter("selectAll");
			int page=Integer.parseInt(request.getParameter("page"));
			Boolean selectAllChecked;
			if(selectAll.equals("true")) selectAllChecked=true;
			else selectAllChecked=false;
			if(selectAllChecked==null) selectAllChecked=false;
			//this.checkedList=(List) request.getAttribute("checkedList");
			String checked=(String) request.getParameter("checked");
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<checked.length();i++){
				if(checked.charAt(i)=='1') checkedList.add(true);
				else checkedList.add(false);
			}
			//System.out.println("length="+checkedList.size());
			this.pageCut.turnTo(page);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
			//System.out.println("rest"+this.pageCut.getLastNum()+totalPage+currPage);
			if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
					response);
			
		}
		//��ͨ��ĳһ�����ӣ���ɾ����
		else if(mid==5){
			int id=Integer.parseInt(request.getParameter("id"));
			String selectAll=request.getParameter("selectAll");
			Boolean selectAllChecked;
			if(selectAll.equals("true")) selectAllChecked=true;
			else selectAllChecked=false;
			if(selectAllChecked==null) selectAllChecked=false;
			//this.checkedList=(List) request.getAttribute("checkedList");
			String checked=(String) request.getParameter("checked");
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<checked.length();i++){
				if(checked.charAt(i)=='1') checkedList.add(true);
				else checkedList.add(false);
			}
			this.checkedList.remove(((this.pageCut.getCurPage()-1)*this.pageCut.getPAGESIZE())+id);
			this.invitationDao.deleteInvitation(((Invitation)this.limitList.get(id)).getId());
			
			int totalNum=this.invitationDao.getInvitaionCount(this.authorId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
			this.allList=this.invitationDao.getAllInvitation(this.authorId,this.orderBy,this.order);
			
			if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getTotalNum());
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
					response);
		}
		//��������
		if (mid == 6) {
			//List invitationList=null;
			this.orderBy=request.getParameter("orderBy");
			this.order=request.getParameter("order");
			System.out.println("orderBy"+orderBy);
			int totalNum=this.invitationDao.getInvitaionCount(this.authorId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
			this.allList=this.invitationDao.getAllInvitation(this.authorId,this.orderBy,this.order);
			
			this.selectAllChecked=false;
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<this.pageCut.getTotalNum();i++) this.checkedList.add(false);
			if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
					response);
		}
		//ͨ�����б�ѡ�е�����
		else if(mid==7){
			String selectAll=request.getParameter("selectAll");
			Boolean selectAllChecked=false;
			if(selectAllChecked==null) selectAllChecked=false;
			//this.checkedList=(List) request.getAttribute("checkedList");
			String checked=(String) request.getParameter("checked");
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<checked.length();i++){
				if(checked.charAt(i)=='1') checkedList.add(true);
				else checkedList.add(false);
			}
			for(int i=0;i<this.checkedList.size();i++){
				if((Boolean)this.checkedList.get(i)) this.invitationDao.passInvitation(((Invitation)this.allList.get(i)).getId());
			}
			
			
			int totalNum=this.invitationDao.getInvitaionCount(this.authorId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
			this.allList=this.invitationDao.getAllInvitation(this.authorId,this.orderBy,this.order);
			
			this.selectAllChecked=false;
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<this.pageCut.getTotalNum();i++) this.checkedList.add(false);
			if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
					response);
		}
		//�ܾ����б�ѡ�е�����
		else if(mid==8){
			String selectAll=request.getParameter("selectAll");
			Boolean selectAllChecked=false;
			if(selectAllChecked==null) selectAllChecked=false;
			//this.checkedList=(List) request.getAttribute("checkedList");
			String checked=(String) request.getParameter("checked");
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<checked.length();i++){
				if(checked.charAt(i)=='1') checkedList.add(true);
				else checkedList.add(false);
			}
			for(int i=0;i<this.checkedList.size();i++){
				if((Boolean)this.checkedList.get(i)) this.invitationDao.deleteInvitation(((Invitation)this.allList.get(i)).getId());
			}
			
			
			int totalNum=this.invitationDao.getInvitaionCount(this.authorId);
			this.pageCut=new PageCut(totalNum);
			int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
			int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
			int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
			this.allList=this.invitationDao.getAllInvitation(this.authorId,this.orderBy,this.order);
			
			this.selectAllChecked=false;
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<this.pageCut.getTotalNum();i++) this.checkedList.add(false);
			if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
			else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
					(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
					response);
		}
		else if (mid == 9) {
			this.authorId = request.getParameter("authorIdsearch");
			
				int totalNum=this.invitationDao.getInvitaionCount(this.authorId);
				this.pageCut=new PageCut(totalNum);
				int currPage=this.pageCut.getCurPage();//�����ڵڼ�ҳ
				int totalPage=this.pageCut.getTotalPage();//�ܹ��м�ҳ
				int restNum=this.pageCut.getRestNum();//���м���δ���ļ�¼
				this.allList=this.invitationDao.getAllInvitation(this.authorId,this.orderBy,this.order);
				
				this.selectAllChecked=false;
				this.checkedList=new ArrayList<Boolean>();
				for(int i=0;i<this.pageCut.getTotalNum();i++) this.checkedList.add(false);
				if(currPage==totalPage) this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
						(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getLastNum(), this.orderBy, this.order);
				else this.limitList=this.invitationDao.getLimitInvitation(this.authorId,
						(currPage-1)*this.pageCut.getPAGESIZE(), this.pageCut.getPAGESIZE(), this.orderBy, this.order);
				request.setAttribute("invitationList", limitList);
				request.setAttribute("pageCut", pageCut);
				System.out.println("pageCut"+pageCut.getCurPage()+"totalpage"+pageCut.getLastNum());
				request.setAttribute("selectAllChecked", selectAllChecked);
				request.setAttribute("checkedList", this.checkedList);
				request.getRequestDispatcher("/view.admin/mainpage.jsp").forward(request,
						response);
		}
		//�鿴ѧ������
		else if(mid==11){
			String id=request.getParameter("id");
			String selectAll=request.getParameter("selectAll");
			Boolean selectAllChecked;
			if(selectAll.equals("true")) selectAllChecked=true;
			else selectAllChecked=false;
			if(selectAllChecked==null) selectAllChecked=false;
			//this.checkedList=(List) request.getAttribute("checkedList");
			String checked=(String) request.getParameter("checked");
			this.checkedList=new ArrayList<Boolean>();
			for(int i=0;i<checked.length();i++){
				if(checked.charAt(i)=='1') checkedList.add(true);
				else checkedList.add(false);
			}
			//����studentdao��Ѱ��
			StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
			Student student=studentDaoImpl.getStudentById(id);
			request.setAttribute("student", student);
			request.setAttribute("invitationList", limitList);
			request.setAttribute("pageCut", pageCut);
			System.out.println("pageCut"+pageCut.getTotalNum());
			request.setAttribute("selectAllChecked", selectAllChecked);
			request.setAttribute("checkedList", this.checkedList);
			request.getRequestDispatcher("/view.admin/mainpage.jsp?rid=1").forward(request,
					response);
		}
		//�鿴��������
				else if(mid==10){
					int id=Integer.parseInt(request.getParameter("id"));
					String selectAll=request.getParameter("selectAll");
					Boolean selectAllChecked;
					if(selectAll.equals("true")) selectAllChecked=true;
					else selectAllChecked=false;
					if(selectAllChecked==null) selectAllChecked=false;
					//this.checkedList=(List) request.getAttribute("checkedList");
					String checked=(String) request.getParameter("checked");
					this.checkedList=new ArrayList<Boolean>();
					for(int i=0;i<checked.length();i++){
						if(checked.charAt(i)=='1') checkedList.add(true);
						else checkedList.add(false);
					}
					Invitation invitation=(Invitation) this.limitList.get(id);
					request.setAttribute("invitation", invitation);
					request.setAttribute("invitationList", limitList);
					request.setAttribute("pageCut", pageCut);
					System.out.println("pageCut"+pageCut.getTotalNum());
					request.setAttribute("selectAllChecked", selectAllChecked);
					request.setAttribute("checkedList", this.checkedList);
					request.getRequestDispatcher("/view.admin/mainpage.jsp?rid=0").forward(request,
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
