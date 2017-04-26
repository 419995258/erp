package com.lucene.erp.dao;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Export;
import com.lucene.erp.domain.ExportVo;
import com.lucene.erp.domain.Product;

//该接口主要包括出库的基本方法
public interface ExportDao {
	// 声明根据出库编号检索出库信息的方法
	public abstract Export selectExportByCode(String barCode);

	// 声明检索所有出库信息的方法
	public abstract List<Export> selectAllExports();

	// 声明添加出库信息的方法
	public abstract boolean insertExport(Export export);
	
	
	/**
	 * 出库成功后查询数量
	 * @param quantity
	 * @return
	 */
	public int selectProductNum(int id);
	
	/**
	 * 出库成功后更新数量
	 * @param quantity
	 * @return
	 */
	public int updateProductNum(int quantity,int id);
	
	/**
	 * 获取页面显示数据
	 * @return
	 */
	 public List<Export> getPagingList(int start, int number,Map<String, Object> searchItem);
	 
	 /**
	  * 获取查询出来的数据条数
	 * @param searchItem
	 * @return
	 */
	public int getCountForSearch(Map<String, Object> searchItem);
	
	/**
	 * 获取物料管理数据
	 * @return
	 */
	 public List<ExportVo> getMatterPagingList(int start, int number,Map<String, Object> searchItem);
	 
	 /**
	  * 获取物料数据条数
	 * @param searchItem
	 * @return
	 */
	public int getMatterCountForSearch();
	
}
