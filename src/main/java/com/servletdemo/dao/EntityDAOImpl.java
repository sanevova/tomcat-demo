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
		Statement statement = null;
		Entity retValue = null;
		try {
			statement = connection.createStatement();
			statement.execute("SELECT * FROM "+ TABLE_NAME + " WHERE id = " + id);
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
		Statement statement = null;
		List<Entity> retValue = new LinkedList<>();
		try {
			statement = connection.createStatement();
			statement.execute("SELECT * FROM "+ TABLE_NAME);
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
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql;
			if (entity.getId() > 0) {
				sql = "UPDATE " +TABLE_NAME + " SET name =\'" + entity.getName() + "\' WHERE id = " + entity.getId();
				statement.executeUpdate(sql);
			} else {
				statement.execute("SELECT " + ID_SEQUENCE_NAME + ".nextval FROM DUAL");
				ResultSet rs = statement.getResultSet();
				rs.next();
				int nextValue = rs.getInt(1);
				sql = "INSERT INTO " + TABLE_NAME + "(id, name) VALUES (" +
						nextValue + ", \'" + entity.getName() + "\')";
				statement.execute(sql);
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
