package com.newbalance.rickie.services;

public interface FollowerModuleService {
	
	// �û���ע�¼�
	void follow( int user_id, int follower_id );
	// �û�ȡ����ע�¼�
	void cancelFollow( int user_id, int follower_id );

}
