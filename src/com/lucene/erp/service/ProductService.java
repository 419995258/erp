package com.lucene.erp.service;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Product;

public interface ProductService {
	// 添加商品
	public abstract int addProduct(Product product);

	//更新pid
	public abstract Product selectId(Product product);
	
	//更新pid2
	public abstract int updatePid(Product product);
	// 检索所有商品
	public abstract List<Product> findAllProducts();

	// 根据商品编号检索特定商品
	public abstract Product findProductByPID(final String pid);

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
	public List<Product> getPagingList(int start,int number,Map<String, Object> searchItem);
	
	/**
	 * 获取指定id的商品
	 * @param id
	 * @return
	 */
	public Product getProductById(int id);
}
