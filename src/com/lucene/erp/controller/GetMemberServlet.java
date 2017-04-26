package com.lucene.erp.controller;

import java.io.IOException;
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
 * Servlet implementation class GetMemberServlet
 */
@WebServlet("/GetMemberServlet")
public class GetMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMemberServlet() {
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
		CustomerService customerService = new CustomerServiceImpl();
		String idStr = request.getParameter("id"); //id
		int id = Integer.parseInt(idStr);
		Log.out("member", id);
		Customer customer = customerService.getCustomerById(id);
		Log.out("member", customer.getAddress());
		JSONObject result = new JSONObject(customer);
		response.getWriter().write(result.toString());
		Log.out("member", "all is ok");
	}

}
