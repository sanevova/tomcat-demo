package com.servletdemo.dao;

import java.sql.*;
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
		PreparedStatement statement = null;
		Entity retValue = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
			statement.setInt(1, id);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			retValue = new Entity(rs.getInt(1), rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}
		return retValue;
	}

	@Override
	public List<Entity> getAll() {
		Connection connection = initConnection();
		PreparedStatement statement = null;
		List<Entity> retValue = new LinkedList<>();
		try {
			statement = connection.prepareStatement("SELECT * FROM "+ TABLE_NAME);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				retValue.add(new Entity(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}
		return retValue;
	}

	@Override
	public void saveEntity(Entity entity) throws Exception {
		Connection connection = initConnection();
		PreparedStatement statement = null;
		try {
			String sql;
			if (entity.getId() > 0) {
				sql = "UPDATE " +TABLE_NAME + " SET name = ? WHERE id = ?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, entity.getName());
				statement.setInt(2, entity.getId());
				statement.executeUpdate();
			} else {
				PreparedStatement tempStatement = connection.prepareStatement("SELECT " + ID_SEQUENCE_NAME + ".nextval FROM DUAL");
				tempStatement.execute();
				ResultSet rs = tempStatement.getResultSet();
				rs.next();
				int nextValue = rs.getInt(1);
				sql = "INSERT INTO " + TABLE_NAME + "(id, name) VALUES (?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, nextValue);
				statement.setString(2, entity.getName());
				statement.execute();
			}
			if (statement.getUpdateCount() == 0) {
				throw new Exception("Did not update any rows");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}
	}
}
