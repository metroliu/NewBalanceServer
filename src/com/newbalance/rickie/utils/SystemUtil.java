package com.newbalance.rickie.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.newbalance.rickie.vo.UserVO;

public class SystemUtil {
	
	/*
	 * 判断字符串是否为空或null
	 */
	public static final boolean isNone(String... strs) {
		for (String str : strs) {
			if (str == null || str.trim().length() == 0) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * 将req中的用户信息字段全部存入userVO对象中去，id和timestamp字段使用默认值
	 */
	public static final UserVO req2userVO( HttpServletRequest req ){
		
		UserVO userVO = new UserVO();
		
		int user_id = -1;
		String user_avator = req.getParameter("user_avator");
	    String user_name = req.getParameter("user_name");
	    String user_nickname = req.getParameter("user_nickname");
	    String user_password = req.getParameter("user_password");
	    int user_sex = Integer.valueOf(req.getParameter("user_sex"));
	    String user_birthday = req.getParameter("user_birthday");
	    int user_city_id = Integer.valueOf(req.getParameter("user_city_id"));
	    String user_secu_question = req.getParameter("user_secu_question");
	    String user_secu_answer = req.getParameter("user_secu_answer");
		//Date timestamp = new Date("9999-99-99");
	    
	    // 输出到console调试
	    System.out.println("user_avator="+user_avator+
	    		",user_name="+user_name+
	    		",user_nickname="+user_nickname+
	    		",user_password="+user_password+
	    		",user_sex="+user_sex+
	    		",user_birthday="+user_birthday+
	    		",user_city_id="+user_city_id+
	    		",user_secu_question="+user_secu_question+
	    		",user_secu_answer="+user_secu_answer);
	    
	    userVO.setUser_id(user_id);
	    userVO.setUser_avator(user_avator);
	    userVO.setUser_name(user_name);
	    userVO.setUser_nickname(user_nickname);
	    userVO.setUser_password(user_password);
	    userVO.setUser_sex(user_sex);
	    userVO.setUser_birthday(user_birthday);
	    userVO.setUser_city_id(user_city_id);
	    userVO.setUser_secu_question(user_secu_question);
	    userVO.setUser_secu_answer(user_secu_answer);
	    //userVO.setTimestamp(timestamp);
		
		return userVO;
		
	}

}
