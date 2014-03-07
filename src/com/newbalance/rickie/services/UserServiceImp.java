package com.newbalance.rickie.services;


import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import com.newbalance.rickie.dao.UserDao;
import com.newbalance.rickie.dao.UserDaoImp;
import com.newbalance.rickie.utils.Macro;
import com.newbalance.rickie.vo.UserVO;

public class UserServiceImp implements UserService {
	
	
	
	public void signIn( UserVO userVO ) {
		
		try{
			
			UserDao dao = new UserDaoImp();
			dao.insertUser(userVO);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		} catch( RuntimeException e ){
			
			throw new RuntimeException( Macro.CODE_ACCOUNT_ALREADY_EXIST );
			
		} 
		
	}
	
	
	

	public UserVO login(String user_name, String user_password) {
		
		UserVO userVO = new UserVO();
		
		try{
			
			//调用数据访问层来查询数据
			UserDao dao = new UserDaoImp();
			userVO = dao.queryByUserName(user_name);

			if( userVO == null ){
				throw new RuntimeException(Macro.CODE_ACCOUNT_NOT_EXIST);
			}
			if( !user_password.equals( userVO.getUser_password() ) ){
				throw new RuntimeException(Macro.CODE_WRONG_PASSWORD);
			}
			
		}catch( SQLException e ){
			// dao层queryByUserName抛出数据库异常
			throw new RuntimeException(Macro.CODE_SYSERROE);
		}

		return userVO;
		
	}
	
	
	
	public void modifyUserInfo(int user_id, String user_nickname, int user_sex, String user_birthday, int user_city_id ){
		
		try{
			
			UserDao dao = new UserDaoImp();
			dao.modifyUserInfoById(user_id, user_nickname, user_sex, user_birthday, user_city_id);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		} 
		
	}
	
	
	
	public String getSecuQuestion( String user_name ){
		
		String user_secu_question = "";
		
		try{
			
			UserDao dao = new UserDaoImp();
			user_secu_question = dao.getSecuQuestionByUsername(user_name);
			
		} catch ( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		}
		
		return user_secu_question;
		
	}
	
	
	
	public String getPassword( String user_name, String user_secu_answer ){
		
		String user_password = "";
		
		try{
			
			UserDao dao = new UserDaoImp();
			user_password = dao.getPasswordByUsernameAndSecuAns(user_name, user_secu_answer);
			
		} catch( SQLException e ){
			
			throw new RuntimeException( Macro.CODE_SYSERROE );
			
		} catch( RuntimeException e ){
			
			throw new RuntimeException( Macro.CODE_WRONG_SECU_ANSWER );
			
		}
		
		return user_password;
		
	}
	

}
