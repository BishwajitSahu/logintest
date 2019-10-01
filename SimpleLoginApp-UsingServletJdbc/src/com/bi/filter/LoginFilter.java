package com.bi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    public LoginFilter() {
   
    }

	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginFilter.doFilter()");
		
		HttpSession ses=((HttpServletRequest)request).getSession();
		if(((boolean)ses.getAttribute("user_status"))==false) {
			RequestDispatcher rd=request.getRequestDispatcher("/login");
			rd.forward(request, response);
		}else {
			chain.doFilter(request, response);
		}	
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

 
