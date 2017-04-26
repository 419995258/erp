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
 * Servlet implementation class PreShowMember_manageServlet
 */
@WebServlet("/PreShowMember_manageServlet")
public class PreShowMember_manageServlet extends PageServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreShowMember_manageServlet() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
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

		// 2. 获取搜索字段
		String scid = request.getParameter("scid");
		String sname = request.getParameter("sname");
		String stel = request.getParameter("stel");
		if (scid != null && !scid.isEmpty())
			searchItem.put("id", "%"+scid+"%");
		if (sname != null && !sname.isEmpty())
			searchItem.put("name", "%"+sname+"%");
		if (stel != null && !stel.isEmpty())
			searchItem.put("tel", "%"+stel+"%");

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
