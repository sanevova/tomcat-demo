package com.servletdemo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public class EntityDAOImpl extends BaseDAOImpl
		implements EntityDAO {

	private static final String TABLE_NAME = "table1";
	private static final String ID_SEQUENCE_NAME = "folks_sequence";

	public EntityDAOImpl() {
	}

	@Override
	public Entity getEntity(int id) {
		Connection connection = initConnection();
		Entity retValue = null;
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM "+ TABLE_NAME + " WHERE id = " + id);
			ResultSet rs = statement.getResultSet();
			rs.next();
			retValue = new Entity(rs.getInt(1), rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return retValue;
	}

	@Override
	public List<Entity> getAll() {
		Connection connection = initConnection();
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
			closeConnection(connection);
		}
		return retValue;
	}

	@Override
	public void saveEntity(Entity entity) {
		Connection connection = initConnection();
		try {
			Statement statement = connection.createStatement();
			String sql;
			if (entity.getId() > 0) {
				sql = "UPDATE " +TABLE_NAME + " SET name =\'" + entity.getName() + "\' WHERE id = " + entity.getId();
//				System.out.println(sql);
			} else {
				statement.execute("SELECT " + ID_SEQUENCE_NAME + ".nextval FROM DUAL");
				int nextValue = statement.getResultSet().getInt(1);
				sql = "INSERT INTO " + TABLE_NAME + "(id, name) VALUES (" +
						nextValue + ", \'" + entity.getName() + "\')";
			}
			statement.execute(sql);

			if (statement.getResultSet().next()) {
				//TODO:NotFoundException?
//				throw new RuntimeException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
}
