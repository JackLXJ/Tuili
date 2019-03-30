package com.muzi.dao;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.tuili.vo.Article;
import com.tuili.vo.Option;
import com.tuili.vo.Storage;

public interface IArticleDAO {
	
	public List<Article> getAllArticles(int left, int right) throws Exception;
	
	public Article findById(String id) throws Exception;
	
	public void update() throws Exception;
	
	public List<Storage> getStorage() throws Exception; 
	
	public void addWatchCount(int id) throws Exception;
	
	public List<Option> findOptionById(int id) throws Exception;
	
	public void addCommentCount(int id) throws Exception;

}
