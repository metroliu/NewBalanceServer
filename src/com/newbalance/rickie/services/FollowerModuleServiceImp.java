package com.newbalance.rickie.services;

import java.sql.SQLException;

import com.newbalance.rickie.dao.FollowerModuleDao;
import com.newbalance.rickie.dao.FollowerModuleDaoImp;
import com.newbalance.rickie.utils.Macro;

public class FollowerModuleServiceImp implements FollowerModuleService {
	
	public void follow( int user_id, int follower_id ){
		
		try{
			
			FollowerModuleDao dao = new FollowerModuleDaoImp();
			dao.followByUserId(user_id, follower_id);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
	}
	
	
	
	
	public void cancelFollow( int user_id, int follower_id ){
		
		try{
			
			FollowerModuleDao dao = new FollowerModuleDaoImp();
			dao.cancelFollowByUserId(user_id, follower_id);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
	}

}
