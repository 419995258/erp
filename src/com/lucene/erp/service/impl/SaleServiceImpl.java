package com.lucene.erp.service.impl;

import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.SaleDao;
import com.lucene.erp.dao.impl.SaleDaoImpl;
import com.lucene.erp.domain.Product;
import com.lucene.erp.domain.Sale;
import com.lucene.erp.service.SaleService;

public class SaleServiceImpl implements SaleService {

	@Override
	public int addSale(Sale sale) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Sale> findAllSales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sale> findSalesByConsultant(String consultant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sale findSaleByPID(String pid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int addDiySale(Sale sale) {
		// TODO Auto-generated method stub
		SaleDao saleDao = new SaleDaoImpl();
		int affectRows = saleDao.insertDiySale(sale);
		return affectRows;
	}

	@Override
	public List<Sale> findAllDiySales() {
		// TODO Auto-generated method stub
		SaleDao saleDao = new SaleDaoImpl();
		List<Sale> saleList = saleDao.selectAllDiySales();
		return saleList;
	}

	@Override
	public Product findProductByPID(String pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		SaleDao saleDao = new SaleDaoImpl();
		return saleDao.getCountForSearch(searchItem);
	}

	@Override
	public List<Sale> getPagingList(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		SaleDao saleDao = new SaleDaoImpl();
		List<Sale> saleList = saleDao.getPagingList(start, number, searchItem);
		return saleList;
	}

	@Override
	public Sale getSaleById(int id) {
		// TODO Auto-generated method stub
		SaleDao saleDao = new SaleDaoImpl();
		return saleDao.getSaleById(id);
	}

	@Override
	public Sale selectId(Sale sale) {
		// TODO Auto-generated method stub
		SaleDao saleDao = new SaleDaoImpl();
		return saleDao.selectId(sale);
	}

	@Override
	public int updateSid(Sale sale) {
		// TODO Auto-generated method stub
		SaleDao saleDao = new SaleDaoImpl();
		return saleDao.updateSid(sale);
	}

	@Override
	public int updateDiyById(Sale sale) {
		// TODO Auto-generated method stub
		SaleDao saleDao = new SaleDaoImpl();
		return saleDao.updateDiyById(sale);
	}

}
