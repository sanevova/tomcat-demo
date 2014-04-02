package com.servletdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public class EntityDAOImpl extends EntityDAOImplBase
		implements EntityDAO {

	private static final String TABLE_NAME = "table1";

	public EntityDAOImpl() {
	}

	@Override
	public Entity getEntity(int id) {
		initConnection();
		Entity retValue = null;
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM "+ TABLE_NAME + "WHERE id = " + id);
			ResultSet rs = statement.getResultSet();
			rs.next();
			retValue = new Entity(rs.getInt(1), rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return retValue;
	}

	@Override
	public List<Entity> getAll() {
		initConnection();
		List<Entity> retValue = new LinkedList<>();
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM "+ TABLE_NAME);
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				retValue.add(new Entity(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return retValue;
	}

	@Override
	public void saveEntity(Entity entity) {
		initConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO " + TABLE_NAME + "VALUES (" + entity.getId() + "" + entity.getName() + ")";
			statement.execute(sql);
		} catch (SQLException e) {
			closeConnection();
		}
	}
}
