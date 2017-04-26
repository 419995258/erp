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

import com.lucene.erp.domain.Export;
import com.lucene.erp.service.ExportService;
import com.lucene.erp.service.impl.ExportServiceImpl;
import com.lucene.erp.util.Log;


/**
 * 出库管理页面数据分页显示servlet
 * @author Houzw
 *
 */
@WebServlet("/PreShowGarage_manageServlet")
public class PreShowGarage_manageServlet extends PageServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreShowGarage_manageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 初始化分页数据
		this.pageInit(request, response);
		long startT = System.currentTimeMillis(); // 获取开始时间
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");// 防止乱码

		List<Export> exportList = new ArrayList<Export>();
		ExportService exportService = new ExportServiceImpl();

		Map<String, Object> searchItem = new HashMap<String, Object>();
		// 2. 获取搜索字段
		
		
		// 3. 调用服务获取分页显示的数据
		exportList = exportService.getPagingList(start, number, searchItem);
		
		// 4. 获取数据的条数
		int count = exportService.getCount(searchItem);

		/**
		 * 5. 关键步骤   按照此键值对方式处理数据，数据转json后输出到视图界面
		 */
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", count);
		jsonMap.put("rows", exportList);
		JSONObject result = new JSONObject(jsonMap);
		Log.out("member",result.isNull("total"));
		Log.out("member",result.isNull("rows"));
		response.getWriter().write(result.toString());
		
		long endT = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endT - startT) + "ms");

	}

}
