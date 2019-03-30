package com.muzi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.muzi.dao.IUserDAO;
import com.tuili.vo.Sponsor;
import com.tuili.vo.User;
import com.tuili.vo.ZanCollect;

public class UserImpl implements IUserDAO{

	private Connection connection = null;
	private PreparedStatement pstm = null;
	
	public UserImpl (Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void addUser(String user_name, String openid, String user_image, String province, String city) throws Exception {
		String sql = "insert into tuili_user(user_name, openid, user_image, create_time, province, city) values(?,?,?,?,?,?)";
		this.pstm = this.connection.prepareStatement(sql);
		int time = (int) (System.currentTimeMillis() / 1000);
		
		this.pstm.setString(1, user_name);
		this.pstm.setString(2, openid);
		this.pstm.setString(3, user_image);
		this.pstm.setInt(4, time);
		this.pstm.setString(5, province);
		this.pstm.setString(6, city);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
//		this.pstm.set
	}

	@Override
	public User findUserByOpenid(String openid) throws Exception {
		String sql = "select * from tuili_user where openid=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setString(1, openid);
		ResultSet rs = this.pstm.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setCity(rs.getString("city"));
			user.setOpenid(rs.getString("openid"));
			user.setProvince(rs.getString("province"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_image(rs.getString("user_image"));
			user.setCreate_time(rs.getInt("create_time"));
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return user;
	}

	@Override
	public void addZanCollect(String openid, int problem_id, String way) throws Exception {
		String sql = "insert into tuili_zan_collect(openid, problem_id, way) values(?,?,?)";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setString(1, openid);
		this.pstm.setInt(2, problem_id);
		this.pstm.setString(3, way);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}

	@Override
	public void cutZanCollect(String openid, int problem_id, String way) throws Exception {
		String sql = "delete from tuili_zan_collect where openid=? and problem_id=? and way=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setString(1, openid);
		this.pstm.setInt(2, problem_id);
		this.pstm.setString(3, way);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}

	@Override
	public List<ZanCollect> getAllZanCollect(String openid, String way) throws Exception {
		String sql = "select * from tuili_zan_collect where openid=? and way=?";
		this.pstm = this.connection.prepareStatement(sql);
		this.pstm.setString(1, openid);
		this.pstm.setString(2, way);
		
		ResultSet rs = this.pstm.executeQuery();
		ZanCollect zanCollect = null;
		List<ZanCollect> list = new ArrayList<ZanCollect>();
		while (rs.next()) {
			zanCollect = new ZanCollect();
			zanCollect.setOpenid(rs.getString("openid"));
			zanCollect.setProblem_id(rs.getInt("problem_id"));
			zanCollect.setWay(rs.getString("way"));
			list.add(zanCollect);
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return list;
	}

	@Override
	public void addSponsor(String name, String way, String money) throws Exception {
		String sql = "insert into tuili_sponsor(time, name, way, money) values(?,?,?,?)";
		this.pstm = this.connection.prepareStatement(sql);
		int time = (int) (System.currentTimeMillis() / 1000);
		this.pstm.setInt(1, time);
		this.pstm.setString(2, name);
		this.pstm.setString(3, way);
		this.pstm.setString(4, money);
		this.pstm.executeUpdate();
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
	}

	@Override
	public List<Sponsor> getAllSponsor() throws Exception {
		String sql = "select * from tuili_sponsor";
		this.pstm = this.connection.prepareStatement(sql);
		ResultSet rs = this.pstm.executeQuery();
		List<Sponsor> list = new ArrayList<Sponsor>();
		Sponsor sponsor = null;
		while (rs.next()) {
			sponsor = new Sponsor();
			sponsor.setMoney(rs.getString("money"));
			sponsor.setName(rs.getString("name"));
			sponsor.setTime(rs.getInt("time"));
			sponsor.setWay(rs.getString("way"));
			list.add(sponsor);
		}
		if (this.connection != null) {this.connection.close();}
		if (this.pstm != null) {this.pstm.close();}
		return list;
	}
}
