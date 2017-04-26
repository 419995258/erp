package com.lucene.erp.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import com.lucene.erp.util.Log;

public class TransactionManager {

	// 方法1：启动事务
	public void beginTransaction(final Connection connection){
		if(connection != null){
			try {
				connection.setAutoCommit(false);
				Log.out(this.getClass().getSimpleName(), "开启一个事务处理……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 方法2：提交事务
	public void commitTransaction(final Connection connection){
		if(connection != null){
			try {
				connection.commit();
				Log.out(this.getClass().getSimpleName(), "提交事务处理……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	// 方法3：回滚事务
	public void rollbackTransaction(final Connection connection){
		if(connection != null){
			try {
				connection.rollback();
				Log.out(this.getClass().getSimpleName(), "回滚事务处理……");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}
