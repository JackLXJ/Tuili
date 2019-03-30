package com.tuili.factory;

import java.sql.Connection;

import com.muzi.dao.IArticleDAO;
import com.muzi.dao.ICommentDAO;
import com.muzi.dao.IStorageDAO;
import com.muzi.dao.IUserDAO;
import com.muzi.dao.impl.ArticleImpl;
import com.muzi.dao.impl.CommentImpl;
import com.muzi.dao.impl.StorageImpl;
import com.muzi.dao.impl.UserImpl;

public class DAOFactory {
	public static IArticleDAO getIArticleInstance(Connection connection) {
		return new  ArticleImpl(connection);
	}
	
	public static IStorageDAO getIStorageInstance(Connection connection) {
		return new StorageImpl(connection);
	}
	
	public static IUserDAO getIUserInstance(Connection connection) {
		return new UserImpl(connection);
	}
	
	public static ICommentDAO getICommentInstance(Connection connection) {
		return new CommentImpl(connection);
	}

}
