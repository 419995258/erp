package com.lucene.erp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.lucene.erp.domain.Customer;
import com.lucene.erp.service.CustomerService;
import com.lucene.erp.service.impl.CustomerServiceImpl;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class PreSelectCustomerServlet
 */
@WebServlet("/PreShowMember_queryServlet")
public class PreShowMember_queryServlet extends PageServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreShowMember_queryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 初始化分页数据
		this.pageInit(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");// 防止乱码

		List<Customer> customerList = new ArrayList<Customer>();
		CustomerService customerService = new CustomerServiceImpl();
		// customerList = customerService.findAllCustomer();
		Map<String, Object> searchItem = new HashMap<String, Object>();
		// 获取搜索字段
		/*
		 * String spid = request.getParameter("spid"); String sleader =
		 * request.getParameter("sleader"); if (spid != null && !spid.isEmpty())
		 * searchItem.put("pid", spid); if (sleader != null &&
		 * !sleader.isEmpty()) searchItem.put("leader", sleader);
		 */
		/*
		 * String page = request.getParameter("page"); //当前第几页 String rows =
		 * request.getParameter("rows"); //每页显示的记录数 // 当前页 int intPage =
		 * Integer.parseInt((page == null || page == "0") ? "1": page); //
		 * 每页显示条数 int number = Integer.parseInt((rows == null || rows == "0") ?
		 * "10": rows); // 每页的开始记录 第一页为1 第二页为number +1 int start = (intPage - 1)
		 * * number;
		 */
		customerList = customerService.getPagingList(start, number, searchItem);
		int count = customerService.getCount(searchItem);
		Log.out("member", "count:" + count);
		Log.out("member", "customerList:" + customerList.size());
		/**
		 * 
		 * 关键步骤
		 */
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", count);
		jsonMap.put("rows", customerList);
		JSONObject result = new JSONObject(jsonMap);
		Log.out("member", result.isNull("total"));
		Log.out("member", result.isNull("rows"));

		response.getWriter().write(result.toString());
		Log.out("member", "all is ok");
		/*
		 * request.getSession().setAttribute("customerList", customerList);
		 * Log.out("customer", "PreShowMember_manageServlet已经查询");
		 * response.sendRedirect("member/member_manage.jsp");
		 */
	}

}
