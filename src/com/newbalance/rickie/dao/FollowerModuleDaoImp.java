package com.newbalance.rickie.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.newbalance.rickie.utils.DBUtil;

public class FollowerModuleDaoImp implements FollowerModuleDao {
	
	public void followByUserId( int user_id, int follower_id ) throws SQLException{
		
		Connection connection = DBUtil.getConnection();
		
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO follow (user_id,follower_id) VALUES ("+user_id+","+follower_id+") ");
			Statement stm = connection.createStatement();
			stm.execute(sql.toString());
			connection.commit();
			
		} finally{
			
			DBUtil.release(connection);
			
		}
		
	}
	
	
	
	
	public void cancelFollowByUserId( int user_id, int follower_id ) throws SQLException{
		
		Connection connection = DBUtil.getConnection();
		
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM user WHERE user_id = "+user_id+" and follower_id = "+follower_id+" ");
			Statement stm = connection.createStatement();
			stm.execute(sql.toString());
			connection.commit();
			
		} finally{
			
			DBUtil.release(connection);
			
		}
		
	}

}
