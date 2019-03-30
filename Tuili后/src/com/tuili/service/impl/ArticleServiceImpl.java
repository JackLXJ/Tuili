package com.tuili.service.impl;

import java.util.List;

import com.tuili.dbc.DatabaseConnection;
import com.tuili.factory.DAOFactory;
import com.tuili.service.IArticleService;
import com.tuili.vo.Article;
import com.tuili.vo.Option;
import com.tuili.vo.Storage;

public class ArticleServiceImpl  implements IArticleService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public List<Article> getAllArticle(int left, int right) throws Exception {
		return DAOFactory.getIArticleInstance(this.dbc.getConnection()).getAllArticles(left, right);
	}

	@Override
	public Article findById(String id) throws Exception {
		return DAOFactory.getIArticleInstance(this.dbc.getConnection()).findById(id);
	}

	@Override
	public void update() throws Exception {
		DAOFactory.getIArticleInstance(this.dbc.getConnection()).update();
	}

	@Override
	public List<Storage> getStorage() throws Exception {
		return DAOFactory.getIArticleInstance(this.dbc.getConnection()).getStorage();
	}

	@Override
	public void addWatchCount(int id) throws Exception {
		DAOFactory.getIArticleInstance(this.dbc.getConnection()).addWatchCount(id);
	}

	@Override
	public List<Option> findOptionById(int id) throws Exception {
		return DAOFactory.getIArticleInstance(this.dbc.getConnection()).findOptionById(id);
	}

	@Override
	public void addCommentCount(int id) throws Exception {
		DAOFactory.getIArticleInstance(this.dbc.getConnection()).addCommentCount(id);
		
	}

}	
