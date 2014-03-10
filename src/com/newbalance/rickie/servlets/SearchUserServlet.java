package com.newbalance.rickie.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.newbalance.rickie.services.FollowerModuleService;
import com.newbalance.rickie.services.FollowerModuleServiceImp;
import com.newbalance.rickie.utils.Macro;

public class SearchUserServlet extends AbstractServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = this.getPrintWriter(resp);
		//�������͸��ͻ��˵����ݰ�
		JSONObject result = new JSONObject();
		JSONObject data = new JSONObject();
		
		try{
			
			req.setCharacterEncoding("utf-8");
			// ��ȡ����code����
			String code = req.getParameter("code");
			//�ж�����������
			if( code.equals(Macro.CODE_SEARCH_USER) ){
				
				String user_nickname = req.getParameter("user_nickname");
				String user_name = req.getParameter("user_name");
				FollowerModuleService followServ = new FollowerModuleServiceImp();
				JSONArray userList = followServ.searchUser(user_nickname, user_name);
				result.put("code", Macro.CODE_USER_LIST_RETURNED);
				data.put("data", userList);
				
			}
			
		} catch( RuntimeException e ){
			
			result.put("code", e.getMessage());
			result.put("data", new JSONObject());
			
		} finally{
			
			// �����console������
			System.out.println(result.toString());
			out.write(result.toString());
			out.close();
			out.flush();
			
		}
	}

}
