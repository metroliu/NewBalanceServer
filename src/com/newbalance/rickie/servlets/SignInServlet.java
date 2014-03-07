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
import com.newbalance.rickie.utils.SystemUtil;
import com.newbalance.rickie.vo.UserVO;

public class SignInServlet extends AbstractServlet {
	
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
		
		try {
			
			req.setCharacterEncoding("utf-8");
			// 获取请求code参数
			String code = req.getParameter("code");
			// 判断是哪种请求
			if( code.equals(Macro.CODE_SIGN_IN) ){// 如果是注册请求
				
			    UserVO userVO = SystemUtil.req2userVO(req);
			    UserService userServ = new UserServiceImp();
			    userServ.signIn(userVO);
			    result.put("code", Macro.CODE_SIGN_IN_SUCCESS);
			    result.put("data", new JSONObject());
				
			}
			
		} catch ( RuntimeException e ) {
			
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
