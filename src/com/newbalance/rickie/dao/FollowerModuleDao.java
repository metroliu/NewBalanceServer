package com.newbalance.rickie.dao;

import java.sql.SQLException;

public interface FollowerModuleDao {
	
	// �û���ע�¼�
	void followByUserId( int user_id, int follower_id ) throws SQLException;
	// �û�ȡ����ע�¼�
	void cancelFollowByUserId( int user_id, int follower_id ) throws SQLException;

}
