package com.lucene.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.StatisticDao;
import com.lucene.erp.datasource.ConnectionManager;
import com.lucene.erp.datasource.SQLManager;
import com.lucene.erp.domain.Statistic;
import com.lucene.erp.domain.User;
import com.mysql.jdbc.Connection;

public class StatisticDaoImpl implements StatisticDao {
	ConnectionManager connectionManager = new ConnectionManager();
	Connection connection = (Connection) connectionManager.openConnection();
	SQLManager sqlManager = new SQLManager();

	@Override
	public List<Statistic> getDayPagingList(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select");
		String selectItem = " t.quantity,t.billing,t.cashier,t.sid,t.note,t.pid,t.user_name,t1.cost,t.diyDate";
		strSQL.append(selectItem);
		strSQL.append(" FROM sale t INNER JOIN product t1 ON t.pid = t1.pid   where 1=1");
		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" = ");
			strSQL.append("'" + entry.getValue() + "'");
			// strSQL.append(" like ");
			// strSQL.append("'" + entry.getValue() + "'");
		}

		strSQL.append(" ORDER BY t.sid DESC limit ?,?");
		System.out.println(strSQL);
		List<Statistic> statisticList = new ArrayList<Statistic>();

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] { start, number });
		DecimalFormat df = new DecimalFormat("0.00");//精确到小数点后1位
		try {

			while (rs.next()) {
				Statistic statistic = new Statistic();
				statistic.setQuantity(rs.getInt("quantity"));
				statistic.setBilling(rs.getDouble("billing"));
				statistic.setCashier(rs.getString("cashier"));
				statistic.setSid(rs.getInt("sid"));
				statistic.setNote(rs.getString("note"));
				statistic.setPid(rs.getInt("pid"));
				statistic.setUserName(rs.getString("user_name"));
				statistic.setCost(rs.getDouble("cost"));
				statistic.setDiyDate(rs.getDate("diyDate"));
				statistic.setSaleMoney(statistic.getQuantity() * statistic.getBilling());
				statistic.setStrSaleMoney(df.format(statistic.getSaleMoney()));
				statistic.setImGet(statistic.getSaleMoney() - statistic.getQuantity() * statistic.getCost());
				statistic.setStrImGet(df.format(statistic.getImGet()));
				statisticList.add(statistic);
			}

			return statisticList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public int getDayCount() {
		// TODO Auto-generated method stub
		String strSQL = "SELECT COUNT(*) FROM sale t INNER JOIN product t1 ON t.pid = t1.pid  WHERE 1 = 1 ";
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
			// connectionManager.closeConnection(connection);
		}
		return count;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();
		String strSQL = "SELECT * FROM USER WHERE TYPE = 3 AND STATUS = 1";
		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString());
		try {
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setMobile(rs.getString("mobile"));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// connectionManager.closeConnection(connection);
		}
	}

	@Override
	public Statistic getMonthPagingList(int start, int number, String selectTime, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select");
		String selectItem = " SUM(t.quantity * t.billing) AS saleMoney,SUM(t.quantity * t.billing - t.quantity * t1.cost) AS imGet,t.user_name,t.user_id";
		strSQL.append(selectItem);
		strSQL.append(
				" FROM sale t INNER JOIN product t1 ON t.pid = t1.pid  where 1=1 ");
		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" = ");
			strSQL.append(entry.getValue());
		}

		strSQL.append(" limit ?,?");
		//System.out.println(strSQL);

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(),
				new Object[] { start, number });
		DecimalFormat df = new DecimalFormat("0.00");//精确到小数点后1位
		/*selectTime , */
		try {

			Statistic statistic = new Statistic();
			rs.next();
			int userId = rs.getInt("user_id");
			statistic.setUserId(userId);
			statistic.setSaleMoney(rs.getDouble("saleMoney"));
			statistic.setImGet(rs.getDouble("imGet"));
			statistic.setStrSaleMoney(df.format(rs.getDouble("saleMoney")));
			statistic.setStrImGet(df.format(rs.getDouble("imGet")));
			statistic.setUserName(rs.getString("user_name"));
			statistic.setGetpercent(statistic.getImGet() / statistic.getSaleMoney() * 100 );
			statistic.setStrGetpercent(df.format(statistic.getImGet() / statistic.getSaleMoney() * 100 ) + "%");

			return statistic;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			//connectionManager.closeConnection(connection);
		}
	}

	@Override
	public Statistic getYearPagingList(int start, int number, String selectTime, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select");
		String selectItem = " SUM(t.quantity * t.billing) AS saleMoney,SUM(t.quantity * t.billing - t.quantity * t1.cost) AS imGet,COUNT(*) AS saleNum,t.user_name,t.user_id";
		strSQL.append(selectItem);
		strSQL.append(
				" FROM sale t INNER JOIN product t1 ON t.pid = t1.pid  where 1=1 ");
		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" = ");
			strSQL.append(entry.getValue());
		}

		strSQL.append(" limit ?,?");
		//System.out.println(strSQL);

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(),
				new Object[] { start, number });
		DecimalFormat df = new DecimalFormat("0.00");//精确到小数点后1位
		/*selectTime , */
		try {

			Statistic statistic = new Statistic();
			rs.next();
			int userId = rs.getInt("user_id");
			statistic.setUserId(userId);
			statistic.setSaleMoney(rs.getDouble("saleMoney"));
			statistic.setImGet(rs.getDouble("imGet"));
			statistic.setStrSaleMoney(df.format(rs.getDouble("saleMoney")));
			statistic.setStrImGet(df.format(rs.getDouble("imGet")));
			statistic.setUserName(rs.getString("user_name"));
			statistic.setGetpercent(statistic.getImGet() / statistic.getSaleMoney() * 100 );
			statistic.setStrGetpercent(df.format(statistic.getImGet() / statistic.getSaleMoney() * 100 ) + "%");
			statistic.setSaleNum(rs.getInt("saleNum"));
			return statistic;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			//connectionManager.closeConnection(connection);
		}
	}

	@Override
	public int getCust(Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		
		StringBuilder strSQL = new StringBuilder("select");
		String selectItem = " COUNT(*) ";
		strSQL.append(selectItem);
		strSQL.append(
				" FROM customer WHERE 1 = 1 ");
		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
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
			// connectionManager.closeConnection(connection);
		}
		return count;
	}

}
