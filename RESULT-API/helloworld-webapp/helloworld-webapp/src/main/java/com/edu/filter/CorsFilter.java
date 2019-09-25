package com.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解决跨域过滤器
* @author  
* @date 2019年4月27日
 */
public class CorsFilter implements Filter {
    
	/**
     * Default constructor. 
     */
    public CorsFilter() {
 
        // TODO Auto-generated constructor stub
    }
 
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
 
		// pass the request along the filter chain
 
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
 
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
 
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "User-Agent,Origin,Cache-Control,Content-type,Date,Server,withCredentials,AccessToken");
 
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
 
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
 
        httpServletResponse.setHeader("Access-Control-Max-Age", "1209600");
 
        httpServletResponse.setHeader("Access-Control-Expose-Headers","accesstoken");
 
        httpServletResponse.setHeader("Access-Control-Request-Headers","accesstoken");
 
        httpServletResponse.setHeader("Expires","-1");
 
        httpServletResponse.setHeader("Cache-Control","no-cache");
 
        httpServletResponse.setHeader("pragma","no-cache");
 
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
 
		if(!"OPTIONS".equals(httpServletRequest.getMethod())){//OPTIONS方法不要拦截，不然跨域设置不成功
	        
	 
		}
 
		chain.doFilter(request, response);
 
	}
 
	/**
	 * @see Filter#init(FilterConfig)
	 */
 
	public void init(FilterConfig fConfig) throws ServletException {
 
		// TODO Auto-generated method stub
 
	}
}
