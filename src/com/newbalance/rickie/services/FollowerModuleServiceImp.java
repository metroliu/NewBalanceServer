package com.newbalance.rickie.services;

import java.sql.SQLException;

import org.json.JSONArray;

import com.newbalance.rickie.dao.FollowerModuleDao;
import com.newbalance.rickie.dao.FollowerModuleDaoImp;
import com.newbalance.rickie.utils.Macro;
import com.newbalance.rickie.vo.UserVO;

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
	
	
	
	
	
	public UserVO getUserInfo(int user_id){
		
		UserVO userVO = new UserVO();
		
		try{
			
			FollowerModuleDao dao = new FollowerModuleDaoImp();
			userVO = dao.getUserInfoById(user_id);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
		return userVO;
		
	}
	
	
	
	
	
	public boolean isFollow(int user_id, int follower_id){
		
		boolean isFollow = false;
		
		try{
			
			FollowerModuleDao dao = new FollowerModuleDaoImp();
			isFollow = dao.isFollowById(user_id, follower_id);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
		return isFollow;
	}
	
	
	
	
	
	public JSONArray searchUser(String user_nickname, String user_name){
		
		JSONArray userList = new JSONArray();
		
		try{
			
			FollowerModuleDao dao = new FollowerModuleDaoImp();
			userList = dao.searchUserByName(user_nickname, user_name);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
		return userList;
	}

}
