package com.newbalance.rickie.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.newbalance.rickie.services.FollowerModuleService;
import com.newbalance.rickie.services.FollowerModuleServiceImp;
import com.newbalance.rickie.utils.Macro;

public class GetFollowNumServlet extends AbstractServlet {
	
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
		JSONObject data = new JSONObject();
	
		try{
			
			req.setCharacterEncoding("utf-8");
			// 获取请求code参数
			String code = req.getParameter("code");
			//判断是哪种请求
			if( code.equals( Macro.CODE_GET_FOLLOW_NUMBER ) ){
				
				int user_id = Integer.valueOf( req.getParameter("user_id") );
				FollowerModuleService followServ = new FollowerModuleServiceImp();
				int followNum = followServ.getFollowNum(user_id);
				data.put("follow_num", followNum);
				result.put("code", Macro.CODE_FOLLOW_NUMBER_RETURNED);
				result.put("data", data);
				
			}
			
		} catch ( RuntimeException e ){
			
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
