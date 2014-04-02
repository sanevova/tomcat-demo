package com.servletdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public abstract class BaseDAOImpl {
	protected Connection connection;

	protected void initConnection() {
		connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DAVID", "asdzxc");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Could not connect");
		}
	}

	protected void closeConnection() {
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
