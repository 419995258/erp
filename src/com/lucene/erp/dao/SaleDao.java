package com.lucene.erp.dao;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Attend;
import com.lucene.erp.domain.Inventory;
import com.lucene.erp.domain.Product;
import com.lucene.erp.domain.ResultVo;
import com.lucene.erp.domain.Sale;
import com.lucene.erp.domain.SaleVo;
import com.lucene.erp.domain.Traffic;
import com.lucene.erp.domain.User;

//该接口声明了与销售相关的基本方法
public interface SaleDao {
	// 声明新增销售记录的方法
	public abstract int insertSale(Sale sale);

	// 声明新增定制管理的方法
	public abstract int insertDiySale(Sale sale);

	// 更新sid方法
	public abstract Sale selectId(Sale sale);

	// 更新sid方法
	public abstract int updateSid(Sale sale);

	// 声明检索所有销售信息的方法
	public abstract List<Sale> selectAllSales();

	// 声明根据销售顾问检索销售信息的方法
	public abstract List<Sale> selectSalesByConsultant(String consultant);

	// 声明根据商品编号检索销售信息的方法
	public abstract Sale selectSaleByPID(String pid);

	// 声明检索所有定制商品信息的方法
	public abstract List<Sale> selectAllDiySales();
	
	//更新diy信息
	public abstract int updateDiyById(Sale sale);

	/**
	 * 获取页面显示数据
	 * 
	 * @return
	 */
	public List<Sale> getPagingList(int start, int number, Map<String, Object> searchItem);

	/**
	 * 获取查询出来的数据条数
	 * 
	 * @param searchItem
	 * @return
	 */
	public int getCountForSearch(Map<String, Object> searchItem);

	/**
	 * 获取指定id的商品
	 * 
	 * @param id
	 * @return
	 */
	public Sale getSaleById(int id);
	
	/**
	 * 查询所有店铺
	 * @return
	 */
	public List<User> queryAllDIANPU();
	
	/**
	 * 查询日统计
	 * @param resultVo
	 * @return
	 */
	public ResultVo queryAnalyDay(ResultVo resultVo);
	
	/**
	 * 查询月统计
	 * @param resultVo
	 * @return
	 */
	public ResultVo queryAnalyMonth(ResultVo resultVo);
	
	/**
	 * 查询年统计
	 * @param resultVo
	 * @return
	 */
	public ResultVo queryAnalyYear(ResultVo resultVo);
	
	
	/**
	 * 查询订单记录
	 * 
	 * @return
	 */
	public List<SaleVo> getPagingListOrder(int start, int number, Map<String, Object> searchItem);
	
	/**
	 * 查询订单记录条数
	 * 
	 * @return
	 */
	public int getSaleOrderCount();
	
	/**
	 * 添加考勤
	 * @param attend
	 * @return
	 */
	public int insertAttend(Attend attend);
	
	/**
	 * 查询考勤记录
	 * 
	 * @return
	 */
	public List<Attend> getAttendPagingListOrder(int start, int number, Map<String, Object> searchItem);
	
	/**
	 * 查询订单记录条数
	 * 
	 * @return
	 */
	public int getAttendCount();
	
	/**
	 * 添加客流
	 * @param attend
	 * @return
	 */
	public int insertTraffic(Traffic traffic);
	
	/**
	 * 查询客流记录
	 * 
	 * @return
	 */
	public List<Traffic> getTrafficPagingListOrder(int start, int number, Map<String, Object> searchItem);
	
	/**
	 * 查询客流记录条数
	 * 
	 * @return
	 */
	public int getTrafficOrderCount();
	
	/**
	 * 添加盘点
	 * @param attend
	 * @return
	 */
	public int insertCheck(Inventory inventory);
	
	/**
	 * 查询盘点记录
	 * 
	 * @return
	 */
	public List<Inventory> getCheckPagingListOrder(int start, int number, Map<String, Object> searchItem);
	
	/**
	 * 查询盘点记录条数
	 * 
	 * @return
	 */
	public int getCheckCount();
}
