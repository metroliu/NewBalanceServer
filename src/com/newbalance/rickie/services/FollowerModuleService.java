package com.newbalance.rickie.services;

import org.json.JSONArray;

public interface FollowerModuleService {
	
	// 用户关注事件
	void follow( int user_id, int follower_id );
	// 用户取消关注事件
	void cancelFollow( int user_id, int follower_id );
	// 获取用户关注的人的数目
	int getFollowNum( int user_id );
	// 获取用户粉丝数量
	int getFansNum( int user_id );
	// 获取用户关注的人的列表
	JSONArray getFollowList(int user_id);
	// 获取用户粉丝列表
	JSONArray getFansList(int user_id);

}
