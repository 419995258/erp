package com.lucene.erp.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.lucene.erp.dao.SaleDao;
import com.lucene.erp.dao.impl.SaleDaoImpl;
import com.lucene.erp.domain.Inventory;
import com.lucene.erp.domain.Traffic;
import com.lucene.erp.domain.User;
import com.lucene.erp.util.DateUtil;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class AddCheckServlet
 */
@WebServlet("/AddCheckServlet")
public class AddCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCheckServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");// 防止乱码
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String superPlatPeople = request.getParameter("superPlatPeople");
		String inventoryPeople = request.getParameter("inventoryPeople");
		Date inventoryTime = DateUtil.fomatDate(request.getParameter("inventoryTime"));
		int inventoryStock = Integer.parseInt(request.getParameter("inventoryStock"));
		String note = request.getParameter("note");
		
		Inventory inventory = new Inventory(pid, superPlatPeople, inventoryPeople, inventoryTime, inventoryStock, note);
		SaleDao saleDao = new SaleDaoImpl();
		int rs = saleDao.insertCheck(inventory);
		Map<String, String> data = new HashMap<String, String>();
		if (rs >0) { 
			data.put("result", "1");
			data.put("msg", "添加成功");
			Log.out("customer", "盘点添加成功");
			
		}else
		{
			data.put("result", "0");
			data.put("msg", "添加失败,请重新添加");
			Log.out("customer", "添加失败");
		}//判断是否添加成功parent.location='index.jsp'
		JSONObject result = new JSONObject(data);
		response.getWriter().write(result.toString());
	}

}
