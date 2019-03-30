package com.tuili.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.muzi.util.JsonUtils;
import com.tuili.factory.ServiceFactory;
import com.tuili.vo.Option;
import com.tuili.vo.User;

@SuppressWarnings("servial")
@WebServlet(name="User", urlPatterns="/User/*")
public class UserServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		try {
			if (status != null) {
				if ("addUser".equals(status)) {
					this.addUser(request, response);
				}else if ("findUserByOpenid".equals(status)) {
					this.findUserByOpenid(request, response);
				}else if ("addZanCollect".equals(status)) {
					this.addZanCollect(request, response);
				}else if ("cutZanCollect".equals(status)) {
					this.cutZanCollect(request, response);
				}else if ("getAllZanCollect".equals(status)) {
					this.getAllZanCollect(request, response);
				}else if ("addSponsor".equals(status)) {
					this.addSponsor(request, response);
				}else if ("getAllSponsor".equals(status)) {
					this.getAllSponsor(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void getAllSponsor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JsonUtils.objectToJson(ServiceFactory.getIUserServiceInstance().getAllSponsor()));
	}

	private void addSponsor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name"); 
		String way = request.getParameter("way"); 
		String money = request.getParameter("money");
		ServiceFactory.getIUserServiceInstance().addSponsor(name, way, money);
	}

	private void getAllZanCollect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String openid = request.getParameter("openid");
		String way = request.getParameter("way");
		
		out.println(JsonUtils.objectToJson(ServiceFactory.getIUserServiceInstance().getAllZanCollect(openid, way)));
	}

	private void cutZanCollect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String openid = request.getParameter("openid");
		int problem_id = Integer.parseInt(request.getParameter("problem_id"));
		String way = request.getParameter("way");
		ServiceFactory.getIUserServiceInstance().cutZanCollect(openid, problem_id, way);
	}

	private void addZanCollect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String openid = request.getParameter("openid");
		int problem_id = Integer.parseInt(request.getParameter("problem_id"));
		String way = request.getParameter("way");
		ServiceFactory.getIUserServiceInstance().addZanCollect(openid, problem_id, way);
	}

	private void findUserByOpenid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("已经查找到用户信息！！！");
		String openid = request.getParameter("openid");
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JsonUtils.objectToJson(ServiceFactory.getIUserServiceInstance().findUserByOpenid(openid)));
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_name = request.getParameter("user_name"); 
		String openid = request.getParameter("openid");
		String user_image = request.getParameter("user_image");
		String province = request.getParameter("province"); 
		String city = request.getParameter("city"); 
		System.out.println(openid);
		ServiceFactory.getIUserServiceInstance().addUser(user_name, openid, user_image, province, city);
	}
}