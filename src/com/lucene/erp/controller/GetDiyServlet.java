package com.lucene.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.lucene.erp.domain.Sale;
import com.lucene.erp.service.SaleService;
import com.lucene.erp.service.impl.SaleServiceImpl;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class GetDiyServlet
 */
@WebServlet("/GetDiyServlet")
public class GetDiyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDiyServlet() {
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
		Log.out("sale", ">>>>>>>>>>>");
		SaleService saleService = new SaleServiceImpl();
		String idStr = request.getParameter("id"); //id
		int id = Integer.parseInt(idStr);
		Log.out("sale", id);
		Sale sale = saleService.getSaleById(id);
		Log.out("sale", "sale.quantiy" + sale.getQuantity());
		JSONObject result = new JSONObject(sale);
		response.getWriter().write(result.toString());
		Log.out("sale", "all is ok");
	}

}
