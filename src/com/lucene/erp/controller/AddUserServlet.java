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
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		int type = Integer.parseInt(request.getParameter("type"));
		String name = request.getParameter("name");
		String pwd = MD5Util.MD5(password);
		
		String name2 = request.getParameter("name2");
		
		User user = new User(username, pwd, type, name);
		UserDao userDao = new UserDaoImpl();
		boolean rs = userDao.insertUser(user);
		Map<String, String> data = new HashMap<String, String>();
		if (rs == true) { 
			data.put("result", "1");
			data.put("msg", "添加成功");
			Log.out("customer", "会员添加成功");
		}else
		{
			data.put("result", "0");
			data.put("msg", "添加失败,请重新添加");
			Log.out("customer", "添加失败");
		}//判断是否添加成功parent.location='index.jsp'
		JSONObject result = new JSONObject(data);
		response.getWriter().write(result.toString());
		
	}

}
