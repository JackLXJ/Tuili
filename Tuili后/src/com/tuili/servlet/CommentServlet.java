package com.tuili.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.muzi.util.JsonUtils;
import com.sun.mail.imap.protocol.Status;
import com.tuili.factory.ServiceFactory;
import com.tuili.vo.Comment;
import com.tuili.vo.Option;

@SuppressWarnings("servial")
@WebServlet(name="Comment", urlPatterns="/Comment/*")
public class CommentServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		try {
			if (status != null) {
				if ("addComment".equals(status)) {
					this.addComment(request, response);
				}else if ("findCommentById".equals(status)) {
					this.findCommentById(request, response);
				}else if ("findAllCommentByPid".equals(status)) {
					this.findAllCommentByPid(request, response);
				}else if ("addLiuyan".equals(status)) {
					this.addLiuyan(request, response);
				}else if ("getAllLiuyan".equals(status)) {
					this.getAllLiuyan(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void getAllLiuyan(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("开始获取所有留言！！！");
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JsonUtils.objectToJson(ServiceFactory.getICommentServiceInstance().getAllLiuyan()));
	}

	private void addLiuyan(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("开始添加留言！！！");
		String liuyan = request.getParameter("liuyan"); 
		String user_name = request.getParameter("user_name"); 
		String user_image = request.getParameter("user_image");
		String openid = request.getParameter("openid");
		
		ServiceFactory.getICommentServiceInstance().addLiuyan(liuyan, user_name, user_image, openid);
	}

	private void findAllCommentByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		out.println(JsonUtils.objectToJson(ServiceFactory.getICommentServiceInstance().getAllCommentByPid(pid)));
	}

	private void findCommentById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String openid = request.getParameter("openid");
		int problem_id = Integer.parseInt(request.getParameter("problem_id"));
		Comment comment = ServiceFactory.getICommentServiceInstance().findCommentById(openid, problem_id);
		
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JsonUtils.objectToJson(comment));
	}

	private void addComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content = request.getParameter("content"); 
		String user_name = request.getParameter("user_name"); 
		String user_image = request.getParameter("user_image");
		String openid = request.getParameter("openid");
		int problem_id = Integer.parseInt(request.getParameter("problem_id"));
		
		ServiceFactory.getICommentServiceInstance().addComment(content, user_name, user_image, openid, problem_id);
	}


}