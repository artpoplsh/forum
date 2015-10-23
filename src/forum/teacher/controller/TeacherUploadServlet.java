package forum.teacher.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import forum.global.domain.Material;
import forum.global.service.MaterialService;


public class TeacherUploadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	
	public TeacherUploadServlet() {
		super();
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
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
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			Material material = new Material();
			// 1. 创建文件上传工厂类
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// a. 设置临时目录
			File file_temp = new File(getServletContext().getRealPath("/temp"));
			factory.setRepository(file_temp);
			
			// 2. servlet文件上传核心处理类
			ServletFileUpload upload = new ServletFileUpload();
			// a. 设置工厂对象
			upload.setFileItemFactory(factory);
			// b. 设置文件名编码 (相当于request编码设置)
			upload.setHeaderEncoding("UTF-8");
			// c. 设置单个文件大小
			upload.setFileSizeMax(10*1024*1024);
			// d. 设置总文件大小
			upload.setSizeMax(50*1024*1024);
			
			// 判断： 是否为文件上传表单, 即是否指定： enctype="multipart/form-data"
			// 如果指定，返回true
			//Boolean a=upload.isMultipartContent(request);
			if (ServletFileUpload.isMultipartContent(request)){
				
				// 3. 把请求转换为封装了FileItem的List集合
				List<FileItem> items = upload.parseRequest(request);
				// 要封装的对象
				//User user = new User();
				// 遍历
				for (FileItem item : items){
					
					// 判断： 是否为普通表单项还是文件上传表单项
					if (item.isFormField()) {
						// 普通表单项
						//---> 表单元素名称 (对象属性名称) 【<input type="text" name="userName"> 】
						/*String fieldName = item.getFieldName();
						//----> 名称，对应的值
						String value = item.getString("UTF-8");
						// BeanUtils组件设置值
						BeanUtils.copyProperty(user, fieldName, value);*/
						
						String value = item.getString("UTF-8");
						material.setDescription(value);
						
						
					}
					
					else {
						// 文件上传表单项
						// 获取文件名
						String fileName = item.getName();
						// 生成UUID
						//String uuid = UUID.randomUUID().toString();
						// 全球唯一文件名
						String fullName =fileName;
						
						// 获取上传目录
						String bathPath = getServletContext().getRealPath("/uploadMaterial");
						// 文件对象 (以#隔开uuid与文件名)
						File file = new File(bathPath,fullName);
						// 上传
						item.write(file);
						// 删除临时文件+
						item.delete();
						
						//---------db----------
						
						material.setTitle(fileName);
						material.setHyperlinkaddress("uploadMaterial/"+fullName);
						
						
						material.setTeacherid((String)request.getSession().getAttribute("teacherid"));
						
						
						//user.setFileName(fileName);  // 设置文件名
						//user.setFullName(fullName);  // 设置文件，全名
						// dao 实例
						//UserDao userDao = new UserDao();
						// 保存到数据库
						//userDao.save(user);
						// 跳转
						request.getRequestDispatcher("uploadRes?rid=1").forward(
								request, response);
						System.out.println("ok,,,,");
					}
				}
				MaterialService ms = new MaterialService();
				
				ms.addMaterial(material);
			} else {
				request.setAttribute("message", "文件上传失败，请检查文件表单！");
				System.out.println(",,,,");
			}
		} catch (Exception e) {
			System.out.println(",");
			request.setAttribute("message", "文件上传Sevrlet处理失败，请联系管理员！");
			e.printStackTrace();
		}
		
		// 跳转
		
		    }  

	
	
}
