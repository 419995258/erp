package com.lucene.erp.controller;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucene.erp.util.FileUpload;

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		String fileLink = null;
		String code = null;
		String fileUploadPath = this.getServletContext().getRealPath("/upload/doc");
		File uploadTempPath = new File(this.getServletContext().getRealPath("/upload_temp"));
		String[] allowedTypes = { ".doc", ".docx", ".txt" };
		
		FileUpload upload = new FileUpload();
		String result = upload.fileUpload(request, fileUploadPath, uploadTempPath, 3, allowedTypes);
		String[] rs = result.split("#");
		fileLink = rs[0];
		code = rs[1];
		if(code.equals("101"))
		{
			out.println("<script>alert('type error');</script>");
		}
		else if(code.equals("102"))
		{
			out.println("<script>alert('upload failure');</script>");
		}
		else
		{
			out.println("<script>alert('success');</script>");
			System.out.println(fileLink);
		}
	}
}
