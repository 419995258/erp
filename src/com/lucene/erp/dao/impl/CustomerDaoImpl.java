package com.lucene.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.CustomerDao;
import com.lucene.erp.datasource.ConnectionManager;
import com.lucene.erp.datasource.SQLManager;
import com.lucene.erp.domain.Customer;
import com.lucene.erp.util.DynamicSQL;
import com.mysql.jdbc.Connection;

public class CustomerDaoImpl implements CustomerDao {
	// 获取connection连接
	ConnectionManager connectionManager = new ConnectionManager();
	Connection connection = (Connection) connectionManager.openConnection();
	SQLManager sqlManager = new SQLManager();

	@Override
	public int insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int id = customer.getId();
		String name = customer.getName();
		String tel = customer.getTel();
		Date birthday = customer.getBirthday();
		String address = customer.getAddress();
		String email = customer.getEmail();
		double saleAmount = customer.getSaleAmount();
		String record = customer.getRecord();
		String note = customer.getNote();

		String strSQL = "insert into customer(id,name,tel,birthday,address,email,saleAmount,record,note,user_id,user_name)values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { id, name, tel, birthday, address, email, saleAmount, record, note,customer.getUserId(),customer.getUserName() };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<Customer>();
		String strSQL = "select * from customer order by id desc";
		ResultSet rs = sqlManager.execQuery(connection, strSQL, new Object[] {});
		try {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt(1));
				//customer.setCid(rs.getInt(2));
				customer.setName(rs.getString(2));
				customer.setTel(rs.getString(3));
				customer.setBirthday(rs.getDate(4));
				customer.setAddress(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setSaleAmount(rs.getDouble(7));
				customer.setRecord(rs.getString(8));
				customer.setNote(rs.getString(9));

				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}

	}

	@Override
	public Customer selectCustomerByCID(int id) {

		// TODO Auto-generated method stub
		// List<Customer> customerList = new ArrayList<Customer>();
		String strSQL = "select * from customer where id = ? ";
		Object[] params = { id };
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);
		Customer customer = new Customer();
		try {
			while (rs.next()) {
				customer.setId(rs.getInt(1));
				//customer.setCid(rs.getInt(2));
				customer.setName(rs.getString(2));
				customer.setTel(rs.getString(3));
				customer.setBirthday(rs.getDate(4));
				customer.setAddress(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setSaleAmount(rs.getDouble(7));
				customer.setRecord(rs.getString(8));
				customer.setNote(rs.getString(9));
			}
			return customer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public List<Customer> selectCustomerByName(String name) {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<Customer>();
		String strSQL = "select * from customer where name = ? order by id desc";
		Object[] params = { name };
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);
		try {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt(1));
				//customer.setCid(rs.getInt(2));
				customer.setName(rs.getString(2));
				customer.setTel(rs.getString(3));
				customer.setBirthday(rs.getDate(4));
				customer.setAddress(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setSaleAmount(rs.getDouble(7));
				customer.setRecord(rs.getString(8));
				customer.setNote(rs.getString(9));

				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public Customer selectCustomerByTel(String tel) {
		// TODO Auto-generated method stub
		String strSQL = "select * from customer where tel = ? ";
		Object[] params = { tel };
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);
		Customer customer = new Customer();
		try {
			while (rs.next()) {
				customer.setId(rs.getInt(1));
				//customer.setCid(rs.getInt(2));
				customer.setName(rs.getString(2));
				customer.setTel(rs.getString(3));
				customer.setBirthday(rs.getDate(4));
				customer.setAddress(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setSaleAmount(rs.getDouble(7));
				customer.setRecord(rs.getString(8));
				customer.setNote(rs.getString(9));
			}
			return customer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> selectCustomerByCidTelCname(String id, String tel, String name) {
		List<Customer> customerList = new ArrayList<Customer>();
		DynamicSQL dsql = new DynamicSQL();
		dsql.append("             select * from customer  ");
		dsql.append("where 1=1 ");
		dsql.isNotEmpty(id, " and id = #");
		dsql.isNotEmpty(tel, "  and tel = #");
		dsql.isNotEmpty("%" + name + "%", "  and name LIKE #");
		dsql.append("order by id desc");
		Object[] params = {};
		ResultSet rs = sqlManager.execQuery(connection, dsql.toString(), params);
		try {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt(1));
				//customer.setCid(rs.getInt(2));
				customer.setName(rs.getString(2));
				customer.setTel(rs.getString(3));
				customer.setBirthday(rs.getDate(4));
				customer.setAddress(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setSaleAmount(rs.getDouble(7));
				customer.setRecord(rs.getString(8));
				customer.setNote(rs.getString(9));
				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connectionManager.closeConnection(connection);
			}
		}

	}

	public static void main(String[] args) {
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		System.out.println(customerDaoImpl.selectCustomerByCidTelCname("", "", "65").toString());
	}

	@Override
	public List<Customer> getPagingList(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "id,name,tel,birthday,address,email,saleAmount,record,note,firService,secService,thrService,fouService,serviceLeader";

		strSQL.append(selectItem);
		strSQL.append(" from customer ");
		strSQL.append(" where 1=1");

		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" like ");
			strSQL.append("'" + entry.getValue() + "'");
		}

		strSQL.append(" order by id desc limit ?,?");
		List<Customer> customerList = new ArrayList<Customer>();

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] { start, number });
		try {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt(1));
				//customer.setCid(rs.getInt(2));
				customer.setName(rs.getString(2));
				customer.setTel(rs.getString(3));
				customer.setBirthday(rs.getDate(4));
				customer.setAddress(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setSaleAmount(rs.getDouble(7));
				customer.setRecord(rs.getString(8));
				customer.setNote(rs.getString(9));
				customer.setFirService(rs.getString(10));
				customer.setSecService(rs.getString(11));
				customer.setThrService(rs.getString(12));
				customer.setFouService(rs.getString(13));
				customer.setServiceLeader(rs.getString(14));
				
				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public int getCountForSearch(Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "count(id)";

		strSQL.append(selectItem);
		strSQL.append(" from customer");
		strSQL.append(" where 1=1");

		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" like ");
			strSQL.append("'" + entry.getValue() + "'");
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
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "*";

		strSQL.append(selectItem);
		strSQL.append(" from customer");
		strSQL.append(" where 1=1");
		strSQL.append(" and id=" + id);

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(),new Object[]{});
		Customer customer = new Customer();
		try {
			while (rs.next()) {
				
				customer.setId(rs.getInt(1));
				//customer.setCid(rs.getInt(2));
				customer.setName(rs.getString(2));
				customer.setTel(rs.getString(3));
				customer.setBirthday(rs.getDate(4));
				customer.setAddress(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setSaleAmount(rs.getDouble(7));
				customer.setRecord(rs.getString(8));
				customer.setNote(rs.getString(9));
				customer.setFirService(rs.getString(10));
				customer.setSecService(rs.getString(11));
				customer.setThrService(rs.getString(12));
				customer.setFouService(rs.getString(13));
				customer.setServiceLeader(rs.getString(14));
				
			}

			return customer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}

	}

	@Override
	public int updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		int id = customer.getId();
		//int cid = customer.getCid();
		String name = customer.getName();
		String tel = customer.getTel();
		Date birthday = customer.getBirthday();
		String address = customer.getAddress();
		String email = customer.getEmail();
		double saleAmount = customer.getSaleAmount();
		String record = customer.getRecord();
		String note = customer.getNote();
		String strSQL = "update customer set name = ?,tel = ?,birthday = ?,address = ?,email = ?,saleAmount = ?,record = ?,note = ? where id = ?";
		Object[] params = {  name, tel, birthday, address, email, saleAmount, record, note,id };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}

	@Override
	public int updateCustomerServiceById(Customer customer) {
		// TODO Auto-generated method stub
		int id = customer.getId();
		//String cid = customer.getCid();
		String firService = customer.getFirService();
		String secService = customer.getSecService();
		String thrService = customer.getThrService();
		String fouService = customer.getFouService();
		String serviceLeader = customer.getServiceLeader();
		String note = customer.getNote();
		String strSQL = "update customer set firService = ?,secService = ?,thrService = ?,fouService = ?,serviceLeader = ?,note = ? where id = ?";
		Object[] params = {  firService, secService, thrService, fouService,serviceLeader, note,id };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;		
	}

}
