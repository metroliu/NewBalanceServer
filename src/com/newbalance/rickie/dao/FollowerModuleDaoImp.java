package com.newbalance.rickie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.newbalance.rickie.utils.DBUtil;
import com.newbalance.rickie.utils.SystemUtil;
import com.newbalance.rickie.vo.UserVO;

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
	
	
	
	
	public int getFollowNumByUserId(int user_id) throws SQLException{
		
		Connection connection = DBUtil.getConnection(true);
		int followNum = 0;
		
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(*) as followNum FROM follow WHERE follower_id = "+user_id+" GROUP BY follower_id  ");
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			if( rs.next() ){
				followNum = rs.getInt("followNum");
			}
			
		} finally{
			
			DBUtil.release(connection);
			return followNum;
			
		}
		
	}
	
	
	
	
	
	public int getFansNumByUserId(int user_id) throws SQLException{
		
		Connection connection = DBUtil.getConnection(true);
		int fansNum = 0;
		
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(*) as fansNum FROM follow WHERE user_id = "+user_id+" GROUP BY user_id  ");
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			if( rs.next() ){
				fansNum = rs.getInt("fansNum");
			}
			
		} finally{
			
			DBUtil.release(connection);
			return fansNum;
			
		}
		
	}
	
	
	
	
	
	public JSONArray getFollowListById(int user_id) throws SQLException{
		
		Connection connection = DBUtil.getConnection(true);
		JSONArray followList = new JSONArray();
		
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM user WHERE user_id IN ( SELECT user_id FROM follow WHERE follower_id = "+user_id+" ) ");
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			while( rs.next() ){
				
				UserVO userVO = SystemUtil.rs2UserVO(rs);
			    JSONObject userJS = userVO.toJsonObject();
			    followList.put(userJS);
			    
			}
			
		} finally{
			
			DBUtil.release(connection);
			return followList;
			
		}
		
	}
	
	
	
	
	
	public JSONArray getFansListById(int user_id) throws SQLException{
		
		Connection connection = DBUtil.getConnection(true);
		JSONArray fansList = new JSONArray();
		
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM user WHERE user_id IN ( SELECT follower_id FROM follow WHERE user_id = "+user_id+" ) ");
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			while( rs.next() ){
				
				UserVO userVO = SystemUtil.rs2UserVO(rs);
			    JSONObject userJS = userVO.toJsonObject();
			    fansList.put(userJS);
			    
			}
			
		} finally{
			
			DBUtil.release(connection);
			return fansList;
			
		}
		
	}

}
