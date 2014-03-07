package com.newbalance.rickie.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.newbalance.rickie.services.UserService;
import com.newbalance.rickie.services.UserServiceImp;
import com.newbalance.rickie.utils.Macro;

public class ModifyUserBasicInfoServlet extends AbstractServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = this.getPrintWriter(resp);
		//构建传送给客户端的数据包
		JSONObject result = new JSONObject();
	
		try{
			
			req.setCharacterEncoding("utf-8");
			// 获取请求code参数
			String code = req.getParameter("code");
			//判断是哪种请求
			if( code.equals(Macro.CODE_MODIFY_USER_BASIC_INFO) ){
				
				// 取出请求参数
				int user_id = Integer.valueOf( req.getParameter("user_id") );
				String user_nickname = req.getParameter("user_nickname");
				int user_sex = Integer.valueOf( req.getParameter("user_sex") );
				String user_birthday = req.getParameter("user_birthday");
				int user_city_id = Integer.valueOf( req.getParameter("user_city_id") );
				// 交给服务层处理
				UserService userServ = new UserServiceImp();
				userServ.modifyUserInfo(user_id, user_nickname, user_sex, user_birthday, user_city_id);
				result.put("code", Macro.CODE_MODIFY_USER_BASOC_INFO_SUCCESS);
				result.put("data", new JSONObject());
				
			}
			
			
		} catch( RuntimeException e ) {
			
			result.put("code", e.getMessage());
			result.put("data", new JSONObject());
			
		} finally {
			
			// 输出到console调试用
			System.out.println(result.toString());
			out.write(result.toString());
			out.close();
			out.flush();
			
		}
	
	}

}
