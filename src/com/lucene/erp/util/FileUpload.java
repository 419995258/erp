package com.lucene.erp.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {
	String fileUploadPath;
	File uploadTempPath;
	String[] allowedTypes;
	String code = "100";
	String fileLink = null;
	String result = null;

	public String fileUpload(HttpServletRequest request, String fileUploadPath, File uploadTempPath, int size,
			String[] allowedTypes) {

		// 步骤1：设置服务器端存储上传文件的文件夹位置
		this.fileUploadPath = fileUploadPath;
		fileLink = this.fileUploadPath;
		// 步骤2：创建系统文件上传的临时缓冲区目录
		this.uploadTempPath = uploadTempPath;
		if (!uploadTempPath.exists()) {
			// 动态创建一个缓冲区文件夹
			uploadTempPath.mkdir();
		}

		// 步骤3：解析客户端请求，判断表示是否为二进制模式
		boolean isMlutipart = ServletFileUpload.isMultipartContent(request);
		if (isMlutipart) {
			// 步骤4：创建DiskFileItemFactory对象（临时缓冲区的逻辑结构）
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 步骤4-1：设置缓冲区的物理位置，并与其绑定
			factory.setRepository(uploadTempPath);
			// 步骤4-2：设置缓冲区的大小（单位：字节）
			factory.setSizeThreshold(4 * 1024 * 1024);

			// 步骤5：创建ServletFileUpload对象，用于存放表单中的所有数据，并将其自动封装到一个集合对象中
			ServletFileUpload sfu = new ServletFileUpload(factory);
			// 设置上传文件的大小（单位：字节）
			sfu.setSizeMax(size * 1024 * 1024);

			try {
				// 步骤6：创建一个局部的List集合，用于接收sfu对象自动封装的集合
				List<FileItem> lstItems = sfu.parseRequest(request);
				// 步骤7：使用循环遍历集合中的数据
				for (FileItem fileItem : lstItems) {
					// 获取上传表单中的非文件数据
					if (fileItem.isFormField()) {

						// 获取该输入元素的name属性
						String name = fileItem.getFieldName().trim();
						if ("fname".equalsIgnoreCase(name)) {
							String fname = fileItem.getString();
							fname = new String(fname.getBytes("iso8859-1"), "utf-8");
							System.out.println("fname:> " + fname);
						}
						
					} else {
						// 限制文件上传的类型
						// 获取文件的后缀名称
						String fileName = fileItem.getName().trim();

						String extName = fileName.substring(fileName.lastIndexOf('.'));

						// 设置允许上传的类型数据
						this.allowedTypes = allowedTypes;
						Arrays.sort(allowedTypes);
						int search = Arrays.binarySearch(allowedTypes, extName);
						if (search < 0) {
							code = "101";
						} else {
							// 步骤8：创建一个File对象，设置上传文件的路径和上传文件的名称
							String newFileName = this.genrateUniqueName(fileName);
							fileLink = fileLink + "\\" + newFileName;

							File saveFile = new File(fileUploadPath, newFileName);
							// 步骤9：使用fileItem对象的write方法将文件上传到服务器指定文件夹
							fileItem.write(saveFile);
							System.out.println("文件上传成功");
						}
					}
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
				code = "102";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("test");
			}
		}
		System.out.println(code);
		return fileLink + "#" + code;

	}

	// 上传文件的名称唯一
	private synchronized String genrateUniqueName(final String fileName) {
		// 步骤1：获取上传文件的后缀名称
		String extName = fileName.substring(fileName.lastIndexOf('.'));
		// 步骤2：获取当前时间的纳秒数据
		String newName = System.nanoTime() + "";
		// 步骤3：返回唯一的名称
		return newName + extName;
	}
}
