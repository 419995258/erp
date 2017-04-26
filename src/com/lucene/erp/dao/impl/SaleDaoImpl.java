package com.lucene.erp.dao.impl;

import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.SaleDao;
import com.lucene.erp.datasource.ConnectionManager;
import com.lucene.erp.datasource.SQLManager;
import com.lucene.erp.domain.Attend;
import com.lucene.erp.domain.Customer;
import com.lucene.erp.domain.Inventory;
import com.lucene.erp.domain.Product;
import com.lucene.erp.domain.ResultVo;
import com.lucene.erp.domain.Sale;
import com.lucene.erp.domain.SaleVo;
import com.lucene.erp.domain.Traffic;
import com.lucene.erp.domain.User;
import com.lucene.erp.util.DateUtil;
import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class SaleDaoImpl implements SaleDao {
	ConnectionManager connectionManager = new ConnectionManager();
	Connection connection = (Connection) connectionManager.openConnection();
	SQLManager sqlManager = new SQLManager();

	@Override
	public int insertSale(Sale sale) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Sale> selectAllSales() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<Sale> selectSalesByConsultant(String consultant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sale selectSaleByPID(String pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertDiySale(Sale sale) {
		// TODO Auto-generated method stub
		int sid = sale.getSid();
		String diyNum = sale.getDiyNum();
		Date diyDate = sale.getDiyDate();
		Date deliverDate = sale.getDeliverDate();
		int quantity = sale.getQuantity();

		double retaPrice = sale.getRetaPrice();
		double deposit = sale.getDeposit();
		double billing = sale.getBilling();
		String cashier = sale.getCashier();
		String diyConsultant = sale.getDiyConsultant();

		String customerArchive = sale.getCustomerArchive();
		int pid = sale.getPid();
		int cid = sale.getCid();
		String note = sale.getNote();
		String customerArchiveName = sale.getCustomerArchiveName();

		int userId = sale.getUserId();
		String userName = sale.getUserName();
		String strSQL = "insert into sale(sid,diyNum,diyDate,deliverDate,quantity,"
				+ "retaPrice,deposit,billing,cashier,diyConsultant,customerArchive,pid,cid,note,customerArchiveName,user_id,user_name)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { sid, diyNum, diyDate, deliverDate, quantity, retaPrice, deposit, billing, cashier,
				diyConsultant, customerArchive, pid, cid, note, customerArchiveName, userId, userName };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}

	@Override
	public Sale selectId(Sale sale) {
		// TODO Auto-generated method stub
		String strSQL = "select * from sale order by id desc limit 1 ";
		ResultSet rs = sqlManager.execQuery(connection, strSQL, new Object[] {});

		try {
			while (rs.next()) {

				sale.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sale;
	}

	@Override
	public int updateSid(Sale sale) {
		// TODO Auto-generated method stub
		int id = sale.getId();
		// int pid = product.getPid();
		String strSQL = "update sale set sid = ? where id = ?";
		Object[] params = { id, id };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}

	@Override
	public List<Sale> selectAllDiySales() {
		// TODO Auto-generated method stub
		List<Sale> saleList = new ArrayList<Sale>();
		String strSQL = "select * from sale order by id desc";
		ResultSet rs = sqlManager.execQuery(connection, strSQL, new Object[] {});
		try {
			while (rs.next()) {
				Sale sale = new Sale();
				sale.setId(rs.getInt(1));
				sale.setSid(rs.getInt(2));
				sale.setDiyNum(rs.getString(3));
				sale.setDiyDate(rs.getDate(4));
				sale.setDeliverDate(rs.getDate(5));
				sale.setQuantity(rs.getInt(6));
				sale.setRetaPrice(rs.getDouble(7));
				sale.setDeposit(rs.getDouble(8));
				sale.setBilling(rs.getDouble(9));
				sale.setCashier(rs.getString(10));
				sale.setDiyConsultant(rs.getString(11));
				sale.setCustomerArchive(rs.getString(12));
				sale.setNote(rs.getString(13));
				sale.setPid(rs.getInt(14));
				sale.setCid(rs.getInt(15));
				;

				sale.setCustomerArchiveName(rs.getString(16));

				saleList.add(sale);
			}
			return saleList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}

	}

	//
	@Override
	public List<Sale> getPagingList(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub

		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "sale.id,sid,diyNum,diyDate,deliverDate,quantity,retaPrice,deposit,billing,cashier,diyConsultant,customerArchive,sale.note,"
				+ "sale.pid,sale.cid,customerArchiveName, customer.name,customer.tel";
		strSQL.append(selectItem);
		strSQL.append(" from sale,customer ");
		strSQL.append(" where sale.cid = customer.id");

		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" = ");
			strSQL.append(entry.getValue());
		}

		strSQL.append(" order by id desc limit ?,?");
		List<Sale> saleList = new ArrayList<Sale>();

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] { start, number });

		try {

			while (rs.next()) {
				Sale sale = new Sale();
				sale.setId(rs.getInt(1));
				sale.setSid(rs.getInt(2));
				sale.setDiyNum(rs.getString(3));
				sale.setDiyDate(rs.getDate(4));
				sale.setDeliverDate(rs.getDate(5));
				sale.setQuantity(rs.getInt(6));
				sale.setRetaPrice(rs.getDouble(7));
				sale.setDeposit(rs.getDouble(8));
				sale.setBilling(rs.getDouble(9));
				sale.setCashier(rs.getString(10));
				sale.setDiyConsultant(rs.getString(11));
				sale.setCustomerArchive(rs.getString(12));
				sale.setNote(rs.getString(13));
				sale.setPid(rs.getInt(14));
				sale.setCid(rs.getInt(15));
				;
				sale.setCustomerArchiveName(rs.getString(16));

				Customer customer = new Customer();
				customer.setName(rs.getString(17));
				customer.setTel(rs.getString(18));
				sale.setCustomer(customer);

				saleList.add(sale);
			}

			return saleList;
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
		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "count(id)";

		strSQL.append(selectItem);
		strSQL.append(" from sale");
		strSQL.append(" where 1=1");

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
			connectionManager.closeConnection(connection);
		}
		return count;
	}

	@Override
	public Sale getSaleById(int id) {
		StringBuilder strSQL = new StringBuilder("select ");
		String selectItem = "id,sid,diyNum,diyDate,deliverDate,quantity,"
				+ "retaPrice,deposit,billing,cashier,diyConsultant,customerArchive,note,pid,cid,customerArchiveName";

		strSQL.append(selectItem);
		strSQL.append(" from sale");
		strSQL.append(" where 1=1");
		strSQL.append(" and id=" + id);

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] {});
		Sale sale = new Sale();
		try {
			while (rs.next()) {
				sale.setId(rs.getInt(1));
				sale.setSid(rs.getInt(2));
				sale.setDiyNum(rs.getString(3));
				sale.setDiyDate(rs.getDate(4));
				sale.setDeliverDate(rs.getDate(5));
				sale.setQuantity(rs.getInt(6));
				sale.setRetaPrice(rs.getDouble(7));
				sale.setDeposit(rs.getDouble(8));
				sale.setBilling(rs.getDouble(9));
				sale.setCashier(rs.getString(10));
				sale.setDiyConsultant(rs.getString(11));
				sale.setCustomerArchive(rs.getString(12));
				sale.setNote(rs.getString(13));
				sale.setPid(rs.getInt(14));
				sale.setCid(rs.getInt(15));
				;

				sale.setCustomerArchiveName(rs.getString(16));

			}

			return sale;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}

	}

	@Override
	public int updateDiyById(Sale sale) {
		// TODO Auto-generated method stub
		int id = sale.getId();
		String diyNum = sale.getDiyNum();
		Date diyDate = sale.getDiyDate();
		Date deliverDate = sale.getDeliverDate();
		int quantity = sale.getQuantity();
		double retaPrice = sale.getRetaPrice();
		double deposit = sale.getDeposit();
		double billing = sale.getBilling();
		String cashier = sale.getCashier();
		String diyConsultant = sale.getDiyConsultant();
		String note = sale.getNote();
		String strSQL = "update sale set diyNum = ?,diyDate = ?,deliverDate = ?,quantity = ?,retaPrice = ?,deposit = ?,billing = ?,cashier=?,diyConsultant=?,note=? where id = ?";
		Object[] params = { diyNum, diyDate, deliverDate, quantity, retaPrice, deposit, billing, cashier, diyConsultant,
				note, id };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}

	@Override
	public List<User> queryAllDIANPU() {

		List<User> userList = new ArrayList<>();
		String strSQL = "select * from user where type=3";
		ResultSet rs = sqlManager.execQuery(connection, strSQL, new Object[] {});
		try {
			try {
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPwd(rs.getString("pwd"));
					user.setMobile(rs.getString("mobile"));
					user.setStatus(rs.getInt("status"));
					user.setType(rs.getInt("type"));
					user.setName(rs.getString("name"));
					userList.add(user);
				}
				// return userList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			// connectionManager.closeConnection(connection);
		}
		return userList;
	}

	/**
	 * 日统计
	 */
	public ResultVo queryAnalyDay(ResultVo resultVo) {
		// TODO Auto-generated method stub
		String strSQL = "SELECT	SUM(billing) as money FROM sale WHERE user_id = ? AND diyDate = ? ";
		Object[] params = { resultVo.getUserId(), resultVo.getDiyDate() };
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);

		try {
			while (rs.next()) {

				resultVo.setMoney(rs.getDouble("money"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultVo;
	}

	@Override
	public ResultVo queryAnalyMonth(ResultVo resultVo) {
		// TODO Auto-generated method stub
		String strSQL = "SELECT	SUM(billing) as money FROM sale WHERE user_id = ? AND DATE_FORMAT(diyDate,'%Y-%m') = ? ";
		Object[] params = { resultVo.getUserId(), resultVo.getStrDiyDate() };
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);

		try {
			while (rs.next()) {

				resultVo.setMoney(rs.getDouble("money"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultVo;
	}

	@Override
	public ResultVo queryAnalyYear(ResultVo resultVo) {
		// TODO Auto-generated method stub
		String strSQL = "SELECT	SUM(billing) as money FROM sale WHERE user_id = ? AND DATE_FORMAT(diyDate,'%Y') = ? ";
		Object[] params = { resultVo.getUserId(), resultVo.getStrDiyDate() };
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);

		try {
			while (rs.next()) {

				resultVo.setMoney(rs.getDouble("money"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultVo;
	}

	@Override
	public List<SaleVo> getPagingListOrder(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select");
		String selectItem = " t1.pid,t.diyNum,t2.name,t2.tel,t.diyDate,t.deliverDate,t1.weight,t1.subStone,t1.mainStone,t1.goldCost,t1.handCost,t.quantity,t1.cost,t.billing";
		strSQL.append(selectItem);
		strSQL.append(
				" FROM sale t INNER JOIN product t1 ON t.pid = t1.pid INNER JOIN customer t2 ON t.cid = t2.id where 1=1");
		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" like ");
			strSQL.append("'" + entry.getValue() + "'");
		}

		strSQL.append(" order by t.diyNum desc limit ?,?");
		System.out.println(strSQL);
		List<SaleVo> saleVoList = new ArrayList<SaleVo>();

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] { start, number });

		try {

			while (rs.next()) {
				SaleVo saleVo = new SaleVo();
				saleVo.setPid(rs.getInt("pid"));
				saleVo.setDiyNum(rs.getString("diyNum"));
				saleVo.setName(rs.getString("name"));
				saleVo.setTel(rs.getString("tel"));
				saleVo.setDiyDate(rs.getDate("diyDate"));
				saleVo.setDeliverDate(rs.getString("deliverDate"));
				saleVo.setWeight(rs.getDouble("weight"));
				saleVo.setSubStone(rs.getString("subStone"));
				saleVo.setMainStone(rs.getString("mainStone"));
				saleVo.setGoldCost(rs.getDouble("goldCost"));
				saleVo.setHandCost(rs.getDouble("handCost"));
				saleVo.setQuantity(rs.getInt("quantity"));
				saleVo.setCost(rs.getDouble("cost"));
				saleVo.setBilling(rs.getDouble("billing"));

				saleVoList.add(saleVo);
			}

			return saleVoList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public int getSaleOrderCount() {
		// TODO Auto-generated method stub
		String strSQL = "SELECT COUNT(*) AS COUNT FROM sale t INNER JOIN product t1 ON t.pid = t1.pid INNER JOIN customer t2 ON t.cid = t2.id";
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
	public int insertAttend(Attend attend) {
		// TODO Auto-generated method stub
		String name = attend.getName();
		String attendday = attend.getAttendday();
		String passday = attend.getPassday();
		String restday = attend.getRestday();
		String sickday = attend.getSickday();
		String leaveday = attend.getLeaveday();
		String allday = attend.getAllday();
		String lateday = attend.getLateday();
		String inday = attend.getInday();
		String overday = attend.getOverday();
		String leader = attend.getLeader();
		String surer = attend.getSurer();
		String note = attend.getNote();
		Date nowdate = attend.getNowdate();
		int userId = attend.getUserId();
		String userName = attend.getUserName();

		String strSQL = "insert into attend(name,attendday,passday,restday,sickday,"
				+ "leaveday,allday,lateday,inday,overday,leader,surer,note,nowdate,user_id,user_name)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { name, attendday, passday, restday, sickday, leaveday, allday, lateday, inday, overday,
				leader, surer, note, nowdate, userId, userName };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}

	@Override
	public List<Attend> getAttendPagingListOrder(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select");
		String selectItem = " *";
		strSQL.append(selectItem);
		strSQL.append(" FROM attend t where 1=1");
		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" like ");
			strSQL.append("'" + entry.getValue() + "'");
		}

		strSQL.append(" order by id desc limit ?,?");
		System.out.println(strSQL);
		List<Attend> attendList = new ArrayList<Attend>();

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] { start, number });

		try {

			while (rs.next()) {
				Attend attend = new Attend();
				attend.setId(rs.getInt(1));
				attend.setName(rs.getString(2));
				attend.setNowdate(rs.getDate(3));
				attend.setAttendday(rs.getString(4));
				attend.setPassday(rs.getString(5));
				attend.setRestday(rs.getString(6));
				attend.setSickday(rs.getString(7));
				attend.setLeaveday(rs.getString(8));
				attend.setAllday(rs.getString(9));
				attend.setLateday(rs.getString(10));
				attend.setInday(rs.getString(11));
				attend.setOverday(rs.getString(12));
				attend.setLeader(rs.getString(13));
				attend.setSurer(rs.getString(14));
				attend.setNote(rs.getString(15));
				attend.setUserId(rs.getInt(16));
				attend.setUserName(rs.getString(17));

				attendList.add(attend);
			}

			return attendList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public int getAttendCount() {
		// TODO Auto-generated method stub
		String strSQL = "SELECT COUNT(*) AS COUNT FROM attend ";
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
	public int insertTraffic(Traffic traffic) {
		// TODO Auto-generated method stub

		String strSQL = "insert into traffic(innum,intime,outtime,type,age,"
				+ "pid,reason,diyConsultant,note,user_id,user_name)values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { traffic.getInnum(), traffic.getIntime(), traffic.getOuttime(), traffic.getType(),
				traffic.getAge(), traffic.getPid(), traffic.getReason(), traffic.getDiyConsultant(), traffic.getNote(),
				traffic.getUserId(), traffic.getUserName() };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}

	@Override
	public List<Traffic> getTrafficPagingListOrder(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select");
		String selectItem = " *";
		strSQL.append(selectItem);
		strSQL.append(" FROM traffic t where 1=1");
		Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" like ");
			strSQL.append("'" + entry.getValue() + "'");
		}

		strSQL.append(" order by id desc limit ?,?");
		System.out.println(strSQL);
		List<Traffic> trafficList = new ArrayList<Traffic>();

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] { start, number });

		try {

			while (rs.next()) {
				Traffic traffic = new Traffic();
				traffic.setId(rs.getInt(1));
				traffic.setInnum(rs.getString(2));
				traffic.setIntime(rs.getDate(3));
				traffic.setOuttime(rs.getDate(4));
				traffic.setType(rs.getString(5));
				traffic.setAge(rs.getString(6));
				traffic.setPid(rs.getInt(7));
				traffic.setReason(rs.getString(8));
				traffic.setDiyConsultant(rs.getString(9));
				traffic.setNote(rs.getString(10));
				traffic.setUserId(rs.getInt(11));
				traffic.setUserName(rs.getString(12));
				trafficList.add(traffic);
			}

			return trafficList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public int getTrafficOrderCount() {
		// TODO Auto-generated method stub
		String strSQL = "SELECT COUNT(*) AS COUNT FROM traffic ";
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
	public int insertCheck(Inventory inventory) {
		// TODO Auto-generated method stub
		String strSQL = "insert into inventory(pid,superPlatPeople,inventoryPeople,inventoryTime,inventoryStock,note)"
				+ "values(?,?,?,?,?,?)";
		Object[] params = { inventory.getPid(),inventory.getSuperPlatPeople(),inventory.getInventoryPeople(),inventory.getInventoryTime(),inventory.getInventoryStock(),inventory.getNote() };
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
	}

	@Override
	public List<Inventory> getCheckPagingListOrder(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select");
		String selectItem = " t.id,t.pid,t1.name,t.superPlatPeople,t.inventoryPeople,t.inventoryTime,t1.quantity,t.inventoryStock,t.note";
		strSQL.append(selectItem);
		strSQL.append(
				" FROM inventory t INNER JOIN product t1 ON t.pid = t1.id  where 1=1");
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
		List<Inventory> inventoryList = new ArrayList<Inventory>();

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] { start, number });

		try {

			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setId(rs.getInt("id"));
				inventory.setPid(rs.getInt("pid"));
				inventory.setName(rs.getString("name"));
				inventory.setSuperPlatPeople(rs.getString("superPlatPeople"));
				inventory.setInventoryPeople(rs.getString("inventoryPeople"));
				inventory.setInventoryTime(rs.getDate("inventoryTime"));
				inventory.setQuantity(rs.getInt("quantity"));
				inventory.setInventoryStock(rs.getInt("inventoryStock"));
				inventory.setNote(rs.getString("note"));;
				inventory.setChangeStock(inventory.getQuantity() - inventory.getInventoryStock());
				inventoryList.add(inventory);
			}

			return inventoryList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public int getCheckCount() {
		// TODO Auto-generated method stub
		String strSQL = "SELECT COUNT(*) AS COUNT FROM inventory ";
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
