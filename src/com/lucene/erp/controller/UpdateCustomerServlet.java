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
import com.lucene.erp.service.CustomerService;
import com.lucene.erp.service.impl.CustomerServiceImpl;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
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
		Log.out("customer", "id是："+id);
		//对date生日数据进行处理
		Date date = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = request.getParameter("birthday");
		Log.out("customer", "输入的birthday是："+request.getParameter("birthday"));
		//int cid = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Date birthday =date;
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		double saleAmount = Double.parseDouble(request.getParameter("saleAmount"));
		String record = request.getParameter("record");
		String note = request.getParameter("note");
		
		try {
			 date = sim.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.out("customer", "cid是:"+id);
		Log.out("customer", "name是:"+name);
		Log.out("customer", "tel是:"+tel);
		Log.out("customer", "birthday是:"+birthday);
		Log.out("customer", "address是:"+address);
		Log.out("customer", "email是:"+email);
		Log.out("customer", "saleAmount是:"+saleAmount);
		Log.out("customer", "record是:"+record);
		Log.out("customer", "note是:"+note);
		Customer customer = new Customer(id, name, tel, birthday, address, email, saleAmount, record, note);
		CustomerService customerService = new CustomerServiceImpl();
		int affectRows = customerService.updateCustomerById(customer);
		Map<String, String> data = new HashMap<String, String>();
		if (affectRows != -1) {
			data.put("result", "1");
			data.put("msg", "会员更新成功");
			Log.out("customer", "会员更新成功");
		}else
		{
			data.put("result", "0");
			data.put("msg", "会员更新失败,请重新更新");
			Log.out("customer", "会员更新失败");
		}
		JSONObject result = new JSONObject(data);
		response.getWriter().write(result.toString());
	}

}
