package com.lucene.erp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.lucene.erp.dao.UserDao;
import com.lucene.erp.dao.impl.UserDaoImpl;
import com.lucene.erp.domain.Product;
import com.lucene.erp.domain.User;
import com.lucene.erp.service.ProductService;
import com.lucene.erp.service.impl.ProductServiceImpl;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class PreShowUserServlet
 */
@WebServlet("/PreShowUserServlet")
public class PreShowUserServlet extends PageServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreShowUserServlet() {
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
		long startT = System.currentTimeMillis(); // 获取开始时间
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");// 防止乱码

		UserDao userDao = new UserDaoImpl();
		List<User> userList = new ArrayList<User>();
		Map<String, Object> searchItem = new HashMap<String, Object>();
		// 2. 获取搜索字段
		/*
		 * String spid = request.getParameter("spid"); String sleader =
		 * request.getParameter("sleader"); if (spid != null && !spid.isEmpty())
		 * searchItem.put("pid", spid); if (sleader != null &&
		 * !sleader.isEmpty()) searchItem.put("leader", sleader);
		 */
		// 3. 调用服务获取分页显示的数据
		userList = userDao.getPagingList(start, number, searchItem);
		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			switch (user.getType()) {
			case 1:
				user.setTypeName("超级管理员");
				break;
			case 2:
				user.setTypeName("管理员");
				break;
			case 3:
				user.setTypeName("店铺");
				break;
			}
			
			switch (user.getStatus()){
			case 1:
				user.setStatusName("启用");
				break;
			case 0:
				user.setStatusName("禁用");
				break;
			

			}
		}
		// 4. 获取数据的条数
		int count = 0;
		try {
			count = userDao.getCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * 5. 关键步骤 按照此键值对方式处理数据，数据转json后输出到视图界面
		 */
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", count);
		jsonMap.put("rows", userList);
		JSONObject result = new JSONObject(jsonMap);
		Log.out("member", result.isNull("total"));
		Log.out("member", result.isNull("rows"));
		response.getWriter().write(result.toString());

		long endT = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endT - startT) + "ms");

	}

}
