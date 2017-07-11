package com.ytx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ytx.service.QueryService;

/**
 * 自动回复功能控制层
 * @author yuantian xin
 *
 */
@SuppressWarnings("serial")
public class AutoReplyServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		QueryService queryService =new QueryService();
		//设置编码，有可能传过来的是乱码，就会出现从数据库中查不到的问题
		req.setCharacterEncoding("UTF-8");
		out.write(queryService.queryByCommand(req.getParameter("content")));
		out.flush();
		out.close();
	}
}
