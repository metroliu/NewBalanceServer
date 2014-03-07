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

public class GetSecuQuestionServlet extends AbstractServlet {
	
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
			if( code.equals( Macro.CODE_GET_SECU_QUESTION ) ){
				
				String user_name = req.getParameter("user_name");
				UserService userServ = new UserServiceImp();
				String user_secu_question = userServ.getSecuQuestion(user_name);
				data.put("user_secu_question", user_secu_question);
				result.put("code", Macro.CODE_SECU_QUESTION_RETURNED);
				result.put("data", data);
				
			}
			
		} catch ( RuntimeException e ) {
			
			result.put("code", e.getMessage());
			result.put("data", new JSONObject());
			
		} finally {
			
			// �����console������
			System.out.println(result.toString());
			out.write(result.toString());
			out.close();
			out.flush();
			
		}
	
	}

}
