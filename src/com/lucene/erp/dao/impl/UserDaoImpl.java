package com.lucene.erp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.UserDao;
import com.lucene.erp.datasource.ConnectionManager;
import com.lucene.erp.datasource.SQLManager;
import com.lucene.erp.domain.Customer;
import com.lucene.erp.domain.Sale;
import com.lucene.erp.domain.User;
import com.mysql.jdbc.Connection;

public class UserDaoImpl implements UserDao {
	//获取connection连接
	ConnectionManager connectionManager =new ConnectionManager();
	Connection connection = (Connection) connectionManager.openConnection();
	SQLManager sqlManager = new SQLManager();
	
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		String pwd = user.getPwd();
		int type = user.getType();
		String name = user.getName();
		String strSQL = "insert into user(username,pwd,mobile,deptID,status,type,name)values(?,?,?,?,?,?,?)";
		Object[] params = { username, pwd, 0, 1, 1, type, name};
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		if(affectRows>0){
			return true;
		}else {
			return false;
			
		}
	}

	@Override
	public List<User> selectAllUsers() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();
		String strSQL = "select * from user";
		ResultSet rs = sqlManager.execQuery(connection,strSQL, new Object[] {});
		try{
			try {
				while(rs.next()){
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
				//return userList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			//connectionManager.closeConnection(connection);
		}
		return userList;
	}

	@Override
	public User selectUserByID(int id) {
		// TODO Auto-generated method stub
		
		User user = new User();
		String strSQL = "select * from user where id = ?";
		Object[] params = {id};
		ResultSet rs = sqlManager.execQuery(connection,strSQL, params);
		try{
			try {
				if(rs.next()){
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPwd(rs.getString("pwd"));
					user.setMobile(rs.getString("mobile"));
					user.setDeptID(rs.getInt("deptId"));
					user.setStatus(rs.getInt("status"));
					user.setType(rs.getInt("type"));
					user.setName(rs.getString("name"));
					
					return user;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			//connectionManager.closeConnection(connection);
		}
		return user;
		
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		String username = user.getUsername();
		String pwd = user.getPwd();
		String strSQL = "select * from user where username=? and pwd=? and status = 1";
		Object[] params = {username,pwd};
		ResultSet rs = sqlManager.execQuery(connection,strSQL, params);
		try{
			try {
				if(rs.next()){
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPwd(rs.getString("pwd"));
					user.setMobile(rs.getString("mobile"));
					user.setStatus(rs.getInt("status"));
					user.setType(rs.getInt("type"));
					user.setName(rs.getString("name"));
					
					return user;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			//connectionManager.closeConnection(connection);
		}
		return user;
	}

	@Override
	public int getStatus(User user) {
		// TODO Auto-generated method stub
		int status = 4;
		String username = user.getUsername();
		String strSQL = "select * from user where username=?";
		Object[] params = {username};
		ResultSet rs = sqlManager.execQuery(connection,strSQL, params);
		try{
			try {
				if(rs.next()){
					
					status = rs.getInt(6);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			//connectionManager.closeConnection(connection);
		}
		return status;
	}

	@Override
	public User getType(User user) {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		String strSQL = "select * from user where username=?";
		Object[] params = {username};
		ResultSet rs = sqlManager.execQuery(connection,strSQL, params);
		try{
			try {
				if(rs.next()){
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			//connectionManager.closeConnection(connection);
		}
		return user;
	}

	@Override
	public List<User> getPagingList(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		StringBuilder strSQL = new StringBuilder("select *");
		String selectItem = "*";
		//strSQL.append(selectItem);
		strSQL.append(" from user ");
		//strSQL.append(" where sale.cid = customer.id");

		/*Iterator<Map.Entry<String, Object>> it = searchItem.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			strSQL.append(" and ");
			strSQL.append(entry.getKey());
			strSQL.append(" = ");
			strSQL.append(entry.getValue());
		}*/

		strSQL.append(" order by id desc limit ?,?");
		List<User> userList = new ArrayList<User>();

		ResultSet rs = sqlManager.execQuery(connection, strSQL.toString(), new Object[] { start, number });

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

			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			//connectionManager.closeConnection(connection);
		}
	}

	@Override
	public int getCount() throws SQLException {
		// TODO Auto-generated method stub
		String strSQL = "select count(id) from user ";
		ResultSet rs = sqlManager.execQuery(connection,strSQL, new Object[] {});
		int count = 0;
		while(rs.next()){
			count = rs.getInt(1);
		}
		
		return count;
	}

	@Override
	public int updateUser(User  user) throws Exception {
		// TODO Auto-generated method stub
		String strSQL = "update user set name = ?,pwd = ?,status= ? where id = ?";
		Object[] params = {  user.getName(), user.getPwd(), user.getStatus(),user.getId()};
		int affectRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectRows;
		
		
	}

}
