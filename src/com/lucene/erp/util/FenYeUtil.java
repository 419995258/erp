package com.lucene.erp.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class FenYeUtil {

	List<Object> rlist = new ArrayList<Object>();
	private int perPage;// 每页显示的条目数
	private int currentPage;// 当前该显示的页码
	private String jspurl;// 得到当前jsp页面路径
	private int totalpage;// 定义总页数
	private int headListNum;// 头数据的list下标
	private int footListNum;// 尾数据的下标
	public FenYeUtil(HttpServletRequest request, List<?> list, int perPage) {
		this.perPage = perPage;// 每页显示的条目数
		//如果获取当前页码出现异常时，给当前页码初始值为1
		try{
			this.currentPage = Integer.parseInt(request.getParameter("currentPage"));// 当前该显示的页码
		} catch (Exception e ){
			this.currentPage =1;
		}

		this.jspurl = request.getRequestURI();// 得到当前jsp页面路径

		if (list.size() % perPage == 0)// 设置总页数
			this.totalpage = (list.size() / perPage);
		else
			this.totalpage = (list.size() / perPage) + 1;
		this.headListNum = (currentPage - 1) * perPage;// 头数据的list下标
		this.footListNum = currentPage * perPage - 1;// 尾数据的下标

		for (int i = headListNum; i <= footListNum && i < list.size(); i++) {
			this.rlist.add(list.get(i));
		}
	}
	public List getRlist() {
		return rlist;
	}
	public void setRlist(List rlist) {
		this.rlist = rlist;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getJspurl() {
		return jspurl;
	}
	public void setJspurl(String jspurl) {
		this.jspurl = jspurl;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getHeadListNum() {
		return headListNum;
	}
	public void setHeadListNum(int headListNum) {
		this.headListNum = headListNum;
	}
	public int getFootListNum() {
		return footListNum;
	}
	public void setFootListNum(int footListNum) {
		this.footListNum = footListNum;
	}
}
