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
import com.newbalance.rickie.vo.UserVO;

public class LogInServlet extends AbstractServlet {
	
	
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
			if( code.equals(Macro.CODE_LOGIN) ) {// ����ǵ�½����
				
				String user_name = req.getParameter("user_name");
				String user_password = req.getParameter("user_password");
				UserService userServ = new UserServiceImp();
				UserVO userVO = userServ.login(user_name, user_password);
				result.put("code", Macro.CODE_LOGIN_SUCCESS);
				result.put("data", userVO.toJsonObject());
				
			}
			
		} catch ( RuntimeException e ){
			
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
