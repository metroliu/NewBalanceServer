package com.newbalance.rickie.dao;

import java.sql.SQLException;

import com.newbalance.rickie.vo.UserVO;


public interface UserDao {

	void insertUser( UserVO userVO ) throws SQLException;
	UserVO queryByUserName(String user_name) throws SQLException;
	void modifyUserInfoById( int user_id, String user_nickname, int user_sex, String user_birthday, int user_city_id ) throws SQLException;
	String getSecuQuestionByUsername( String user_name ) throws SQLException;
	String getPasswordByUsernameAndSecuAns( String user_name, String user_secu_answer ) throws SQLException;
	
}