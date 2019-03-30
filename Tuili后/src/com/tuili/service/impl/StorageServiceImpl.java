package com.tuili.service.impl;

import com.tuili.dbc.DatabaseConnection;
import com.tuili.factory.DAOFactory;
import com.tuili.service.IStorageService;

public class StorageServiceImpl implements IStorageService {
	
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public void addZanCount(int id) throws Exception {
		DAOFactory.getIStorageInstance(this.dbc.getConnection()).addZanCount(id);
	}

	@Override
	public void cutZanCount(int id) throws Exception {
		DAOFactory.getIStorageInstance(this.dbc.getConnection()).cutZanCount(id);
		
	}

	@Override
	public void addCollectCount(int id) throws Exception {
		DAOFactory.getIStorageInstance(this.dbc.getConnection()).addCollectCount(id);
	}

	@Override
	public void cutCollectCount(int id) throws Exception {
			
		DAOFactory.getIStorageInstance(this.dbc.getConnection()).cutCollectCount(id);
		
	}
	
	

}
