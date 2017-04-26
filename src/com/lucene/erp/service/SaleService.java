package com.lucene.erp.service;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Product;
import com.lucene.erp.domain.Sale;

public interface SaleService {
	// 声明新增销售记录的方法
	public abstract int addSale(Sale sale);

	// 声明新增定制管理的方法
	public abstract int addDiySale(Sale sale);

	// 更新sid
	public abstract Sale selectId(Sale sale);

	// 更新sid2
	public abstract int updateSid(Sale sale);

	// 声明检索所有销售信息的方法
	public abstract List<Sale> findAllSales();

	// 声明根据销售顾问检索销售信息的方法
	public abstract List<Sale> findSalesByConsultant(String consultant);

	// 声明根据商品编号检索销售信息的方法
	public abstract Sale findSaleByPID(String pid);

	// 声明检索所有定制商品信息的方法
	public abstract List<Sale> findAllDiySales();
	
	//更新diy
	public abstract int updateDiyById(Sale sale);

	public abstract Product findProductByPID(final String pid);

	/**
	 * 获取数据数量
	 * 
	 * @return
	 */
	public int getCount(Map<String, Object> searchItem);

	/**
	 * 获取页面显示数据
	 * 
	 * @param start
	 * @param number
	 * @return
	 */
	public List<Sale> getPagingList(int start, int number, Map<String, Object> searchItem);

	/**
	 * 获取指定id的商品
	 * 
	 * @param id
	 * @return
	 */
	public Sale getSaleById(int id);
}
