package com.lucene.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.lucene.erp.domain.Product;
import com.lucene.erp.service.ProductService;
import com.lucene.erp.service.impl.ProductServiceImpl;
import com.lucene.erp.util.Log;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		int pid = 0;
		String name = null;
		String supplier = null;
		String leader = null;
		String tel = null;

		String certificateNum = null;
		String component = null;
		String size = null;
		double weight = 0;
		String subStone = null;

		String mainStone = null;
		double goldCost = 0;
		double handCost = 0;
		int quantity = 0;
		double cost = 0;

		String photoLink = null;
		String note = null;
		String photoName = null;

		PrintWriter out = response.getWriter();
		int code = 100;

		// 1.得到 FileItem 的集合 items

		String fileUploadPath = this.getServletContext().getRealPath("/upload/photo");
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
		String a = request.getParameter("pid");
		try {
			// 创建一个局部的List集合，接收upload对象自动封装的集合
			List<FileItem> lstItems = upload.parseRequest(request);

			// 遍历items:若是一个一般的表单域，打印信息
			for (FileItem fileItem : lstItems) {

				if (fileItem.isFormField()) {
					String textContext = fileItem.getFieldName().trim();
					// String textContext = item.getFieldName();
					if ("pid".equalsIgnoreCase(textContext)) {
						String Xpid = fileItem.getString();
						Xpid = new String(Xpid.getBytes("iso8859-1"), "utf-8");
						pid = Integer.parseInt(Xpid);
						Log.out("prodect", "新增商品上传_pid：" + pid);
					}
					if ("name".equalsIgnoreCase(textContext)) {
						name = fileItem.getString();
						name = new String(name.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_name：" + name);
					}
					if ("supplier".equalsIgnoreCase(textContext)) {
						supplier = fileItem.getString();
						supplier = new String(supplier.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_supplier：" + supplier);
					}
					if ("leader".equalsIgnoreCase(textContext)) {
						leader = fileItem.getString();
						leader = new String(leader.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_leader：" + leader);
					}
					if ("tel".equalsIgnoreCase(textContext)) {
						tel = fileItem.getString();
						tel = new String(tel.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_tel：" + tel);
					}
					// 5
					if ("certificateNum".equalsIgnoreCase(textContext)) {
						certificateNum = fileItem.getString();
						certificateNum = new String(certificateNum.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_certificateNum：" + certificateNum);
					}
					if ("component".equalsIgnoreCase(textContext)) {
						component = fileItem.getString();
						component = new String(component.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_component：" + component);
					}
					if ("size".equalsIgnoreCase(textContext)) {
						size = fileItem.getString();
						size = new String(size.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_size：" + size);
					}
					if ("weight".equalsIgnoreCase(textContext)) {
						String Xweight = fileItem.getString();
						Xweight = new String(Xweight.getBytes("iso8859-1"), "utf-8");
						weight = Double.parseDouble(Xweight);
						Log.out("prodect", "新增商品上传_weight：" + weight);
					}
					if ("subStone".equalsIgnoreCase(textContext)) {
						subStone = fileItem.getString();
						subStone = new String(subStone.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_subStone：" + subStone);
					}
					// 10
					if ("mainStone".equalsIgnoreCase(textContext)) {
						mainStone = fileItem.getString();
						mainStone = new String(mainStone.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_mainStone：" + mainStone);
					}
					if ("goldCost".equalsIgnoreCase(textContext)) {
						String XgoldCost = fileItem.getString();
						XgoldCost = new String(XgoldCost.getBytes("iso8859-1"), "utf-8");
						goldCost = Double.parseDouble(XgoldCost);
						Log.out("prodect", "新增商品上传_goldCost：" + goldCost);
					}
					if ("handCost".equalsIgnoreCase(textContext)) {
						String XhandCost = fileItem.getString();
						XhandCost = new String(XhandCost.getBytes("iso8859-1"), "utf-8");
						handCost = Double.parseDouble(XhandCost);
						Log.out("prodect", "新增商品上传_handCost：" + handCost);
					}
					if ("quantity".equalsIgnoreCase(textContext)) {
						String Xquantity = fileItem.getString();
						Xquantity = new String(Xquantity.getBytes("iso8859-1"), "utf-8");
						quantity = Integer.parseInt(Xquantity);
						Log.out("prodect", "新增商品上传_quantity：" + quantity);
					}
					if ("cost".equalsIgnoreCase(textContext)) {
						String Xcost = fileItem.getString();
						Xcost = new String(Xcost.getBytes("iso8859-1"), "utf-8");
						cost = Double.parseDouble(Xcost);
						Log.out("prodect", "新增商品上传_cost：" + cost);
					}
					// 15
					/*if ("photoLink".equalsIgnoreCase(textContext)) {
						photoLink = fileItem.getString();
						photoLink = new String(photoLink.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_photoLink：" + photoLink);
					}*/
					if ("note".equalsIgnoreCase(textContext)) {
						note = fileItem.getString();
						note = new String(note.getBytes("iso8859-1"), "utf-8");
						Log.out("prodect", "新增商品上传_note：" + note);
					}
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
					//本机
					//durl = "../erp_v2.0/upload/photo/" + UploadFileName;
					//服务器
					durl = "../upload/photo/" + UploadFileName;
					photoLink = durl;
					photoName = UploadFileName;
					Log.out("prodect", "上传后的文件的名是：" + UploadFileName);
					Log.out("prodect", "上传后的文件目录是：" + fileUploadPath);
					Log.out("prodect", "上传后的文件路径是：" + durl);
					Log.out("prodect", "savrFile：" + savrFile);
					Log.out("product", "photoLink是:"+photoLink);
					

					// ★扩展：设置允许上传的类型数据

					String[] allowedTypes = { ".jpg", ".png", ".jpeg", ".bmp" };
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
			Product product = new Product(pid, name, supplier, leader, tel, certificateNum, component, size, weight, subStone, mainStone, goldCost, handCost, quantity, cost, photoLink, note,photoName);
			ProductService productService = new ProductServiceImpl();
			int affectRows = productService.addProduct(product);
			Product product2 = new Product();
			product2 = productService.selectId(product);
			Log.out("product", "product2.getId()>>>>>>>"+product2.getId());
			//affectRows = productService.updatePid(product2);
			Map<String, String> data = new HashMap<String, String>();
			if (affectRows != -1) {
				
				data.put("result", "1");
				data.put("msg", "商品添加成功");
				Log.out("product", "信息添加成功");
			}else
			{
				data.put("result", "0");
				data.put("msg", "商品添加失败,请重新添加");
				File delFile = new File(product.getPhotoLink());
				delFile.delete();
				Log.out("product", "信息添加失败");
			}
			JSONObject result = new JSONObject(data);
			
			response.getWriter().write(result.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.out("product", "信息添加失败");
			Map<String, String> data = new HashMap<>();
			data.put("result", "0");
			data.put("msg", "商品添加失败,请刷新重新添加");
			JSONObject result = new JSONObject(data);
			response.getWriter().write(result.toString());
		} finally {
			
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
