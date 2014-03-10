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
import com.newbalance.rickie.utils.SystemUtil;
import com.newbalance.rickie.vo.UserVO;

public class GetUserInfoServlet extends AbstractServlet {
	
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
			if( code.equals(Macro.CODE_GET_USER_INFO) ){
				
				int user_id = Integer.valueOf( req.getParameter("user_id") );
				FollowerModuleService followServ = new FollowerModuleServiceImp();
				UserVO userVO = followServ.getUserInfo(user_id);
				result.put("code", Macro.CODE_USER_INFO_RETURNED);
				result.put("data", userVO.toJsonObject());
				
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
