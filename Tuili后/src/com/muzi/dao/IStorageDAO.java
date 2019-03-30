package com.muzi.dao;

public interface IStorageDAO {

	public void addZanCount(int id) throws Exception;
	
	public void cutZanCount(int id) throws Exception;
	
	public void addCollectCount(int id) throws Exception;
	
	public void cutCollectCount(int id) throws Exception;
	
}
