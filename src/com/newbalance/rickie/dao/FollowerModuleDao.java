package com.newbalance.rickie.dao;

import java.sql.SQLException;

public interface FollowerModuleDao {
	
	// 用户关注事件
	void followByUserId( int user_id, int follower_id ) throws SQLException;

}
