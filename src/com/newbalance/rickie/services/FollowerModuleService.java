package com.newbalance.rickie.services;

public interface FollowerModuleService {
	
	// 用户关注事件
	void follow( int user_id, int follower_id );
	// 用户取消关注事件
	void cancelFollow( int user_id, int follower_id );

}
