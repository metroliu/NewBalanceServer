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

public class CancelFollowServlet extends AbstractServlet {
	
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
	
		try{
			
			req.setCharacterEncoding("utf-8");
			// ��ȡ����code����
			String code = req.getParameter("code");
			//�ж�����������
			if( code.equals( Macro.CODE_CANCEL_FOLLOW ) ){
				
				int user_id = Integer.valueOf( req.getParameter("user_id") );
				int follower_id = Integer.valueOf( req.getParameter("follower_id") );
				FollowerModuleService followServ = new FollowerModuleServiceImp();
				followServ.cancelFollow(user_id, follower_id);
				result.put("code", Macro.CODE_CANCEL_FOLLOW_SUCCESS);
				result.put("data", new JSONObject());
				
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
