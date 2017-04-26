package com.lucene.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.lucene.erp.domain.Sale;
import com.lucene.erp.domain.User;
import com.lucene.erp.service.SaleService;
import com.lucene.erp.service.impl.SaleServiceImpl;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class AddDiySaleServlet
 */
@WebServlet("/AddDiySaleServlet")
public class AddDiySaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDiySaleServlet() {
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
		Log.out("Sale", ">>>>>>>>>>>>>>>>>>>>");
		// 对date生日数据进行处理
		Date diyDate = new Date();
		Date deliverDate = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		String durl = null;
		int code = 100;

		int sid = 0;
		String diyNum = null;
		int quantity = 0;

		double retaPrice = 0;
		double deposit = 0;
		double billing = 0;
		String cashier = null;
		String diyConsultant = null;

		String customerArchive = null;
		int pid = 0;
		int cid = 0;
		String note = null;
		String customerArchiveName = null;

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

		// 设置内存中缓存区的大小---10M
		factory.setSizeThreshold(10 * 1024 * 1024);

		factory.setRepository(tempDirectory);
		// 设置服务器端储存上传文件的文件夹位置

		// 创建上ServletFileUpload 对象，用于存放表单中的所有数据，并将其自动封装到一个集合中。
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 创建一个局部的List集合，接收upload对象自动封装的集合
			List<FileItem> lstItems = upload.parseRequest(request);

			// 遍历items:若是一个一般的表单域，打印信息
			for (FileItem fileItem : lstItems) {

				if (fileItem.isFormField()) {
					String textContext = fileItem.getFieldName().trim();
					// String textContext = item.getFieldName();
					if ("sid".equalsIgnoreCase(textContext)) {
						String Xsid = fileItem.getString();
						Xsid = new String(Xsid.getBytes("iso8859-1"), "utf-8");
						sid = Integer.parseInt(Xsid);
						Log.out("sale", "新增定制商品上传_sid：" + sid);
					}
					if ("diyNum".equalsIgnoreCase(textContext)) {
						diyNum = fileItem.getString();
						diyNum = new String(diyNum.getBytes("iso8859-1"), "utf-8");
						Log.out("sale", "新增定制商品上传_diyNum：" + diyNum);
					}
					if ("diyDate".equalsIgnoreCase(textContext)) {
						String XdiyDate = fileItem.getString();
						XdiyDate = new String(XdiyDate.getBytes("iso8859-1"), "utf-8");
						diyDate = sim.parse(XdiyDate);
						Log.out("sale", "新增定制商品上传_diyDate：" + diyDate);
					}
					if ("deliverDate".equalsIgnoreCase(textContext)) {
						String XdeliverDate = fileItem.getString();
						XdeliverDate = new String(XdeliverDate.getBytes("iso8859-1"), "utf-8");
						deliverDate = sim.parse(XdeliverDate);
						Log.out("sale", "新增定制商品上传_deliverDate：" + deliverDate);
					}
					if ("quantity".equalsIgnoreCase(textContext)) {
						String Xquantity = fileItem.getString();
						Xquantity = new String(Xquantity.getBytes("iso8859-1"), "utf-8");
						quantity = Integer.parseInt(Xquantity);
						Log.out("sale", "新增定制商品上传_quantity：" + quantity);
					}
					// 5
					if ("retaPrice".equalsIgnoreCase(textContext)) {
						String XretaPrice = fileItem.getString();
						XretaPrice = new String(XretaPrice.getBytes("iso8859-1"), "utf-8");
						retaPrice = Double.parseDouble(XretaPrice);
						Log.out("sale", "新增定制商品上传_retaPrice：" + retaPrice);
					}
					if ("deposit".equalsIgnoreCase(textContext)) {
						String Xdeposit = fileItem.getString();
						Xdeposit = new String(Xdeposit.getBytes("iso8859-1"), "utf-8");
						deposit = Double.parseDouble(Xdeposit);
						Log.out("sale", "新增定制商品上传_deposit：" + deposit);
					}

					if ("billing".equalsIgnoreCase(textContext)) {
						String Xbilling = fileItem.getString();
						Xbilling = new String(Xbilling.getBytes("iso8859-1"), "utf-8");
						billing = Integer.parseInt(Xbilling);
						Log.out("sale", "新增定制商品上传_billing：" + billing);
					}
					if ("cashier".equalsIgnoreCase(textContext)) {
						cashier = fileItem.getString();
						cashier = new String(cashier.getBytes("iso8859-1"), "utf-8");
						Log.out("sale", "新增定制商品上传_cashier：" + cashier);
					}
					if ("diyConsultant".equalsIgnoreCase(textContext)) {
						diyConsultant = fileItem.getString();
						diyConsultant = new String(diyConsultant.getBytes("iso8859-1"), "utf-8");
						Log.out("sale", "新增定制商品上传_diyConsultant：" + diyConsultant);
					}

					// 10
					/*
					 * if ("customerArchive".equalsIgnoreCase(textContext)) {
					 * customerArchive = fileItem.getString(); customerArchive =
					 * new String(customerArchive.getBytes("iso8859-1"),
					 * "utf-8"); Log.out("sale", "新增定制商品上传_customerArchive：" +
					 * customerArchive); }
					 */
					if ("pid".equalsIgnoreCase(textContext)) {
						String Xpid = fileItem.getString();
						Xpid = new String(Xpid.getBytes("iso8859-1"), "utf-8");
						pid = Integer.parseInt(Xpid);
						Log.out("sale", "新增定制商品上传_pid：" + pid);
					}
					if ("cid".equalsIgnoreCase(textContext)) {
						String Xcid = fileItem.getString();
						Xcid = new String(Xcid.getBytes("iso8859-1"), "utf-8");
						cid = Integer.parseInt(Xcid);
						Log.out("sale", "新增定制商品上传_cid：" + cid);
					}
					if ("note".equalsIgnoreCase(textContext)) {
						note = fileItem.getString();
						note = new String(note.getBytes("iso8859-1"), "utf-8");
						Log.out("sale", "新增定制商品上传_note：" + note);
					}

					// 15

				}

				// 若是文件与则把文件保存到 目录下
				else {

					// 获取文件名字
					String fileName = fileItem.getName();

					// 在控制台输出以上信息
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
					durl = "../erp_v2.0/upload/photo/" + UploadFileName;
					customerArchive = durl;
					customerArchiveName = UploadFileName;
					Log.out("sale", "上传后的文件的名是：" + UploadFileName);
					Log.out("sale", "上传后的文件目录是：" + fileUploadPath);
					Log.out("sale", "上传后的文件路径是：" + durl);
					Log.out("sale", "savrFile：" + savrFile);
					Log.out("sale", "customerArchive是:" + customerArchive);
					Log.out("sale", "customerArchiveName是:" + customerArchiveName);

					// ★扩展：设置允许上传的类型数据

					String[] allowedTypes = { ".doc", ".txt", ".docx", ".zip" };
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

						outt.close();
						// 删除临时缓存文件
						fileItem.delete();

					}
				}

			}
			/**
			 * 遍历完控件后保存产品数据
			 */
			Sale sale = new Sale(sid, diyNum, diyDate, deliverDate, quantity, retaPrice, deposit, billing, cashier,
					diyConsultant, customerArchive, pid, cid, note, customerArchiveName);
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			sale.setUserId(user.getId());
			sale.setUserName(user.getName());
			SaleService saleService = new SaleServiceImpl();
			int affectRows = saleService.addDiySale(sale);
			Sale sale2 = new Sale();
			sale2 = saleService.selectId(sale);
			affectRows = saleService.updateSid(sale2);
			Map<String, String> data = new HashMap<String, String>();
			if (affectRows != -1) {
				data.put("result", "1");
				data.put("msg", "商品添加成功");
				Log.out("sale", "定制商品信息添加成功");
			} else {
				data.put("result", "0");
				data.put("msg", "商品添加失败,请重新添加");
				Log.out("sale", "定制商品添加失败");
				File delFile = new File(sale.getCustomerArchive());
				delFile.delete();
			}
			JSONObject result = new JSONObject(data);
			// response.getWriter().write(result.toString());
			response.getWriter().write(result.toString());

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 返回页面
			/*
			 * if (code == 100) {
			 * out.println("<script>alert('资料添加成功');</script>"); } else {
			 * response.sendRedirect("<script>alert('资料添加失败');</script>"); }
			 */

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

}
