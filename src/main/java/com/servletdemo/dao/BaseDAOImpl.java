package com.servletdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public abstract class BaseDAOImpl {
	static {
		try {
			Class.forName ("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected Connection initConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DAVID", "asdzxc");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Could not connect");
		}
		return connection;
	}

	protected void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.print("Could not close");
			}
		}
	}
}
