package com.lucene.erp.service;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Export;
import com.lucene.erp.domain.Product;

public interface ExportService {
	// 声明根据出库编号检索出库信息的方法
	public abstract Export findExportByCode(String barCode);

	// 声明检索所有出库信息的方法
	public abstract List<Export> findAllExports();

	// 声明添加出库信息的方法
	public abstract boolean addExport(Export export);
	
	
	/**
	 * 获取数据数量
	 * @return
	 */
	public int getCount(Map<String, Object> searchItem);
	
	/**
	 * 获取页面显示数据
	 * @param start
	 * @param number
	 * @return
	 */
	public List<Export> getPagingList(int start,int number,Map<String, Object> searchItem);
	
	
}
