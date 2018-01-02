package org.itstep.dao;

import java.sql.*;

public class DBConnection {

	private static final String URL = "jdbc:postgresql://localhost:5433/ST21Test";
	private static final String USER_NAME = "postgres";
	private static final String USER_PASWORD = "cocacola321";

	
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER_NAME, USER_PASWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

}
