package forum.student.controller;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.naming.SizeLimitExceededException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import forum.global.domain.Handinhomework;
import forum.global.domain.Releasehomework;
import forum.global.service.HandinhomeworkService;
import forum.global.service.HandinhomeworkServiceImpl;
import forum.global.service.ReleasehomeworkService;
import forum.global.service.ReleasehomeworkServiceImpl;

public class StudentUploadServlet extends HttpServlet
{  
	/**
	 * Constructor of the object.
	 */
	public StudentUploadServlet() {
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
		
		HandinhomeworkService handinhomeworkService = new HandinhomeworkServiceImpl();
		String dirName = new String(request.getParameter("dirName").getBytes("iso8859-1"),"UTF-8");
		//��������Ƿ���һ���ϴ��?(������post���󣬺�enctype=��multipart/form-date��)         
        Boolean isMultipart=ServletFileUpload.isMultipartContent(request);      
        if(isMultipart)  
        {  
            //����һ����ʱ�ļ����Ҫ�ϴ����ļ�����һ���������ϴ��ļ���С���ڶ��������Ǵ�ŵ���ʱĿ¼  
            DiskFileItemFactory factory=new DiskFileItemFactory(1024*1024*5,new File("/temp"));
            //����һ���ļ��ϴ��ľ��  
            ServletFileUpload upload=new ServletFileUpload(factory);           
            //�����ļ��ϴ��������С���ϴ��ĵ����ļ���С  
            upload.setSizeMax(1024*1024*50);  
            upload.setFileSizeMax(1024*1024*5);  
              
            try {        
                //��ҳ��?��ÿһ���?Ԫ������һ��Fileitem  
                List<FileItem> items=upload.parseRequest(request);  
                for(FileItem fileItem:items)  
                {  
                    //�����һ����ͨ�ı?Ԫ�أ�type����files�ı?Ԫ�أ�  
                    if(fileItem.isFormField())  
                    {  
                        //System.out.println(fileItem.getFieldName()); //�õ���Ӧ�?Ԫ�ص�����  
                        System.out.println(fileItem.getString());//�õ��?Ԫ�ص�ֵ   
                    }  
                    else   
                    {  
                        //��ȡ�ļ��ĺ�׺��  
                        String filename=fileItem.getName();//�õ��ļ���  
                        String fileExt=filename.substring(filename.lastIndexOf(".")+1, filename.length());   
                        
                        try {    
                        	File f = new File(getServletContext().getRealPath("/homework/"+dirName) + "/");
                        	f.mkdir();
                        	//���ļ��ϴ���homeworkĿ¼������  ,getreadplth���Եõ���Ŀ¼�°�/homework�ľ��·��  
                            fileItem.write(new File(getServletContext().getRealPath("/homework/"+dirName) + "/" + filename));  
                            //System.out.println("���ļ��ϴ��ɹ�����");
                            //�ϴ���ҵ��Ϣ��handinhomework��
                            HttpSession session = request.getSession(true);
                            String studentid = (String)session.getAttribute("studentid");
                            Handinhomework handinhomework = new Handinhomework();
                            //handinhomework.setId("");
                            handinhomework.setMark(0);
                            Releasehomework rhw = new Releasehomework();
                            ReleasehomeworkService rhws = new ReleasehomeworkServiceImpl();
                            rhw = rhws.getReleasehomeworkByTitle(dirName);
                            handinhomework.setReleasehomeworkid(rhw.getId());
                            handinhomework.setStudentid(studentid);
                            handinhomework.setAddress("homework/"+dirName + "/" + filename);
                            handinhomeworkService.addHandinhomework(handinhomework);
                            
                            response.setContentType("text/html;charset=UTF-8");
                            response.setCharacterEncoding("UTF-8");
                            PrintWriter myout = response.getWriter();
                            myout.println("<script>alert('提交成功');window.location.assign('./view.student/studentUpload.jsp?dirName="+ dirName +"');</script>");
                            
                        } catch (Exception e) {  
                                // TODO: handle exception
                                e.printStackTrace(); 
                                System.out.println("提交失败");
                                response.setContentType("text/html;charset=UTF-8");
                                response.setCharacterEncoding("UTF-8");
                                PrintWriter myout = response.getWriter();
                                myout.println("<script>alert('�ϴ�ʧ�ܣ��������ϴ���');window.location.assign('./view.student/studentUpload.jsp?dirName="+ dirName +"');</script>");
                                
                        } 
                    }  
                }  
                  
            }    
            catch (FileSizeLimitExceededException e)  
            {  
                System.out.println("������һ���ϴ��ļ��Ĵ�С�����˹涨�Ĵ�С...");  
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                PrintWriter myout = response.getWriter();
                myout.println("<script>alert('�ϴ��ļ��Ĵ�С�����˹涨�Ĵ�С���ϴ�ʧ�ܣ���ѹ���ϴ���');window.location.assign('./view.student/studentUpload.jsp?dirName="+ dirName +"');</script>");
            } 
            catch(FileUploadException e)  
            {  
                e.printStackTrace();  
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
		doGet(request, response);
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
