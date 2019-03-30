package com.tuili.service.impl;

import java.util.List;

import com.muzi.dao.ICommentDAO;
import com.tuili.dbc.DatabaseConnection;
import com.tuili.factory.DAOFactory;
import com.tuili.service.ICommentService;
import com.tuili.vo.Comment;
import com.tuili.vo.Liuyan;

public class CommentServiceImpl implements ICommentService {

	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public void addComment(String content, String user_name, String user_image, String openid, int problem_id) throws Exception {
		DAOFactory.getICommentInstance(this.dbc.getConnection()).addComemnt(content, user_name, user_image, openid, problem_id);
		
	}

	@Override
	public Comment findCommentById(String openid, int problem_id) throws Exception {
		
		return DAOFactory.getICommentInstance(this.dbc.getConnection()).findCommentById(openid, problem_id);
	}

	@Override
	public List<Comment> getAllCommentByPid(int pid) throws Exception {
		return DAOFactory.getICommentInstance(this.dbc.getConnection()).getAllCommentByPid(pid);
	}

	@Override
	public void addLiuyan(String liuyan, String user_name, String user_image, String openid) throws Exception {
		DAOFactory.getICommentInstance(this.dbc.getConnection()).addLiuyan(liuyan, user_name, user_image, openid);
	}

	@Override
	public List<Liuyan> getAllLiuyan() throws Exception {
		return DAOFactory.getICommentInstance(this.dbc.getConnection()).getAllLiuyan();
	}
}
