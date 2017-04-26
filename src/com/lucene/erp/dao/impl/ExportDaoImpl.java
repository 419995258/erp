package com.lucene.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.ExportDao;
import com.lucene.erp.datasource.ConnectionManager;
import com.lucene.erp.datasource.SQLManager;
import com.lucene.erp.domain.Export;
import com.lucene.erp.domain.ExportVo;
import com.lucene.erp.domain.Product;
import com.lucene.erp.domain.SaleVo;
import com.mysql.jdbc.Connection;

public class ExportDaoImpl implements ExportDao {
	ConnectionManager connectionManager = new ConnectionManager();
	Connection connection = (Connection) connectionManager.openConnection();
	SQLManager sqlManager = new SQLManager();
	
	@Override
	public Export selectExportByCode(String barCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Export> selectAllExports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertExport(Export export) {
		// TODO Auto-generated method stub
		String barCode = export.getBarCode();
		String receiveDept = export.getReceiveDept();
		String receiver = export.getReceiver();
		Date receiveTime = export.getReceiveTime();
		int quantity = export.getQuantity();
		double retaPrice = export.getRetaPrice();
		String note = export.getNote();
		int pid = export.getPid();
		String strSQL = "insert into export(barCode,receiveDept,receiver,receiveTime,quantity,retaPrice,note,pid)values(?,?,?,?,?,?,?,?)";
		Object[] params = { barCode, receiveDept, receiver, receiveTime, quantity, retaPrice, note,pid};
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		if(affectRows>0){
			return true;
		}else {
			return false;
			
		}
	}

	@Override
	public List<Export> getPagingList(int start, int number,
			Map<String, Object> searchItem) {
		StringBuilder strSQL = new StringBuilder("select ");
//		String selectItem = "id,barCode,receiveDept,receiver,receiveTime,quantity,retaPrice,export.note as enote,name,weight,subStone,mainStone,goldCost,handCost";

		String selectItem = "*,product.pid as ppid";
		strSQL.append(selectItem);
		strSQL.append(" from export left join product on export.pid = product.id");
  		strSQL.append(" where 1=1 and product.id = export.pid");

		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" = ");
			strSQL.append(entry.getValue());
		}

		strSQL.append(" order by export.id asc limit ?,?");
		/*List<Product> productList = new ArrayList<Product>();*/

      		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(),
				new Object[] { start, number });
		return this.resultSetToList(rs);
	}

	@Override
	public int getCountForSearch(Map<String, Object> searchItem) {
		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "count(id)";

		strSQL.append(selectItem);
		strSQL.append(" from export");
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
	
	private List<Export>  resultSetToList(ResultSet rs){
		try {
			List<Export> exportList = new ArrayList<Export>();
			while (rs.next()) {
				Export export = new Export();
				export.setId(rs.getInt("id"));
				export.setBarCode(rs.getString("barCode"));
				export.setReceiveDept(rs.getString("receiveDept"));
				export.setReceiver(rs.getString("receiver"));
				export.setReceiveTime(rs.getTimestamp("receiveTime"));
				export.setQuantity(rs.getInt("quantity"));
				export.setRetaPrice(rs.getDouble("retaPrice"));
				export.setNote(rs.getString("note"));
				export.setPid(rs.getInt("pid"));
				
				Product product = new Product();			
				product.setPid(rs.getInt("ppid"));
				product.setName(rs.getString("name"));
				product.setSize(rs.getString("size"));
				product.setWeight(rs.getInt("weight"));
				product.setSubStone(rs.getString("subStone"));
				product.setMainStone(rs.getString("mainStone"));
				product.setGoldCost(rs.getDouble("goldCost"));
				product.setHandCost(rs.getDouble("handCost"));
				export.setProduct(product);
				
				exportList.add(export);
			}

			return exportList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
//			connectionManager.closeConnection(connection);
		}
		
	}

	@Override
	public int updateProductNum(int quantity,int id) {
		// TODO Auto-generated method stub
		String strSQL = "update product set quantity = ? where id = ?";
		Object[] params = { quantity, id};
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		if(affectRows>0){
			return 1;
		}else {
			return 0;
			
		}
	}

	@Override
	public int selectProductNum(int id) {
		// TODO Auto-generated method stub
		int quantity = 0;
		String strSQL ="select quantity from product where id = ? ";
		Object[] params = {id};
		ResultSet rs = sqlManager
				.execQuery(connection, strSQL,params);
		
			try {
				while(rs.next()){
					
					quantity = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return quantity;
	}

	@Override
	public List<ExportVo> getMatterPagingList(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select");
		String selectItem = " t.id, t.pid,t.receiveDept,t.receiver,t.receiveTime,t.quantity,t.retaPrice,t.note,t1.name,t1.size ";
		strSQL.append(selectItem);
		strSQL.append(" FROM export t INNER JOIN product t1 ON t.pid=t1.id WHERE 1=1");
		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" like ");
			strSQL.append("'" + entry.getValue() + "'");
		}

		strSQL.append(" order by t.id desc limit ?,?");
		System.out.println(strSQL);
		List<ExportVo> exportVoList = new ArrayList<ExportVo>();

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] { start, number });

		try {

			while (rs.next()) {
				ExportVo exportVo= new ExportVo();
				exportVo.setPid(rs.getInt("pid"));
				exportVo.setName(rs.getString("name"));
				exportVo.setSize(rs.getString("size"));
				exportVo.setReceiveDept(rs.getString("receiveDept"));
				exportVo.setReceiver(rs.getString("receiver"));
				exportVo.setReceiveTime(rs.getDate("receiveTime"));
				exportVo.setQuantity(rs.getInt("quantity"));
				exportVo.setRetaPrice(rs.getDouble("retaPrice"));
				exportVo.setNote(rs.getString("note"));
				exportVo.setAllMoney(exportVo.getQuantity() * exportVo.getRetaPrice());
				
				
				
				exportVoList.add(exportVo);
			}

			return exportVoList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public int getMatterCountForSearch() {
		// TODO Auto-generated method stub
		String strSQL = "SELECT COUNT(*) AS COUNT FROM export t INNER JOIN product t1 ON t.pid=t1.id WHERE 1=1 ";
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
			//connectionManager.closeConnection(connection);
		}
		return count;
	}

}
