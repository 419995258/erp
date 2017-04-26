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

import com.lucene.erp.dao.SaleDao;
import com.lucene.erp.dao.impl.SaleDaoImpl;
import com.lucene.erp.domain.Traffic;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class PreShowTrafficManageServlet
 */
@WebServlet("/PreShowTrafficManageServlet")
public class PreShowTrafficManageServlet extends PageServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreShowTrafficManageServlet() {
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
		this.pageInit(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");// 防止乱码

		List<Traffic> trafficList = new ArrayList<>();
		SaleDao saleDao = new SaleDaoImpl();

		Map<String, Object> searchItem = new HashMap<String, Object>();
		// 2. 获取搜索字段
		String userName = request.getParameter("userName");

		if (userName != null && !userName.isEmpty())
			searchItem.put("user_name", "%" + userName + "%");
		int count = saleDao.getTrafficOrderCount();
		trafficList = saleDao.getTrafficPagingListOrder(start, number, searchItem);
		/**
		 * 
		 * 关键步骤
		 */
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", count);
		jsonMap.put("rows", trafficList);
		JSONObject result = new JSONObject(jsonMap);
		Log.out("member", result.isNull("total"));
		Log.out("member", result.isNull("rows"));

		response.getWriter().write(result.toString());
		Log.out("member", "all is ok");

	}

}
