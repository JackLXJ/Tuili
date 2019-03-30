package com.tuili.service.impl;

import java.util.List;

import com.tuili.dbc.DatabaseConnection;
import com.tuili.factory.DAOFactory;
import com.tuili.factory.ServiceFactory;
import com.tuili.service.IUserService;
import com.tuili.vo.Sponsor;
import com.tuili.vo.User;
import com.tuili.vo.ZanCollect;

public class UserServiceImpl implements IUserService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public void addUser(String user_name, String openid, String user_image, String province, String city)
			throws Exception {
		DAOFactory.getIUserInstance(this.dbc.getConnection()).addUser(user_name, openid, user_image, province, city);
	}

	@Override
	public User findUserByOpenid(String openid) throws Exception {
		return DAOFactory.getIUserInstance(this.dbc.getConnection()).findUserByOpenid(openid);
	}

	@Override
	public void addZanCollect(String openid, int problem_id, String way) throws Exception {
		DAOFactory.getIUserInstance(this.dbc.getConnection()).addZanCollect(openid, problem_id, way);
		
	}

	@Override
	public void cutZanCollect(String openid, int problem_id, String way) throws Exception {
		DAOFactory.getIUserInstance(this.dbc.getConnection()).cutZanCollect(openid, problem_id, way);
		
	}

	@Override
	public List<ZanCollect> getAllZanCollect(String openid, String way) throws Exception {
		return DAOFactory.getIUserInstance(this.dbc.getConnection()).getAllZanCollect(openid, way);
	}

	@Override
	public void addSponsor(String name, String way, String money) throws Exception {
		DAOFactory.getIUserInstance(this.dbc.getConnection()).addSponsor(name, way, money);
	}

	@Override
	public List<Sponsor> getAllSponsor() throws Exception {
		return  DAOFactory.getIUserInstance(this.dbc.getConnection()).getAllSponsor();
	}

}
