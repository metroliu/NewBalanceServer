package com.newbalance.rickie.services;

import java.sql.SQLException;

import org.json.JSONArray;

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
	
	
	
	
	public int getFollowNum( int user_id ){
		
		int followNum = 0;
		
		try{
			
			FollowerModuleDao dao = new FollowerModuleDaoImp();
			followNum = dao.getFollowNumByUserId(user_id);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
		return followNum;
		
	}
	
	
	
	
	public int getFansNum( int user_id ){
		
		int fansNum = 0;
		
		try{
			
			FollowerModuleDao dao = new FollowerModuleDaoImp();
			fansNum = dao.getFansNumByUserId(user_id);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
		return fansNum;
		
	}
	
	
	
	
	
	public JSONArray getFollowList(int user_id){
		
		JSONArray followList = new JSONArray();
		
		try{
			
			FollowerModuleDao dao = new FollowerModuleDaoImp();
			followList = dao.getFollowListById(user_id);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
		return followList;
		
	}
	
	
	
	
	
	
	public JSONArray getFansList(int user_id){
		
		JSONArray fansList = new JSONArray();
		
		try{
			
			FollowerModuleDao dao = new FollowerModuleDaoImp();
			fansList = dao.getFansListById(user_id);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
		return fansList;
		
	}

}
