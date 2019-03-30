package com.tuili.service;

import java.util.List;

import com.tuili.factory.DAOFactory;
import com.tuili.vo.Comment;
import com.tuili.vo.Liuyan;

public interface ICommentService {
	
	public void addComment(String content, String user_name, String user_image, String openid, int problem_id) throws Exception;

	public Comment findCommentById(String openid, int problem_id) throws Exception;
	
	public List<Comment> getAllCommentByPid(int pid) throws Exception;
	
	public void addLiuyan(String liuyan, String user_name, String user_image, String openid) throws Exception;
	
	public List<Liuyan> getAllLiuyan() throws Exception;
	
}