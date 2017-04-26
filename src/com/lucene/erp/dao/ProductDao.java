package com.lucene.erp.dao;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Product;

//该接口主要声明对商品(Product)进行操作的基本方法
public interface ProductDao {
	// 声明新增商品的方法
	public abstract int insertProduct(Product product);
	
	//更新pid方法
	public abstract Product selectId(Product product);
	
	//更新pid方法2
	public abstract int updatePid(Product product);

	// 声明修改商品信息的方法
	public abstract boolean updateProduct(Product product);

	// 声明根据商品编号检索商品的方法
	public abstract Product selectProductByPID(final int pid);

	// 声明根据供应商名称检索商品的方法
	public abstract List<Product> selectProductsBySupplier(String supplier);

	// 声明检索所有商品信息的方法
	public abstract List<Product> selectAllProducts();
	
	/**
	 * 获取页面显示数据
	 * @return
	 */
	 public List<Product> getPagingList(int start, int number,Map<String, Object> searchItem);
	 
	 /**
	  * 获取查询出来的数据条数
	 * @param searchItem
	 * @return
	 */
	public int getCountForSearch(Map<String, Object> searchItem);
	
	/**
	 * 获取指定id的商品
	 * @param id
	 * @return
	 */
	public Product getProductById(int id);

}
