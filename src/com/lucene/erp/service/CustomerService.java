package com.lucene.erp.service;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Customer;
import com.lucene.erp.domain.Product;

public interface CustomerService {
	// 添加新顾客
	public abstract int addCustomer(Customer customer);

	// 查询所有顾客信息
	public abstract List<Customer> findAllCustomer();

	// 根据顾客编号查询特定顾客信息
	public abstract Customer findCustomerByCID(final int cid);
	
	// 根据顾客电话查询特定顾客信息
	public abstract Customer findCustomerByTel(final String tel);
	
	// 根据顾客姓名查询特定顾客信息
	public abstract List<Customer> findCustomerByName(final String name);
	
	//根据会员编号、会员姓名（姓名模糊查询）和联系电话查询会员信息
	public abstract List<Customer> findCustomerByCidTelName(final String cid,final String tel,final String name); 
	
	//获取页面数据
	/**
	 * 获取页面显示数据
	 * @param start
	 * @param number
	 * @return
	 */
	public List<Customer> getPagingList(int start,int number,Map<String, Object> searchItem);
	
	/**
	 * 获取数据数量
	 * @return
	 */
	public int getCount(Map<String, Object> searchItem);
	

	/**
	 * 获取指定id的商品
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(int id);
	
	/**
	 * 获取指定更新id的会员
	 * @param id
	 * @return
	 */
	public int updateCustomerById(Customer customer);
	/**
	 * 获取指定更新id的会员维护
	 * @param id
	 * @return
	 */
	public int updateCustomerServiceById(Customer customer);
}
