package com.muzi.dao;

import java.util.List;

import com.tuili.vo.Sponsor;
import com.tuili.vo.User;
import com.tuili.vo.ZanCollect;

public interface IUserDAO {

	public void addUser(String user_name, String openid, String user_image, String province, String city) throws Exception;
	
	public User findUserByOpenid(String openid) throws Exception;
	
	public void addZanCollect(String openid, int problem_id, String way) throws Exception;
	
	public void cutZanCollect(String openid, int problem_id, String way) throws Exception;
	
	public List<ZanCollect> getAllZanCollect(String openid, String way) throws Exception;
	
	public void addSponsor(String name, String way, String money) throws Exception;
	
	public List<Sponsor> getAllSponsor() throws Exception;
}
