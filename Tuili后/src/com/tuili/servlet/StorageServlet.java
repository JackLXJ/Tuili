package com.tuili.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.muzi.util.JsonUtils;
import com.tuili.factory.ServiceFactory;
import com.tuili.vo.Article;
import com.tuili.vo.Storage;

@SuppressWarnings("servial")
@WebServlet(name="Storage", urlPatterns="/Storage/*")
public class StorageServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		try {
			if (status != null) {
				if ("addZanCount".equals(status)) {
					this.addZanCount(request, response);
				}else if ("cutZanCount".equals(status)) {
					this.cutZanCount(request, response);
				}else if ("addCollectCount".equals(status)) {
					this.addCollectCount(request, response);
				}else if ("cutCollectCount".equals(status)) {
					this.cutCollectCount(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void cutCollectCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		ServiceFactory.getIStorageServiceInstance().cutCollectCount(id);
		System.out.println("收藏已经减少了！！！");
	}

	private void addCollectCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		ServiceFactory.getIStorageServiceInstance().addCollectCount(id);
		System.out.println("收藏已经增加了！！！");
	}

	private void cutZanCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		ServiceFactory.getIStorageServiceInstance().cutZanCount(id);
		System.out.println("赞已经减少了！！！");
	}

	private void addZanCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		ServiceFactory.getIStorageServiceInstance().addZanCount(id);
		System.out.println("赞已经增加了！！！");
	}

	
}
