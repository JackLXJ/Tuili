package com.muzi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.muzi.dao.IStorageDAO;

public class StorageImpl implements IStorageDAO {

	private Connection connection = null;
	private PreparedStatement pstm = null;
	
	public StorageImpl (Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void addZanCount(int id) throws Exception {
		String sql = "update tuili_problem set zan_count=zan_count+1 where id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setInt(1, id);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}

	@Override
	public void cutZanCount(int id) throws Exception {
		String sql = "update tuili_problem set zan_count=zan_count-1 where id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setInt(1, id);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}

	@Override
	public void addCollectCount(int id) throws Exception {
		String sql = "update tuili_problem set collect_count=collect_count+1 where id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setInt(1, id);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}

	@Override
	public void cutCollectCount(int id) throws Exception {
		String sql = "update tuili_problem set collect_count=collect_count-1 where id=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setInt(1, id);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}
	
	

}
