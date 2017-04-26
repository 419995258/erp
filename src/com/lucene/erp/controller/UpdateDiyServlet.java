package com.lucene.erp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.lucene.erp.domain.Customer;
import com.lucene.erp.domain.Sale;
import com.lucene.erp.service.CustomerService;
import com.lucene.erp.service.SaleService;
import com.lucene.erp.service.impl.CustomerServiceImpl;
import com.lucene.erp.service.impl.SaleServiceImpl;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class UpdateDiyServlet
 */
@WebServlet("/UpdateDiyServlet")
public class UpdateDiyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDiyServlet() {
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
		

		
		int id = Integer.parseInt(request.getParameter("id"));
		Log.out("sale", "id是："+id);
		//对date生日数据进行处理
		Date date1 = new Date();
		Date date2 = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String dateStr1 = request.getParameter("diyDate");
		Log.out("sale", "输入的diyDate是："+request.getParameter("diyDate"));
		String dateStr2 = request.getParameter("deliverDate");
		Log.out("sale", "输入的deliverDate是："+request.getParameter("deliverDate"));
		//int cid = Integer.parseInt(request.getParameter("cid"));
		String diyNum = request.getParameter("diyNum");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Date diyDate =date1;
		Date deliverDate =date2;
		double retaPrice = Double.parseDouble(request.getParameter("retaPrice"));
		double deposit = Double.parseDouble(request.getParameter("deposit"));
		double billing = Double.parseDouble(request.getParameter("billing"));
		String cashier = request.getParameter("cashier");
		String diyConsultant = request.getParameter("diyConsultant");
		String note = request.getParameter("note");
		
		try {
			 date1 = sim.parse(dateStr1);
			 date2 = sim.parse(dateStr2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sale sale = new Sale(id, diyNum, diyDate, deliverDate, quantity, retaPrice, deposit, billing, cashier, diyConsultant, note);
		SaleService saleService = new SaleServiceImpl();
		int affectRows = saleService.updateDiyById(sale);
		Map<String, String> data = new HashMap<String, String>();
		if (affectRows != -1) {
			data.put("result", "1");
			data.put("msg", "diy更新成功");
			Log.out("customer", "diy更新成功");
		}else
		{
			data.put("result", "0");
			data.put("msg", "diy更新失败,请重新更新");
			Log.out("customer", "diy更新失败");
		}
		JSONObject result = new JSONObject(data);
		response.getWriter().write(result.toString());
		
	}

}
