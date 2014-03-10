package com.newbalance.rickie.dao;

import java.sql.SQLException;

import org.json.JSONArray;

public interface FollowerModuleDao {
	
	// �û���ע�¼�
	void followByUserId( int user_id, int follower_id ) throws SQLException;
	// �û�ȡ����ע�¼�
	void cancelFollowByUserId( int user_id, int follower_id ) throws SQLException;
	// ��ȡ�û���ע���˵�����
	int getFollowNumByUserId(int user_id) throws SQLException;
	// ��ȡ�û���˿����
	int getFansNumByUserId(int user_id) throws SQLException;
	// ��ȡ�û���ע���˵��б�
	JSONArray getFollowListById(int user_id) throws SQLException;
	// ��ȡ�û���˿�б�
	JSONArray getFansListById(int user_id) throws SQLException;

}
