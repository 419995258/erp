package com.lucene.erp.controller;

import java.io.IOException;
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
 * Servlet implementation class UpdateCustomerServiceServlet
 */
@WebServlet("/UpdateCustomerServiceServlet")
public class UpdateCustomerServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServiceServlet() {
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
		String firService = request.getParameter("firService");
		String secService = request.getParameter("secService");
		String thrService = request.getParameter("thrService");
		String fouService = request.getParameter("fouService");
		String serviceLeader = request.getParameter("serviceLeader");
		String note = request.getParameter("note");
		Customer customer = new Customer(id, note, firService, secService, thrService, fouService, serviceLeader);
		CustomerService customerService = new CustomerServiceImpl();
		int affectRows = customerService.updateCustomerServiceById(customer);
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
