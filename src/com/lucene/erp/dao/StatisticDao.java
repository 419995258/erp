package com.lucene.erp.dao;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Inventory;
import com.lucene.erp.domain.Statistic;
import com.lucene.erp.domain.User;

public interface StatisticDao {
	/**
	 * 查询日记录
	 * 
	 * @return
	 */
	public List<Statistic> getDayPagingList(int start, int number, Map<String, Object> searchItem);
	
	/**
	 * 查询日记录条数
	 * 
	 * @return
	 */
	public int getDayCount();
	
	/**
	 * 查询店铺数
	 */
	public List<User> getAllUser();
	
	/**
	 * 查询月记录数
	 */
	public Statistic getMonthPagingList(int start, int number,String selectTime, Map<String, Object> searchItem);
	
	/**
	 * 查询年记录数
	 */
	public Statistic getYearPagingList(int start, int number,String selectTime, Map<String, Object> searchItem);
	
	/**
	 * 查询店铺会员数
	 * 
	 * @return
	 */
	public int getCust(Map<String, Object> searchItem);
}
