package forum.admin.controller;


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
import javax.servlet.http.HttpSession;

@WebFilter(filterName="admin",urlPatterns={"/logicMgr"})
public class AdminFilter implements Filter {
    
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
        HttpSession session = httprequest.getSession(true);
        if(session.getAttribute("adminid")==null){
        	request.getRequestDispatcher("/").forward(httprequest, response);
        }else
        {
        	System.out.println("admidfilter");
        	chain.doFilter(httprequest, response);
        }
        //chain.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config = arg0;
	}

}
