package com.lucene.erp.service.impl;

import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.ProductDao;
import com.lucene.erp.dao.impl.ProductDaoImpl;
import com.lucene.erp.domain.Product;
import com.lucene.erp.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public int addProduct(Product product) {
	
		// TODO Auto-generated method stub
		/*String pid = product.getPid();
		String name = product.getName();
		String supplier = product.getSupplier();
		String leader = product.getLeader();
		String tel = product.getTel();

		String certificateNum = product.getCertificateNum();
		String component = product.getComponent();
		String size = product.getSize();
		int weight = product.getWeight();
		String subStone = product.getSubStone();

		String mainStone = product.getMainStone();
		double goldCost = product.getGoldCost();
		double handCost = product.getHandCost();
		int quantity = product.getQuantity();
		double cost = product.getCost();

		String photoLink = product.getPhotoLink();
		String note = product.getNote();
		
		product = new Product(pid, name, supplier, leader, tel, certificateNum, component, size, weight, subStone, mainStone, goldCost, handCost, quantity, cost, photoLink, note);*/
		ProductDao productDao = new ProductDaoImpl();
		int affectRows = productDao.insertProduct(product);
		return affectRows;

	}
	
	@Override
	public Product selectId(Product product) {
		// TODO Auto-generated method stub
		ProductDao productDao = new ProductDaoImpl();
		
		return productDao.selectId(product);
	}

	@Override
	public int updatePid(Product product) {
		// TODO Auto-generated method stub
		ProductDao productDao = new ProductDaoImpl();
		return productDao.updatePid(product);
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		ProductDao productDao = new ProductDaoImpl();
		List<Product> productList = productDao.selectAllProducts();
		return productList;
	}

	@Override
	public Product findProductByPID(String pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(Map<String, Object> searchItem) {

		ProductDao productDao = new ProductDaoImpl();
		return productDao.getCountForSearch(searchItem);
	}

	@Override
	public List<Product> getPagingList(int start, int number,Map<String, Object> searchItem) {
		ProductDao productDao = new ProductDaoImpl();
		List<Product> productList = productDao.getPagingList(start, number,searchItem);
		return productList;
	}

	@Override
	public Product getProductById(int id) {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.getProductById(id);
	}

	

}
