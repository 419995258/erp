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
import com.lucene.erp.domain.Customer;
import com.lucene.erp.domain.SaleVo;
import com.lucene.erp.service.CustomerService;
import com.lucene.erp.service.impl.CustomerServiceImpl;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class PreShowOrder_manageServlet
 */
@WebServlet("/PreShowOrder_manageServlet")
public class PreShowOrder_manageServlet extends PageServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreShowOrder_manageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 初始化分页数据
				this.pageInit(request, response);
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");// 防止乱码

				
				List<SaleVo> saleVoList = new ArrayList<SaleVo>();
				Map<String, Object> searchItem = new HashMap<String, Object>();

				SaleDao saleDao = new SaleDaoImpl();
				// 2. 获取搜索字段
				String pid = request.getParameter("pid");
				String diyNum = request.getParameter("diyNum");
				String tel = request.getParameter("tel");
				if (pid != null && !pid.isEmpty())
					searchItem.put("t1.pid", "%"+pid+"%");
				if (diyNum != null && !diyNum.isEmpty())
					searchItem.put("t.diyNum", "%"+diyNum+"%");
				if (tel != null && !tel.isEmpty())
					searchItem.put("t2.tel", "%"+tel+"%");

				int count = saleDao.getSaleOrderCount();
				saleVoList = saleDao.getPagingListOrder(start, number, searchItem);
				//Log.out("member", "count:" + count);
				//Log.out("member", "customerList:" + customerList.size());
				/**
				 * 
				 * 关键步骤
				 */
				Map<String, Object> jsonMap = new HashMap<String, Object>();
				jsonMap.put("total", count);
				jsonMap.put("rows", saleVoList);
				JSONObject result = new JSONObject(jsonMap);
				Log.out("member", result.isNull("total"));
				Log.out("member", result.isNull("rows"));

				response.getWriter().write(result.toString());
				Log.out("member", "all is ok");
	}

}
