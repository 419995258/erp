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

import com.lucene.erp.domain.Product;
import com.lucene.erp.service.ProductService;
import com.lucene.erp.service.impl.ProductServiceImpl;


/**
 * 获取指定商品
 * @author Houzw
 *
 */
@WebServlet("/GetProductServlet")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ")
		// .append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");// 防止乱码
		ProductService productService = new ProductServiceImpl();
		// productList = productService.findAllProducts();
		
		String idStr = request.getParameter("id"); //id
		int id = Integer.parseInt(idStr);
		
		Product product = productService.getProductById(id);

		
		JSONObject result = new JSONObject(product);
		response.getWriter().write(result.toString());
		
//		long endT = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("程序运行时间： " + (endT - startT) + "ms");
		// request.getSession().setAttribute("productList", productList);
		// Log.out("product", "PreShowProduct_manageServlet已经查询");
		// response.sendRedirect("product/product_manage.jsp");

	}

}
