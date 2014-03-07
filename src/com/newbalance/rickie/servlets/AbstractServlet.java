package com.newbalance.rickie.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractServlet extends HttpServlet {

	/**
	 * ͳһ������ȡ���ı������
	 * @param resp
	 * @return
	 * @throws IOException
	 */
	protected PrintWriter getPrintWriter(HttpServletResponse resp) throws IOException{
		resp.setContentType("text/plain");//text/xml
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		return out;
	}
}
