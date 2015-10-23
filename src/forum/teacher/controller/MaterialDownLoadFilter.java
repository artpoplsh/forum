package forum.teacher.controller;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="downloadmaterial",urlPatterns={"/uploadMaterial/*"})
public class MaterialDownLoadFilter implements Filter {
    
	private FilterConfig config;
  
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httprequest=(HttpServletRequest)request;

        String uri=httprequest.getRequestURI(); 
        uri = java.net.URLDecoder.decode(uri,"UTF-8");
        uri = uri.substring(6, uri.length());
        request.getRequestDispatcher(uri).forward(request, response);
        //chain.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config = arg0;
	}

}
