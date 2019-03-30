package com.muzi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.muzi.dao.IArticleDAO;
import com.tuili.vo.Article;
import com.tuili.vo.Option;
import com.tuili.vo.Storage;

public class ArticleImpl implements IArticleDAO {
	
	private Connection connection = null;
	private PreparedStatement pstm = null;
	
	public ArticleImpl (Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void update() throws Exception {
		String str1 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/1.jpg";
		String str2 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/2.jpg";
		String str3 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/3.jpg";
		String str4 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/4.jpg";
		String str5 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/5.jpg";
		String str6 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/6.jpg";
		String str7 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/7.jpg";
		String str8 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/8.jpg";
		String str9 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/9.jpg";
		String str10 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/10.jpg";
		String str11 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/11.jpg";
		String str12 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/12.jpg";
		String str13 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/13.jpg";
		String str14 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/14.jpg";
		String str15 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/15.jpg";
		String str16 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/16.jpg";
		String str17 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/17.jpg";
		String str18 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/18.jpg";
		String str19 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/19.jpg";
		String str20 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/20.jpg";
		String str21 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/21.jpg";
		String str22 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/22.jpg";
		String str23 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/23.jpg";
		String str24 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/24.jpg";
		String str25 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/25.jpg";
		String str26 = "https://tuili.muzimz.cn/Tuili/uploads/images/content_image/26.jpg";
		
				
		String sql = "update tuili_problem set content_image=? where id=?";
		
		for (int i=1; i<435; i++){
			if (i%26 == 1) {   
				System.out.println(1);
				System.out.println(i);
				System.out.println(i%20);
				System.out.println("-----------------------------------");
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str1);
				this.pstm.setInt(2, i);
				System.out.println(str1);
				this.pstm.executeUpdate();
			}else if (i%26 == 2) {
				System.out.println(2);
				System.out.println(i);
				System.out.println(i%20);
				System.out.println("-----------------------------------");
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str2);
				this.pstm.setInt(2, i);
				System.out.println(str2);
				this.pstm.executeUpdate();
			}else if (i%26 == 3) {
				System.out.println(3);
				System.out.println(i);
				System.out.println(i%20);
				System.out.println("-----------------------------------");
				this.pstm = this.connection.prepareStatement(sql);
				System.out.println(str3);
				this.pstm.setString(1, str3);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 4) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str4);
				this.pstm.setInt(2, i);
				System.out.println(str4);
				this.pstm.executeUpdate();
			}else if (i%26 == 5) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str5);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 6) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str6);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 7) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str7);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 8) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str8);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 9) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str9);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 10) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str10);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 11) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str11);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 12) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str12);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 13) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str13);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 14) {
				System.out.println(14);
				System.out.println(i);
				System.out.println(i%20);
				System.out.println("-----------------------------------");
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str14);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 15) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str15);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 16) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str16);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 17) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str17);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 18) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str18);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 19) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str19);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 20) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str20);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 20) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str20);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 21) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str21);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 22) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str22);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 23) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str23);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 24) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str24);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}else if (i%26 == 25) {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str25);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}
			else {
				this.pstm = this.connection.prepareStatement(sql);
				this.pstm.setString(1, str26);
				this.pstm.setInt(2, i);
				this.pstm.executeUpdate();
			}
		}
	}
	
	
	@Override
	public List<Article> getAllArticles(int left, int right) throws Exception {
		String sql = "select * from tuili_problem limit ?,?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setInt(1, left);
		this.pstm.setInt(2, right);
		ResultSet rs = this.pstm.executeQuery();
		List<Article> list = new ArrayList<Article>();
		Article article = null;
		while (rs.next()) {
			article = new Article();
			article.setImage(rs.getString("image"));
			article.setContent_image(rs.getString("content_image"));
			article.setZan_count(rs.getInt("zan_count"));
			article.setComment_count(rs.getInt("comment_count"));
			article.setCollect_count(rs.getInt("collect_count"));
			article.setWatch_count(rs.getInt("watch_count"));
			article.setDescription(rs.getString("description"));
			article.setProject(rs.getString("project"));
			article.setCreate_time(rs.getInt("create_time"));
			article.setId(rs.getInt("id"));
			article.setTitle(rs.getString("title"));
			list.add(article);
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return list;
	}

	@Override
	public Article findById(String id) throws Exception {
		String sql = "select * from tuili_problem where id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setString(1, id);
		ResultSet rs = this.pstm.executeQuery();
		Article article = null;
		if (rs.next()) {
			article = new Article();
			article.setImage(rs.getString("image"));
			article.setContent_image(rs.getString("content_image"));
			article.setZan_count(rs.getInt("zan_count"));
			article.setComment_count(rs.getInt("comment_count"));
			article.setCollect_count(rs.getInt("collect_count"));
			article.setWatch_count(rs.getInt("watch_count"));
			article.setDescription(rs.getString("description"));
			article.setProject(rs.getString("project"));
			article.setCreate_time(rs.getInt("create_time"));
			article.setTitle(rs.getString("title"));
			article.setId(rs.getInt("id"));
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return article;
	}

	@Override
	public List<Storage> getStorage() throws Exception {
		String sql = "select zan_count, zan_status, collect_count, collect_status, comment_count, watch_count, id from tuili_problem";
		this.pstm = this.connection.prepareStatement(sql);
		ResultSet rs = this.pstm.executeQuery();
		List<Storage> list = new ArrayList<Storage>();
		Storage storage = null;
		while (rs.next()) {
			storage = new Storage();
			storage.setId(rs.getInt("id"));
			storage.setCollect_count(rs.getInt("collect_count"));
			storage.setCollect_status(rs.getInt("collect_status"));
			storage.setZan_count(rs.getInt("zan_count"));
			storage.setZan_status(rs.getInt("zan_status"));
			storage.setComment_count(rs.getInt("comment_count"));
			storage.setWatch_count(rs.getInt("watch_count"));
			list.add(storage);
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return list;
	}

	@Override
	public void addWatchCount(int id) throws Exception {
		String sql = "update tuili_problem set watch_count=watch_count+1 where id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setInt(1, id);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}

	@Override
	public List<Option> findOptionById(int id) throws Exception {
		String sql = "select problem_id, option_sn from tuili_option where problem_id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setInt(1, id);
		ResultSet rs = this.pstm.executeQuery();
		List<Option> list = new ArrayList<Option>();
		Option option = null;
		while (rs.next()) {
			option = new Option();
			option.setProblem_id(rs.getInt("problem_id"));
			option.setOption(rs.getString("option_sn"));
			list.add(option);
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return list;
	}

	@Override
	public void addCommentCount(int id) throws Exception {
		String sql = "update tuili_problem set comment_count=comment_count+1 where id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setInt(1, id);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}
}
