package com.tuili.factory;

import com.muzi.dao.impl.StorageImpl;
import com.tuili.service.IArticleService;
import com.tuili.service.ICommentService;
import com.tuili.service.IStorageService;
import com.tuili.service.IUserService;
import com.tuili.service.impl.ArticleServiceImpl;
import com.tuili.service.impl.CommentServiceImpl;
import com.tuili.service.impl.StorageServiceImpl;
import com.tuili.service.impl.UserServiceImpl;

public class ServiceFactory {

	public static IArticleService getIArticleServiceInstance() {
		return new ArticleServiceImpl();
	}
	
	public static IArticleService findById() {
		return new ArticleServiceImpl();
	}
	
	public static IStorageService getIStorageServiceInstance() {
		return new StorageServiceImpl();
	}
	
	public static IUserService getIUserServiceInstance() {
		return new UserServiceImpl();
	}
	public static ICommentService getICommentServiceInstance() {
		return new CommentServiceImpl();
	}
}	
