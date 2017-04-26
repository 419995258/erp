package com.lucene.erp.dao;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Customer;

//声明有关Customer的基本操作
public interface CustomerDao {
	// 声明一个添加顾客信息的方法
	public abstract int insertCustomer(Customer customer);

	// 声明一个查询所有顾客信息的方法
	public abstract List<Customer> selectAllCustomers();

	// 根据客户id检索客户信息
	public abstract Customer selectCustomerByCID(final int id);

	// 根据客户姓名检索客户信息
	public abstract List<Customer> selectCustomerByName(String name);
	
	//通过会员编号、会员姓名（姓名模糊查询）和联系电话查询会员信息
	public abstract List<Customer> selectCustomerByCidTelCname(final String id,final String tel,final String name);
	
	// 根据客户电话检索客户信息
	public abstract Customer selectCustomerByTel(String tel);

	// 修改客户基本信息
	public abstract boolean updateCustomer(Customer customer);
	
	//获取页面显示数据
	/**
	 * 获取页面显示数据
	 * @return
	 */
	public List<Customer> getPagingList(int start, int number,Map<String, Object> searchItem);
	
	/**
	  * 获取查询出来的数据条数
	 * @param searchItem
	 * @return
	 */
	public int getCountForSearch(Map<String, Object> searchItem);
	
	/**
	 * 获取指定id的会员信息
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(int id);
	
	/**
	 *  获取指定更新id的会员信息
	 * @param id
	 * @return
	 */
	public int updateCustomerById(Customer customer);
	/**
	 *  获取指定更新id的维护信息
	 * @param id
	 * @return
	 */
	public int updateCustomerServiceById(Customer customer);
}
