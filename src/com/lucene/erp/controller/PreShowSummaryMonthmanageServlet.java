package com.lucene.erp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.lucene.erp.dao.StatisticDao;
import com.lucene.erp.dao.impl.StatisticDaoImpl;
import com.lucene.erp.domain.Statistic;
import com.lucene.erp.domain.User;
import com.lucene.erp.util.DateUtil;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class PreShowSummaryMonthmanageServlet
 */
@WebServlet("/PreShowSummaryMonthmanageServlet")
public class PreShowSummaryMonthmanageServlet extends PageServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreShowSummaryMonthmanageServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.pageInit(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");// 防止乱码

		
		
		StatisticDao statisticDao = new StatisticDaoImpl();
		
		List<User> userList = new ArrayList<>();
		userList = statisticDao.getAllUser();
		// 2. 获取搜索字段
		Date Date = new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");//设置转化格式
		System.out.println(request.getParameter("diyDate"));
		if("" != request.getParameter("diyDate") && null != request.getParameter("diyDate")){
			Date = DateUtil.fomatDate(request.getParameter("diyDate"));
		}
		String diyDate = "'"+sf.format(Date)+"'";
		
		//
		List<Statistic> statisticList = new ArrayList<>();
		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			Map<String, Object> searchItem = new HashMap<String, Object>();
			searchItem.put("t.user_id", user.getId());
			if (diyDate != null && !diyDate.isEmpty()){
				searchItem.put("DATE_FORMAT(t.diyDate,'%Y-%m')", diyDate);
			}
			Statistic statistic = new Statistic();
			statistic = statisticDao.getMonthPagingList(start, number, diyDate,searchItem);
			if(statistic.getUserId() != 0){
				statisticList.add(statistic);
			}
		}
		
		/**
		 * 
		 * 关键步骤
		 */
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", statisticList.size());
		jsonMap.put("rows", statisticList);
		JSONObject result = new JSONObject(jsonMap);
		Log.out("member", result.isNull("total"));
		Log.out("member", result.isNull("rows"));

		response.getWriter().write(result.toString());
		Log.out("member", "all is ok");
	}

}
