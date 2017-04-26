package com.lucene.erp.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucene.erp.util.Log;

/**
 * Servlet implementation class DownloadDiySaleServlet
 */
@WebServlet("/DownloadDiySaleServlet")
public class DownloadDiySaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadDiySaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fileName = request.getParameter("name");
		Log.out("sale", "fileName是："+fileName);
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ URLEncoder.encode(fileName, "utf-8"));
		//OutputStream out = response.getOutputStream();
		InputStream in = new FileInputStream(this.getServletContext()
				.getRealPath("/upload/doc") + "//" + fileName);

		/*
		 * 把文件变成字节数组，再存到磁盘，存上去之后也是文件，现在的时候再变成字节数组，再变成文件 字节数组就相当于一个中间转换的东西
		 */
		/*byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}*/
		in.close();
	}
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("downloadServlet销毁");
	}

}
