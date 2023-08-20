package com.filters;
import java.util.regex.*;    
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EmailValidationFilter
 */
public class EmailValidationFilter extends HttpFilter implements Filter {
       


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String email = request.getParameter("email");
        String regex = "^(.+)@(.+)$";  
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(email);  
        
        if(matcher.matches())
		// pass the request along the filter chain
		chain.doFilter(request, response);
        
        else {
        	request.setAttribute("emailNotValid", "True");
			RequestDispatcher dispatch = request.getRequestDispatcher("register.jsp");
			dispatch.forward(request, response);
        }	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
