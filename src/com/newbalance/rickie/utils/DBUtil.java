package com.newbalance.rickie.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

public class DBUtil {

	private static final String DRIVE_PATH="com.mysql.jdbc.Driver"; 
	private static final String URL="jdbc:mysql://127.0.0.1:3306/NewBalance";
	private static final String USER="root";
	private static final String PASSWORD="";
	
	static{
		try {
			Class.forName(DRIVE_PATH);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException 
	 */
	public static final Connection getConnection(boolean isReadOnly) throws SQLException{
		
		Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
		//设置连接为手动提交
		connection.setAutoCommit(false);
		//设置只读
		connection.setReadOnly(isReadOnly);
		return connection;
	}
	
	public static final Connection getConnection() throws SQLException{
		return getConnection(false);
	}
	
	/**
	 * 关闭连接
	 * @param connection
	 */
	public static final void release(Connection connection)throws SQLException{
		if(connection!=null){
			connection.close();
		}
	}
	
	/**
	 * 关闭结果集
	 * @param resultSet
	 */
	public static final void close(ResultSet resultSet,Statement statement)throws SQLException{
		if(resultSet!=null){
			resultSet.close();
		}
		if(statement!=null){
			statement.close();	
		}
	}
	
	/**
	 * 关闭结果集以及连接
	 * @param resultSet
	 */
	public static final void close(ResultSet resultSet,Statement statement,Connection connection)throws SQLException{
		if(resultSet!=null){
			resultSet.close();
		}
		if(statement!=null){
			statement.close();	
		}
		if(connection!=null){
			connection.close();
		}
	}
}
