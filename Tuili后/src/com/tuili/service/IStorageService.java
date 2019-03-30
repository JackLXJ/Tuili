package com.tuili.service;

public interface IStorageService {
		
	public void addZanCount(int id) throws Exception;
	
	public void cutZanCount(int id) throws Exception;
	
	public void addCollectCount(int id) throws Exception;
	
	public void cutCollectCount(int id) throws Exception;
}
