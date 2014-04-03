package com.servletdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public abstract class BaseDAOImpl {

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

	protected void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.print("Could not close statement");
			}
		}
	}
}
