package com.tuili.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/tuili?useSSL=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
	private static final String DBUSER = "username";
	private static final String PASSWORD = "password";
	private Connection connection;
	
	public DatabaseConnection () {
		try {
			Class.forName(DBDRIVER);
			this.connection = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection () {
		return this.connection;
	}

	public void cloas () {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
