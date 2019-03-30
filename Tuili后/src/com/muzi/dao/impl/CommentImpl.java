package com.muzi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.muzi.dao.ICommentDAO;
import com.tuili.vo.Comment;
import com.tuili.vo.Liuyan;
import com.tuili.vo.Storage;

public class CommentImpl implements ICommentDAO{
	private Connection connection = null;
	private PreparedStatement pstm = null;
	
	public CommentImpl (Connection connection) {
		this.connection = connection;
	}
	
	
	@Override
	public void addComemnt(String content, String user_name, String user_image, String openid, int problem_id) throws Exception {
		String sql = "insert into tuili_comment(content, user_name, user_image, openid, comment_time, problem_id) values(?,?,?,?,?,?)";
		this.pstm = this.connection.prepareStatement(sql);
		int time = (int) (System.currentTimeMillis() / 1000);
		
		this.pstm.setString(1, content);
		this.pstm.setString(2, user_name);
		this.pstm.setString(3, user_image);
		this.pstm.setString(4, openid);
		this.pstm.setInt(5, time);
		this.pstm.setInt(6, problem_id);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}


	@Override
	public Comment findCommentById(String openid, int problem_id) throws Exception {
		String sql = "select * from tuili_comment where openid=? and problem_id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setString(1, openid);
		this.pstm.setInt(2, problem_id);
		ResultSet rs = this.pstm.executeQuery();
		
		Comment comment = null;
		if (rs.next()) {
			comment = new Comment();
			comment.setComment_time(rs.getInt("comment_time"));
			comment.setContent(rs.getString("content"));
			comment.setOpen_id(rs.getString("openid"));
			comment.setProblem_id(rs.getInt("problem_id"));
			comment.setUser_image(rs.getString("user_image"));
			comment.setUser_name(rs.getString("user_name"));
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return comment;
	}


	@Override
	public List<Comment> getAllCommentByPid(int pid) throws Exception {
		String sql = "select * from tuili_comment where problem_id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setInt(1, pid);
		List<Comment> list = new ArrayList<Comment>();
		Comment comment = null;
		ResultSet rs = this.pstm.executeQuery();
		while (rs.next()) {
			comment = new Comment();
			comment.setComment_time(rs.getInt("comment_time"));
			comment.setContent(rs.getString("content"));
			comment.setUser_image(rs.getString("user_image"));
			comment.setUser_name(rs.getString("user_name"));
			list.add(comment);
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return list;
	}


	@Override
	public void addLiuyan(String liuyan, String user_name, String user_image, String openid) throws Exception {
		String sql = "insert into tuili_liuyan(liuyan, user_name, user_image, openid, liuyan_time) values(?,?,?,?,?)";
		this.pstm = this.connection.prepareStatement(sql);
		int time = (int) (System.currentTimeMillis() / 1000);
		
		this.pstm.setString(1, liuyan);
		this.pstm.setString(2, user_name);
		this.pstm.setString(3, user_image);
		this.pstm.setString(4, openid);
		this.pstm.setInt(5, time);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}


	@Override
	public List<Liuyan> getAllLiuyan() throws Exception {
		String sql = "select * from tuili_liuyan";
		this.pstm = this.connection.prepareStatement(sql);
		List<Liuyan> list = new ArrayList<Liuyan>();
		Liuyan liuyan = null;
		ResultSet rs = this.pstm.executeQuery();
		while (rs.next()) {
			liuyan = new Liuyan();
			liuyan.setLiuyan(rs.getString("liuyan"));
			liuyan.setLiuyan_time(rs.getInt("liuyan_time"));
			liuyan.setUser_image(rs.getString("user_image"));
			liuyan.setUser_name(rs.getString("user_name"));
			liuyan.setOpenid(rs.getString("openid"));
			list.add(liuyan);
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return list;
	}

}
