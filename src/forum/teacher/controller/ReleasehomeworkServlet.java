package forum.teacher.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import forum.global.domain.Releasehomework;
import forum.global.service.ReleasehomeworkService;
import forum.global.service.ReleasehomeworkServiceImpl;

@WebServlet(name = "releasehomework",urlPatterns={"/teacher/releasehomework"})
public class ReleasehomeworkServlet extends HttpServlet {
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           try {
			
        	 Releasehomework rhw = new Releasehomework();
			// 1. 鍒涘缓鏂囦欢涓婁紶宸ュ巶绫�
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// a. 璁剧疆涓存椂鐩綍
			File file_temp = new File(getServletContext().getRealPath("/temp"));
			factory.setRepository(file_temp);
			
			// 2. servlet鏂囦欢涓婁紶鏍稿績澶勭悊绫�
			ServletFileUpload upload = new ServletFileUpload();
			// a. 璁剧疆宸ュ巶瀵硅薄
			upload.setFileItemFactory(factory);
			// b. 璁剧疆鏂囦欢鍚嶇紪鐮�(鐩稿綋浜巖equest缂栫爜璁剧疆)
			upload.setHeaderEncoding("UTF-8");
			// c. 璁剧疆鍗曚釜鏂囦欢澶у皬
			upload.setFileSizeMax(10*1024*1024);
			// d. 璁剧疆鎬绘枃浠跺ぇ灏�
			upload.setSizeMax(50*1024*1024);
			
			// 鍒ゆ柇锛�鏄惁涓烘枃浠朵笂浼犺〃鍗� 鍗虫槸鍚︽寚瀹氾細 enctype="multipart/form-data"
			// 濡傛灉鎸囧畾锛岃繑鍥瀟rue
			//Boolean a=upload.isMultipartContent(request);
			if (ServletFileUpload.isMultipartContent(request)){
				
				// 3. 鎶婅姹傝浆鎹负灏佽浜咶ileItem鐨凩ist闆嗗悎
				List<FileItem> items = upload.parseRequest(request);
				// 瑕佸皝瑁呯殑瀵硅薄
				//User user = new User();
				// 閬嶅巻
				for (FileItem item : items){
					
					// 鍒ゆ柇锛�鏄惁涓烘櫘閫氳〃鍗曢」杩樻槸鏂囦欢涓婁紶琛ㄥ崟椤�
					if (item.isFormField()) {
						// 鏅�琛ㄥ崟椤�
						//---> 琛ㄥ崟鍏冪礌鍚嶇О (瀵硅薄灞炴�鍚嶇О) 銆�input type="text" name="userName"> 銆�
						/*String fieldName = item.getFieldName();
						//----> 鍚嶇О锛屽搴旂殑鍊�
						String value = item.getString("UTF-8");
						// BeanUtils缁勪欢璁剧疆鍊�
						BeanUtils.copyProperty(user, fieldName, value);*/
						String fieldName = item.getFieldName();
						if(fieldName.equals("deadline")){
							rhw.setDeadline(item.getString("UTF-8"));
						}
						
					}
					
					else {
						// 鏂囦欢涓婁紶琛ㄥ崟椤�
						// 鑾峰彇鏂囦欢鍚�
						String fileName = item.getName();
						// 鐢熸垚UUID
						// String uuid = UUID.randomUUID().toString();
						// 鍏ㄧ悆鍞竴鏂囦欢鍚�
						String fullName =fileName;
						
						// 鑾峰彇涓婁紶鐩綍
						String bathPath = getServletContext().getRealPath("/uploadMaterial");
						//鑾峰彇浣滀笟鐩綍
						String homeworkPath = getServletContext().getRealPath("/homework");
						// 鏂囦欢瀵硅薄 (浠�闅斿紑uuid涓庢枃浠跺悕)
						File file = new File(bathPath,fullName);
						// 涓婁紶
						item.write(file);
						// 鍒犻櫎涓存椂鏂囦欢+
						item.delete();
						
						//鍒涘缓浣滀笟鐩綍
						
						String[] sub = fullName.split("\\.");
						
						File hwFile = new File(homeworkPath,sub[0]);
						if(hwFile.mkdir()){
							System.out.println("chuangjiangchenggong");
						}
						//---------db----------
						
						rhw.setTitle(fileName);
						//material.setHyperlinkaddress("uploadMaterial/"+fullName);
						rhw.setContent("uploadMaterial");
						
						//material.setTeacherid("uu");
						
						
						
						// 璺宠浆
						
					}
				}
				//淇濆瓨鍒版暟鎹簱
				Date releasedate = new Date();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String release =null;
				try  
				{   
				     release = sdf.format(releasedate); 
				}  
				catch (Exception e)  
				{  
				    System.out.println(e.getMessage());  
				}  
				
				rhw.setReleasedate(release);
				rhw.setTeacherid((String)request.getSession().getAttribute("id"));
				ReleasehomeworkService rhws = new ReleasehomeworkServiceImpl();
				rhws.addReleasehomework(rhw);
				request.getRequestDispatcher("releasehomeRes?rid=1").forward(
						request, response);
				System.out.println("ok,,,,");
				
				
			} else {
				request.setAttribute("message", "鏂囦欢涓婁紶澶辫触锛岃妫�煡鏂囦欢琛ㄥ崟锛�");
				System.out.println(",,,,");
			}
		} catch (Exception e) {
			System.out.println(",");
			request.setAttribute("message", "鏂囦欢涓婁紶Sevrlet澶勭悊澶辫触锛岃鑱旂郴绠＄悊鍛橈紒");
			e.printStackTrace();
		}
		
		// 璺宠浆
		
		    }  

	
	
	
	public ReleasehomeworkServlet() {
		super();
	}
	
   public void init() throws ServletException {
		
	}
   
   public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
}
