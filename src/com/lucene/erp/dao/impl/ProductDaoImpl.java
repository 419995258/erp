package com.lucene.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.ProductDao;
import com.lucene.erp.datasource.ConnectionManager;
import com.lucene.erp.datasource.SQLManager;
import com.lucene.erp.domain.Product;
import com.mysql.jdbc.Connection;

public class ProductDaoImpl implements ProductDao {
	ConnectionManager connectionManager = new ConnectionManager();
	Connection connection = (Connection) connectionManager.openConnection();
	SQLManager sqlManager = new SQLManager();

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		int pid = product.getPid();
		String name = product.getName();
		String supplier = product.getSupplier();
		String leader = product.getLeader();
		String tel = product.getTel();

		String certificateNum = product.getCertificateNum();
		String component = product.getComponent();
		String size = product.getSize();
		double weight = product.getWeight();
		String subStone = product.getSubStone();

		String mainStone = product.getMainStone();
		double goldCost = product.getGoldCost();
		double handCost = product.getHandCost();
		int quantity = product.getQuantity();
		double cost = product.getCost();

		String photoLink = product.getPhotoLink();
		String note = product.getNote();
		String photoName = product.getPhotoName();

		String strSQL = "insert into product(pid,name,supplier,leader,tel,certificateNum,component,size,weight,subStone,mainStone,goldCost,handCost,quantity,cost,photoLink,note,photoName)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { pid, name, supplier, leader, tel, certificateNum,
				component, size, weight, subStone, mainStone, goldCost,
				handCost, quantity, cost, photoLink, note, photoName };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}
	
	@Override
	public Product selectId(Product product) {
		// TODO Auto-generated method stub
		//int id = product.getId();
		String strSQL ="select * from product order by id desc limit 1 ";
		ResultSet rs = sqlManager
				.execQuery(connection, strSQL, new Object[] {});
		
			try {
				while(rs.next()){
					
					product.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return product;
	}


	@Override
	public int updatePid(Product product) {
		// TODO Auto-generated method stub
		int id = product.getId();
		//int pid = product.getPid();
		String strSQL = "update product set pid = ? where id = ?";
		Object[] params = { id,id };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}

	

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product selectProductByPID(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectProductsBySupplier(String supplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectAllProducts() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();

		/* StringBuffer selectitem = new StringBuffer(); */

		String selectItem = "id,pid,name,supplier,leader,tel,certificateNum,component,size,weight,subStone,mainStone,goldCost,handCost,quantity,cost,photoLink,note,photoName";
		String strSQL = "select " + selectItem
				+ " from product order by id desc";
		ResultSet rs = sqlManager
				.execQuery(connection, strSQL, new Object[] {});

		try {

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setPid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setSupplier(rs.getString(4));
				product.setLeader(rs.getString(5));

				product.setTel(rs.getString(6));
				product.setCertificateNum(rs.getString(7));
				product.setComponent(rs.getString(8));
				product.setSize(rs.getString(9));
				product.setWeight(rs.getDouble(10));

				product.setSubStone(rs.getString(11));
				product.setMainStone(rs.getString(12));
				product.setGoldCost(rs.getDouble(13));
				product.setHandCost(rs.getDouble(14));
				product.setQuantity(rs.getInt(15));

				product.setCost(rs.getDouble(16));
				product.setPhotoLink(rs.getString(17));
				product.setNote(rs.getString(18));
				product.setPhotoName(rs.getString(19));

				productList.add(product);
			}

			return productList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}

	}

	@Override
	public List<Product> getPagingList(int start, int number,
			Map<String, Object> searchItem) {

		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "id,pid,name,supplier,leader,tel,certificateNum,component,size,weight,subStone,mainStone,goldCost,handCost,quantity,cost,photoLink,note,photoName";

		strSQL.append(selectItem);
		strSQL.append(" from product");
		strSQL.append(" where 1=1");

		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" = ");
			strSQL.append(entry.getValue());
		}

		strSQL.append(" order by id desc limit ?,?");
		/*List<Product> productList = new ArrayList<Product>();*/

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(),
				new Object[] { start, number });
		return this.resultSetToList(rs);
		
		
		
//		try {
//
//			while (rs.next()) {
//				Product product = new Product();
//				product.setId(rs.getInt(1));
//				product.setPid(rs.getString(2));
//				product.setName(rs.getString(3));
//				product.setSupplier(rs.getString(4));
//				product.setLeader(rs.getString(5));
//
//				product.setTel(rs.getString(6));
//				product.setCertificateNum(rs.getString(7));
//				product.setComponent(rs.getString(8));
//				product.setSize(rs.getString(9));
//				product.setWeight(rs.getInt(10));
//
//				product.setSubStone(rs.getString(11));
//				product.setMainStone(rs.getString(12));
//				product.setGoldCost(rs.getDouble(13));
//				product.setHandCost(rs.getDouble(14));
//				product.setQuantity(rs.getInt(15));
//
//				product.setCost(rs.getDouble(16));
//				product.setPhotoLink(rs.getString(17));
//				product.setNote(rs.getString(18));
//				product.setPhotoName(rs.getString(19));
//
//				productList.add(product);
//			}
//
//			return productList;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} finally {
//			connectionManager.closeConnection(connection);
//		}
	}

	@Override
	public int getCountForSearch(Map<String, Object> searchItem) {
		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "count(id)";

		strSQL.append(selectItem);
		strSQL.append(" from product");
		strSQL.append(" where 1=1");

		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" = ");
			strSQL.append(entry.getValue());
		}

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString());
		int count;
		try {
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			connectionManager.closeConnection(connection);
		}
		return count;
	}

	@Override
	public Product getProductById(int id) {
		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "id,pid,name,supplier,leader,tel,certificateNum,component,size,weight,subStone,mainStone,goldCost,handCost,quantity,cost,photoLink,note,photoName";

		strSQL.append(selectItem);
		strSQL.append(" from product");
		strSQL.append(" where 1=1");
		strSQL.append(" and id=" + id);

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(),new Object[]{});
		return this.resultSetToList(rs).get(0);
		
//		Product product = new Product();
//		try {
//			while (rs.next()) {
//				product.setId(rs.getInt(1));
//				product.setPid(rs.getString(2));
//				product.setName(rs.getString(3));
//				product.setSupplier(rs.getString(4));
//				product.setLeader(rs.getString(5));
//
//				product.setTel(rs.getString(6));
//				product.setCertificateNum(rs.getString(7));
//				product.setComponent(rs.getString(8));
//				product.setSize(rs.getString(9));
//				product.setWeight(rs.getInt(10));
//
//				product.setSubStone(rs.getString(11));
//				product.setMainStone(rs.getString(12));
//				product.setGoldCost(rs.getDouble(13));
//				product.setHandCost(rs.getDouble(14));
//				product.setQuantity(rs.getInt(15));
//
//				product.setCost(rs.getDouble(16));
//				product.setPhotoLink(rs.getString(17));
//				product.setNote(rs.getString(18));
//				product.setPhotoName(rs.getString(19));
//			}
//
//			return product;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		} finally {
//			connectionManager.closeConnection(connection);
//		}

	}
	
	private List<Product>  resultSetToList(ResultSet rs){
		try {
			List<Product> productList = new ArrayList<Product>();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setPid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setSupplier(rs.getString(4));
				product.setLeader(rs.getString(5));

				product.setTel(rs.getString(6));
				product.setCertificateNum(rs.getString(7));
				product.setComponent(rs.getString(8));
				product.setSize(rs.getString(9));
				product.setWeight(rs.getDouble(10));

				product.setSubStone(rs.getString(11));
				product.setMainStone(rs.getString(12));
				product.setGoldCost(rs.getDouble(13));
				product.setHandCost(rs.getDouble(14));
				product.setQuantity(rs.getInt(15));

				product.setCost(rs.getDouble(16));
				product.setPhotoLink(rs.getString(17));
				product.setNote(rs.getString(18));
				product.setPhotoName(rs.getString(19));

				productList .add(product);
			}

			return productList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
		
	}


	
}
