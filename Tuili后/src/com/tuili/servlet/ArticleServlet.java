package com.tuili.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.muzi.util.JsonUtils;
import com.tuili.factory.DAOFactory;
import com.tuili.factory.ServiceFactory;
import com.tuili.vo.Article;
import com.tuili.vo.Option;
import com.tuili.vo.Storage;

@SuppressWarnings("servial")
@WebServlet(name="Articles", urlPatterns="/Articles/*")
public class ArticleServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		try {
			if (status != null) {
				if ("getAllArticles".equals(status)) {
					this.getAllArticles(request, response);
				}else if ("findById".equals(status)) {
					this.getById(request, response);
				}else if ("getStorage".equals(status)) {
					this.getStorage(request, response);
				}else if ("addWatchCount".equals(status)) {
					this.addWatchCount(request, response);
				}else if ("findOptionById".equals(status)) {
					this.findOptionById(request, response);
				}else if ("addCommentCount".equals(status)) {
					this.addCommentCount(request, response);
				}else if ("findByIds".equals(status)) {
					this.findByIds(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void findByIds(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String para = request.getParameter("ids");
		System.out.println(para);
		String[] ids = para.split("\\|");
		System.out.println(ids);
		List<Article> list = new ArrayList<Article>();
		Article article = null;
		for (int i=0;i<ids.length;i++) {
			if (ids[i] != null) {
				System.out.println(ids[i]);
				article = ServiceFactory.getIArticleServiceInstance().findById(ids[i]);
				list.add(article);
			}
		}
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JsonUtils.objectToJson(list));
	}

	private void addCommentCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("评论数量增加成功");
		int id = Integer.parseInt(request.getParameter("id"));
		ServiceFactory.getIArticleServiceInstance().addCommentCount(id);
	}

	private void findOptionById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		List<Option> list = ServiceFactory.getIArticleServiceInstance().findOptionById(id);
		out.println(JsonUtils.objectToJson(list));
	}

	private void addWatchCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		ServiceFactory.getIArticleServiceInstance().addWatchCount(id);
	}

	private void getStorage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Storage> list = ServiceFactory.getIArticleServiceInstance().getStorage();
		out.println(JsonUtils.objectToJson(list));
	}

	private void getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		System.out.println(id);
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Article article = ServiceFactory.getIArticleServiceInstance().findById(id);
		out.println(JsonUtils.objectToJson(article));
	}

	private void getAllArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("已经被启动了，开始获取所有的数据！！！-----------------------------------");
		response.setContentType("text/json; charset=utf-8");
		int left = Integer.parseInt(request.getParameter("left"));
		int right = Integer.parseInt(request.getParameter("right"));
		PrintWriter out = response.getWriter();
		List<Article> list = ServiceFactory.getIArticleServiceInstance().getAllArticle(left, right);
		out.println(JsonUtils.objectToJson(list));
	}
}
