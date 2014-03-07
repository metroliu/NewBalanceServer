package com.newbalance.rickie.services;

import com.newbalance.rickie.vo.UserVO;


public interface UserService {

	// �û�ע��
	void signIn( UserVO userVO );
	// �û���¼
	UserVO login(String user_name,String user_password);
	// �û��޸ĸ�����Ϣ
	void modifyUserInfo(int user_id, String user_nickname, int user_sex, String user_birthday, int user_city_id );
	// �û���ȡ�ܱ�����
	String getSecuQuestion( String user_name );
	// �û���ȡ�Լ�������
	String getPassword( String user_name, String user_secu_answer );
	
}
