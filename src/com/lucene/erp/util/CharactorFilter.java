package com.lucene.erp.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class CharactorFilter
 */

 /**
 * 使用注解标注过滤器
 * @WebFilter将一个实现了javax.servlet.Filte接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 */
//@WebFilter("/CharactorFilter")
@WebFilter(filterName="CharactorFilter",urlPatterns="/*",initParams={@WebInitParam(name="encoding",value="UTF-8")})
public class CharactorFilter implements Filter {

	String encoding = null;
	final String  encode = "UTF-8";
    /**
     * Default constructor. 
     */
	
	
    public CharactorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		Log.out(this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),encoding);
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		if(this.encoding != null&&!this.encoding.equals("")){
			//设置request字符编码
			request.setCharacterEncoding(this.encoding);
			//设置response字符编码
			response.setCharacterEncoding(this.encoding);
			response.setContentType("text/html;charset="+this.encoding);
		}else{
			//设置request字符编码
			request.setCharacterEncoding(encode);
			//设置response字符编码
			response.setCharacterEncoding(encode);
			response.setContentType("text/html;charset="+encode);
		}
		// pass the request along the filter chain
		//传递给下一个过滤器
		chain.doFilter(request, response);
		Log.out(this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),encoding);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//获取初始化参数
		this.encoding = fConfig.getInitParameter("encoding");
		Log.out(this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),this.encoding);
	}

}
