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

import com.lucene.erp.dao.UserDao;
import com.lucene.erp.dao.impl.UserDaoImpl;
import com.lucene.erp.domain.User;
import com.lucene.erp.util.Log;
import com.lucene.erp.util.MD5Util;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		String pwd = MD5Util.MD5(password);
		int status = Integer.parseInt(request.getParameter("status"));
		UserDao userDao = new UserDaoImpl();
		User user = new User(id,pwd, status, name);
		int affectRows = -1;
		try {
			affectRows = userDao.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> data = new HashMap<String, String>();
		if (affectRows != -1) {
			data.put("result", "1");
			data.put("msg", "更新成功");
			Log.out("user", "更新成功");
		}else
		{
			data.put("result", "0");
			data.put("user", "更新失败,请重新更新");
			Log.out("user", "会员更新失败");
		}
		JSONObject result = new JSONObject(data);
		response.getWriter().write(result.toString());
	}

}
