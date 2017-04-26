package com.lucene.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucene.erp.domain.Customer;
import com.lucene.erp.service.CustomerService;
import com.lucene.erp.service.impl.CustomerServiceImpl;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class SelectCustomerServlet
 */
@WebServlet("/SelectCustomerServlet")
public class SelectCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectCustomerServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");// 防止乱码

		String id = request.getParameter("cid");
		String cname = request.getParameter("cname");
		String tel = request.getParameter("tel");
		Log.out("Customer", "输入的会员号是：" + id);
		Log.out("Customer", "输入的会员名是：" + cname);
		Log.out("Customer", "输入的会员电话是：" + tel);
		Customer customer = new Customer();
		CustomerService customerService = new CustomerServiceImpl();
		List<Customer> customerList = new ArrayList<Customer>();
		/*if (cid == "" && cname == "" && tel == "") {
			customerList = customerService.findAllCustomer();
			request.getSession().setAttribute("customerList", customerList);
		} else if (cid != "") {
			request.getSession().removeAttribute("customer");
			request.getSession().removeAttribute("customerList");
			customer = customerService.findCustomerByCID(cid);
			request.getSession().setAttribute("customer", customer);
		} else if (cname != "") {
			request.getSession().removeAttribute("customer");
			request.getSession().removeAttribute("customerList");
			customerList = customerService.findCustomerByName(cname);
			request.getSession().setAttribute("customerList", customerList);
		} else if (tel != "") {
			request.getSession().removeAttribute("customer");
			request.getSession().removeAttribute("customerList");
			customer = customerService.findCustomerByTel(tel);
			request.getSession().setAttribute("customer", customer);
		}*/
		
		customerList = customerService.findCustomerByCidTelName(id, tel, cname);
		request.getSession().setAttribute("customerList", customerList);
		Log.out("Customer", "customerList的长度为：" + customerList.size());
		Log.out("Customer", "customerList是否为空：" + customerList.isEmpty());
		
		
		response.sendRedirect("member/member_query.jsp");
	}

}
