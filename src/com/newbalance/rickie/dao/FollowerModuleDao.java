package com.newbalance.rickie.dao;

import java.sql.SQLException;

import org.json.JSONArray;

import com.newbalance.rickie.vo.UserVO;

public interface FollowerModuleDao {
	
	// 用户关注事件
	void followByUserId( int user_id, int follower_id ) throws SQLException;
	// 用户取消关注事件
	void cancelFollowByUserId( int user_id, int follower_id ) throws SQLException;
	// 获取用户关注的人的数量
	int getFollowNumByUserId(int user_id) throws SQLException;
	// 获取用户粉丝数量
	int getFansNumByUserId(int user_id) throws SQLException;
	// 获取用户关注的人的列表
	JSONArray getFollowListById(int user_id) throws SQLException;
	// 获取用户粉丝列表
	JSONArray getFansListById(int user_id) throws SQLException;
	// 获取指定用户的信息
	UserVO getUserInfoById(int user_id) throws SQLException;
	// 判断是否存在关注关系
	boolean isFollowById(int user_id, int follower_id) throws SQLException;
	// 搜索用户
	JSONArray searchUserByName(String user_nickname, String user_name) throws SQLException;

}
