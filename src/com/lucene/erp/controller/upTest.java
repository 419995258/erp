package com.lucene.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class up
 */
@WebServlet("/up")
public class upTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public upTest() {
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

		String durl = null;
		// 获取文本框输入的信息
		String upLoadMan = null;

		PrintWriter out = response.getWriter();
		int code = 100;

		// 1.得到 FileItem 的集合 items

		String fileUploadPath = this.getServletContext().getRealPath("/upload/doc");
		// 设置临时文件的存放目录
		File tempDirectory = new File(this.getServletContext().getRealPath("/tempupload"));
		// 如果没有这个目录
		if (!tempDirectory.exists()) {
			// 动态创建一个缓冲区文件夹
			tempDirectory.mkdir();
		}
		// 创建DiskFileItemFactory对象（临时缓冲区的逻辑结构）
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 设置内存中缓存区的大小
		factory.setSizeThreshold(1024 * 1024 * 1024);

		factory.setRepository(tempDirectory);
		// 设置服务器端储存上传文件的文件夹位置

		// 创建上ServletFileUpload 对象，用于存放表单中的所有数据，并将其自动封装到一个集合中。
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 创建一个局部的List集合，接收upload对象自动封装的集合
			// *****************************************************************
			List<FileItem> lstItems = upload.parseRequest(request);

			// 遍历items:若是一个一般的表单域，打印信息
			for (FileItem fileItem : lstItems) {

				if (fileItem.isFormField()) {
					String textContext = fileItem.getFieldName().trim();
					
					  if ("upLoadMan".equalsIgnoreCase(textContext)) {
					  upLoadMan = fileItem.getString(); upLoadMan = new
					  String(upLoadMan.getBytes("iso8859-1"), "utf-8");
					  System.out.println("upLoadMan:> " + upLoadMan); }
					 
				

				}

				// 若是文件与则把文件保存到 目录下
				else {

					// 获取文件名字
					String fileName = fileItem.getName();
					System.out.println("这时文件");
					System.out.println("文件名为：" + fileName);

					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);

					// --------------------------------------//--------------------------------------//
					// 得到上传文件的扩展名
					String fileExtName = fileName.substring(fileName.lastIndexOf("."));
					OutputStream outt = new FileOutputStream(fileName);
					System.out.println("上传的文件的扩展名是：" + fileExtName);
					// --------------------------------------//--------------------------------------//

					// --------------------------------------//--------------------------------------//
					// 解决文件上传同名问题
					// 获取上传文件的名称
					String UploadFileName = fileItem.getFieldName().trim();
					UploadFileName = UploadFileName.substring(UploadFileName.lastIndexOf("\\") + 1);
					// 获取上传文件的类型
					// 文件重命名
					UploadFileName = genterateName(fileName);
					File savrFile = new File(fileUploadPath, UploadFileName.trim());

					System.out.println("上传后的文件的名是：" + UploadFileName);
					System.out.println("上传后的文件的名是：" + savrFile);
					durl = fileUploadPath + "\\" + UploadFileName;
					System.out.println(">>>>：" + fileUploadPath);

					System.out.println("文件上传路径为：" + durl);
					

					String[] allowedTypes = { ".jpg", ".png", ".rar", ".txt" };
					Arrays.sort(allowedTypes);
					int search = Arrays.binarySearch(allowedTypes, fileExtName);

					if (search < 0) {
						code = 102;
						System.out.println(code);
					} else {
						try {
							fileItem.write(savrFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("添加成功");
						
					outt.close();
						// 删除临时缓存文件
						fileItem.delete();

					}
				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 返回页面
			if (code == 100) {
				out.println("<script>alert('资料添加成功');</script>");
			} else {
				response.sendRedirect("<script>alert('资料添加失败');</script>");
			}

		}

	}

	// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
	private synchronized String genterateName(final String fileName) {
		// TODO Auto-generated method stub
		// 获取上传文件的后缀名
		String extName = fileName.substring(fileName.lastIndexOf('.'));
		// 获取当前时间的纳秒数据
		String newName = System.nanoTime() + "";
		// 返回唯一名称
		return newName + extName;

	}
	/*
	 * PrintWriter out = response.getWriter();
	 * request.setCharacterEncoding("utf-8");
	 * response.setCharacterEncoding("utf-8");
	 * response.setContentType("text/html;charset=utf-8");// 防止乱码
	 * 
	 * 
	 * String fileLink = null; String code = null;
	 * 
	 * String upLoadMan = null; upLoadMan = request.getParameter("upLoadMan");
	 * System.out.println("upLoadMan:" + upLoadMan);
	 * 
	 * DiskFileItemFactory factory = new DiskFileItemFactory();
	 * ServletFileUpload sfu = new ServletFileUpload(factory);
	 * 
	 * try { List<FileItem> lstItems; lstItems = sfu.parseRequest(request); for
	 * (FileItem fileItem : lstItems) {
	 * 
	 * // 获取上传表单中的非文件数据 if (fileItem.isFormField()) {
	 * 
	 * // 获取该输入元素的name属性 String name = fileItem.getFieldName().trim(); if
	 * ("upLoadMan".equalsIgnoreCase(name)) { upLoadMan = fileItem.getString();
	 * upLoadMan = new String(upLoadMan.getBytes("iso8859-1"), "utf-8");
	 * System.out.println("upLoadMan:> " + upLoadMan); }
	 * 
	 * } } } catch (FileUploadException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } // 步骤7：使用循环遍历集合中的数据
	 * 
	 * String fileUploadPath =
	 * this.getServletContext().getRealPath("/upload/doc"); File uploadTempPath
	 * = new File(this.getServletContext().getRealPath("/upload_temp"));
	 * String[] allowedTypes = { ".doc", ".docx", ".txt" };
	 * 
	 * FileUpload upload = new FileUpload(); String result =
	 * upload.fileUpload(request, fileUploadPath, uploadTempPath, 3,
	 * allowedTypes); String[] rs = result.split("#"); fileLink = rs[0]; code =
	 * rs[1]; if (code.equals("101")) { out.println(
	 * "<script>alert('type error');</script>"); } else if (code.equals("102"))
	 * { out.println("<script>alert('upload failure');</script>"); } else {
	 * out.println("<script>alert('success');</script>");
	 * System.out.println(fileLink); } }
	 */
}
