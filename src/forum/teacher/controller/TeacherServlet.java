package forum.teacher.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.global.domain.Material;
import forum.global.domain.Releasehomework;
import forum.global.service.HandinhomeworkService;
import forum.global.service.HandinhomeworkServiceImpl;
import forum.global.service.MaterialService;
import forum.global.service.ReleasehomeworkService;
import forum.global.service.ReleasehomeworkServiceImpl;


public class TeacherServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TeacherServlet() {
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
		request.setCharacterEncoding("utf-8");
		int mid = Integer.parseInt(request.getParameter("mid"));

		// get inputClient.jsp
		if (mid == 0) {
			request.getRequestDispatcher("/view.teacher/post.jsp").forward(request,
					response);
		}else if(mid==1){
			MaterialService ms = new MaterialService();
			ArrayList<Material> list = ms.getAllMaterial();
			request.setAttribute("result", list);
			request.getRequestDispatcher("/view.teacher/teacherUpload.jsp").forward(request,
					response);
		}else if(mid == 3){
			int id = Integer.parseInt(request.getParameter("id"));
			
			MaterialService ms = new MaterialService();
			 Material m = ms.getMaterialById(id);
			ms.delMaterial(id);
			//得到绝对路径
			String baseUrl = getServletContext().getRealPath("/");
            String url = baseUrl+m.getHyperlinkaddress();
			//String url ="forum/"+m.getHyperlinkaddress();
			//System.out.println(url);
			File f = new File(url); 
			if(f.exists())
			f.delete(); 
			else{
				System.out.println("===============cuowu");
			}
			
			request.getRequestDispatcher("TeacherServlet?mid=1").forward(request,
					response);
		}else if(mid == 4){
			//查询发布的作业文件
			ReleasehomeworkService rhs = new ReleasehomeworkServiceImpl ();
			ArrayList<Releasehomework> list = rhs.getAllReleasehomework();
			request.setAttribute("result", list);
			request.getRequestDispatcher("/view.teacher/teacherHomework.jsp").forward(request,
					response);
		}else if(mid ==5){
			//删除发布的作业文件
			int id = Integer.parseInt(request.getParameter("id"));
			ReleasehomeworkService rhs = new ReleasehomeworkServiceImpl ();
			Releasehomework rh= (Releasehomework)rhs.getReleasehomeworkById(id);
			
			rhs.delReleasehomework(id);
			//删除文件
			
			String baseUrl = getServletContext().getRealPath("/");
		    //String url = "D:\\software\\apache-tomcat-7.0.59\\webapps\\forum\\"+rh.getContent()+"\\"+rh.getTitle();
			String url = baseUrl+rh.getContent()+"\\"+rh.getTitle();
			
			File f = new File(url); 
			if(f.exists())
			f.delete(); 
			else{
				System.out.println("===============cuowu");
			}
			
			//删除相关学生的作业文件
			String hwPath =baseUrl+"homework\\"+rh.getTitle().split("\\.")[0];
		    File hwFile = new File(hwPath);
		    String[] list = hwFile.list();
		    for(String s : list){
		    	File file = new File(hwPath+"\\"+s);
		    	file.delete();
		    }
		    hwFile.delete();
		    HandinhomeworkService handinhomeworkService = new HandinhomeworkServiceImpl();
		    handinhomeworkService.delHandinhomework(id);
			request.getRequestDispatcher("TeacherServlet?mid=4").forward(request,
					response);
		}else if(mid==6){
			//获取某次作业的全部学生上传文件
			int id = Integer.parseInt(request.getParameter("id"));
			ReleasehomeworkService rhs = new ReleasehomeworkServiceImpl ();
			Releasehomework rh= (Releasehomework)rhs.getReleasehomeworkById(id);
			String hwurl = rh.getTitle().split("\\.")[0];
			String baseUrl = getServletContext().getRealPath("/");
			String url = baseUrl+"homework"+"\\"+hwurl;
			File file = new File(url);
			if(!file.exists()){
				System.out.println("-----chucuo-------");
			}else if(file.isFile()){
				System.out.println("----wenjina---------");
			}else{
				String[] fileList = file.list();
				request.setAttribute("result", fileList);
				
				request.setAttribute("url", hwurl);
				request.getRequestDispatcher("/view.teacher/homeworkList.jsp").forward(request,
						response);
			}
		}
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
