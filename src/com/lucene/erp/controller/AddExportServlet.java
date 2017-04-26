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

import org.json.JSONObject;

import com.lucene.erp.dao.ExportDao;
import com.lucene.erp.dao.impl.ExportDaoImpl;
import com.lucene.erp.domain.Export;
import com.lucene.erp.util.DateUtil;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class AddExportServlet
 */
@WebServlet("/AddExportServlet")
public class AddExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExportServlet() {
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
		
		try{
		String barCode = request.getParameter("barCode");
		String receiveDept = request.getParameter("receiveDept");
		String receiver = request.getParameter("receiver");
		Date receiveTime = DateUtil.fomatDate(request.getParameter("receiveTime"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double retaPrice = Double.parseDouble(request.getParameter("retaPrice"));
		String note = request.getParameter("note");
		int pid = Integer.parseInt(request.getParameter("pid"));
		Export export = new Export(barCode, receiveDept, receiver, receiveTime, quantity, retaPrice, note, pid);
		ExportDao exportDaoImpl = new ExportDaoImpl();
		boolean rs = exportDaoImpl.insertExport(export);
		
		Map<String, String> data = new HashMap<String, String>();
		if (rs == true) { 
			data.put("result", "1");
			data.put("msg", "添加成功");
			Log.out("customer", "出库添加成功");
			int num = exportDaoImpl.selectProductNum(pid);
			exportDaoImpl.updateProductNum(num - quantity, pid);
			
		}else
		{
			data.put("result", "0");
			data.put("msg", "添加失败,请重新添加");
			Log.out("customer", "添加失败");
		}//判断是否添加成功parent.location='index.jsp'
		JSONObject result = new JSONObject(data);
		response.getWriter().write(result.toString());
		}catch(Exception e){
			Log.out("error", e);
			Map<String, String> data = new HashMap<String, String>();
			data.put("result", "0");
			data.put("msg", "添加失败,请刷新页面重新添加");
			JSONObject result = new JSONObject(data);
			response.getWriter().write(result.toString());
		}
		
		}
	

}
