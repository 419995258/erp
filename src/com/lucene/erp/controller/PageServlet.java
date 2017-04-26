package com.lucene.erp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 分页Servlet父类
 * @author Houzw
 *
 */
public class PageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String page;
	protected String rows;
	protected int intPage;
	protected int number;
	protected int start;
	
	/**
	 * 初始化分页数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 */
	public void pageInit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		page = request.getParameter("page"); //当前第几页
		rows = request.getParameter("rows"); //每页显示的记录数
		// 当前页
		intPage = Integer.parseInt((page == null || page == "0") ? "1": page);
		// 每页显示条数
		number = Integer.parseInt((rows == null || rows == "0") ? "10": rows);
		// 每页的开始记录 第一页为1 第二页为number +1
		start = (intPage - 1) * number;
		
	}
}
