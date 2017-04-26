package com.lucene.erp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
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

import com.lucene.erp.domain.User;
import com.lucene.erp.dao.SaleDao;
import com.lucene.erp.dao.impl.SaleDaoImpl;
import com.lucene.erp.domain.Attend;
import com.lucene.erp.util.DateUtil;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class AddAttendServlet
 */
@WebServlet("/AddAttendServlet")
public class AddAttendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAttendServlet() {
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
		try {
			String name = request.getParameter("name");
			String attendday = request.getParameter("attendday");
			String passday = request.getParameter("passday");
			String restday = request.getParameter("restday");
			String sickday = request.getParameter("sickday");
			String leaveday = request.getParameter("leaveday");
			String allday = request.getParameter("allday");
			String lateday = request.getParameter("lateday");
			String inday = request.getParameter("inday");
			String overday = request.getParameter("overday");
			String leader = request.getParameter("leader");
			String surer = request.getParameter("surer");
			String note = request.getParameter("note");

			Date nowdate = DateUtil.getCurrentDate(DateUtil.DATE_STYLE13);

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			int userId = user.getId();
			String userName = user.getName();
			Attend attend = new Attend(name, nowdate, attendday, passday, restday, sickday, leaveday, allday, lateday,
					inday, overday, leader, surer, note, userId, userName);
			SaleDao saleDao = new SaleDaoImpl();
			int rs = saleDao.insertAttend(attend);
			Map<String, String> data = new HashMap<String, String>();
			if (rs >0) { 
				data.put("result", "1");
				data.put("msg", "添加成功");
				Log.out("customer", "出库添加成功");
				
			}else
			{
				data.put("result", "0");
				data.put("msg", "添加失败,请重新添加");
				Log.out("customer", "添加失败");
			}//判断是否添加成功parent.location='index.jsp'
			JSONObject result = new JSONObject(data);
			response.getWriter().write(result.toString());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.out("error", e);
		}

	}

}
