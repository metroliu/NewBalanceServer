package com.newbalance.rickie.services;

import org.json.JSONArray;

import com.newbalance.rickie.vo.UserVO;

public interface FollowerModuleService {
	
	// �û���ע�¼�
	void follow( int user_id, int follower_id );
	// �û�ȡ����ע�¼�
	void cancelFollow( int user_id, int follower_id );
	// ��ȡ�û���ע���˵���Ŀ
	int getFollowNum( int user_id );
	// ��ȡ�û���˿����
	int getFansNum( int user_id );
	// ��ȡ�û���ע���˵��б�
	JSONArray getFollowList(int user_id);
	// ��ȡ�û���˿�б�
	JSONArray getFansList(int user_id);
	// ��ȡָ���û���Ϣ
	UserVO getUserInfo(int user_id);
	// �ж��Ƿ���ڹ�ע��ϵ
	boolean isFollow(int user_id, int follower_id);
	// �����û�
	JSONArray searchUser(String user_nickname, String user_name);

}
