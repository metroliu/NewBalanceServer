package com.newbalance.rickie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.management.RuntimeErrorException;

import com.newbalance.rickie.utils.DBUtil;
import com.newbalance.rickie.utils.Macro;
import com.newbalance.rickie.vo.UserVO;

public class UserDaoImp implements UserDao {
	
	
	public void insertUser( UserVO userVO ) throws SQLException{
		
		Connection connection = DBUtil.getConnection();
		
		try{
			
			String user_avator = userVO.getUser_avator();
		    String user_name = userVO.getUser_name();
		    String user_nickname = userVO.getUser_nickname();
		    String user_password = userVO.getUser_password();
		    int user_sex = userVO.getUser_sex();
		    String user_birthday = userVO.getUser_birthday();
		    int user_city_id = userVO.getUser_city_id();
		    String user_secu_question = userVO.getUser_secu_question();
		    String user_secu_answer = userVO.getUser_secu_answer();
		    
		    // 先检查用户名是否已经存在
		    String sql1 = "select * from user where user_name = '"+user_name+"' ";
		    Statement stm = connection.createStatement();
		    ResultSet rs = stm.executeQuery(sql1);
		    if( rs.next() ){
		    	throw new RuntimeException( Macro.CODE_ACCOUNT_ALREADY_EXIST );
		    }
		    
		    StringBuilder sql = new StringBuilder();
		    sql.append( "insert into user (user_avator,user_name,user_nickname,user_password" )
		    .append( ",user_sex,user_birthday,user_city_id,user_secu_question,user_secu_answer)" )
		    .append(" values (?,?,?,?,?,?,?,?,?) ");
		    PreparedStatement pstm = connection.prepareStatement(sql.toString());
		    pstm.setString(1, user_avator);
		    pstm.setString(2, user_name);
		    pstm.setString(3, user_nickname);
		    pstm.setString(4, user_password);
		    pstm.setInt(5, user_sex);
		    pstm.setString(6, user_birthday);
		    pstm.setInt(7, user_city_id);
		    pstm.setString(8, user_secu_question);
		    pstm.setString(9, user_secu_answer);
		    pstm.execute();
		    connection.commit();
			
		} finally{
			
			DBUtil.release(connection);
			
		}
		
	}
	
	

	public UserVO queryByUserName(String user_name) throws SQLException {
		
		Connection connection = DBUtil.getConnection(true);
		
		try {
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from user where user_name='").append(user_name).append("'");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql.toString());
			if (resultSet.next()) {
				return resultSet2userVO(resultSet);
			}
			
		}finally {
			DBUtil.release(connection);
		}
		
		return null;
		
	}
	
	
	
	public void modifyUserInfoById( int user_id, String user_nickname, int user_sex, 
			String user_birthday, int user_city_id ) throws SQLException {
		
		Connection connection = DBUtil.getConnection();
		
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE user SET user_nickname = '"+user_nickname+"' , user_sex = "+user_sex+" ")
			.append(" , user_birthday = '"+user_birthday+"' , user_city_id = "+user_city_id+" ")
			.append(" WHERE user_id = "+user_id+" ");
			Statement statement = connection.createStatement();
			statement.execute(sql.toString());
			connection.commit();
			
		} finally{
			
			DBUtil.release(connection);
			
		}
		
	}
	
	
	
	
	public String getSecuQuestionByUsername( String user_name ) throws SQLException{
		
		Connection connection = DBUtil.getConnection(true);
		String user_secu_question = "";
		
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT user_secu_question FROM user WHERE user_name = '"+user_name+"' ");
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			if( rs.next() ){
				
				user_secu_question = rs.getString("user_secu_question");
				
			}
			
		} finally{
			
			DBUtil.release(connection);
			return user_secu_question;
			
		}
		
	}
	
	
	
	public String getPasswordByUsernameAndSecuAns( String user_name, String user_secu_answer ) throws SQLException{
		
		Connection connection = DBUtil.getConnection(true);
		String user_password = "";
		
		try{
			
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM user WHERE user_name = '"+user_name+"' ");
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			if( rs.next() ){
				
				if( user_secu_answer.equals( rs.getString("user_secu_answer") ) ){
					user_password = rs.getString("user_password");
				}else{
					throw new RuntimeException( Macro.CODE_WRONG_SECU_ANSWER );
				}
				
			}
			
		} finally{
			
			DBUtil.release(connection);
			return user_password;
			
		}
		
	}

	
	
	
	private UserVO resultSet2userVO(ResultSet resultSet) throws SQLException {
		UserVO vo = new UserVO();
		
		vo.setUser_id(resultSet.getInt("user_id"));
		vo.setUser_avator(resultSet.getString("user_avator"));
		vo.setUser_name(resultSet.getString("user_name"));
		vo.setUser_nickname(resultSet.getString("user_nickname"));
		vo.setUser_password(resultSet.getString("user_password"));
		vo.setUser_sex(resultSet.getInt("user_sex"));
		vo.setUser_birthday(resultSet.getString("user_birthday"));
		vo.setUser_city_id(resultSet.getInt("user_city_id"));
		vo.setUser_secu_question(resultSet.getString("user_secu_question"));
		vo.setUser_secu_answer(resultSet.getString("user_secu_answer"));
		vo.setTimestamp(resultSet.getDate("timestamp"));
		
		return vo;
	}

}
