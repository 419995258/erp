package com.lucene.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lucene.erp.dao.UserDao;
import com.lucene.erp.dao.impl.UserDaoImpl;
import com.lucene.erp.domain.User;
import com.lucene.erp.service.UserService;
import com.lucene.erp.service.impl.UserServiceImpl;
import com.lucene.erp.util.Log;
import com.lucene.erp.util.MD5Util;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		PrintWriter out = response.getWriter();
		// 获取帐号密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		// 调用user
		User user2 = new User();
		user2.setUsername(username);
		user2.setPwd(MD5Util.MD5(password));
		UserDao userDao = new UserDaoImpl();
		
		User user = userDao.login(user2);
		Log.out("login", "username:" + username);
		Log.out("login", "password:" + MD5Util.MD5(password));
		Log.out("login", "remember:" + remember);
		if (user.getId()!=0) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(6*60*60);
			Cookie c = new Cookie("users", username + "#" + password);
			if ("on".equals(remember)) {

				// 设置过期时间
				c.setMaxAge(600);

				// 存储
				response.addCookie(c);
				
				
			} else {
				// 设置过期时间
				c.setMaxAge(0);
				c.setValue(null);
				// 存储
				response.addCookie(c);
			}
			
			switch (user.getType()) {
			case 1:
				out.println("<script>location.href='index.jsp'</script>");
				break;
			case 2:
				out.println("<script>location.href='index2.jsp'</script>");
				break;
			case 3:
				out.println("<script>location.href='index3.jsp'</script>");
				break;
			
			default:
				out.println("<script>alert('登录错误');location.href='login.jsp'</script>");
				break;
			
			}
			
		} else {
			out.println("<script>alert('登陆失败!');location.href='login.jsp'</script>");
		}

	}

}
