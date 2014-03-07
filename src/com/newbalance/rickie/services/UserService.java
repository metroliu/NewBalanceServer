package com.newbalance.rickie.services;

import com.newbalance.rickie.vo.UserVO;


public interface UserService {

	// 用户注册
	void signIn( UserVO userVO );
	// 用户登录
	UserVO login(String user_name,String user_password);
	// 用户修改个人信息
	void modifyUserInfo(int user_id, String user_nickname, int user_sex, String user_birthday, int user_city_id );
	// 用户获取密保问题
	String getSecuQuestion( String user_name );
	// 用户获取自己的密码
	String getPassword( String user_name, String user_secu_answer );
	
}
