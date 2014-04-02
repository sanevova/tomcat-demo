package com.servletdemo.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public class Entity {
	private ArrayList<Object> data;

	public Entity(ResultSet nativeRow) {
		try {
			int size = nativeRow.getMetaData().getColumnCount();
			data = new ArrayList<>(size);
			for (int i = 0; i < size; ++i) {
				data.add(nativeRow.getObject(i + 1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Object getObjectAt(int index) {
		if (index > data.size()) {
			throw new IndexOutOfBoundsException();
		}
		return data.get(index - 1);
	}

	public int getIntAt(int index) throws EntityColumnTypeException {
		Object retValue = getObjectAt(index);
		//stub for numbers in int range
		if (retValue instanceof BigDecimal) {
			retValue = ((BigDecimal) retValue).intValue();
		}
		if (retValue instanceof Integer) {
			return (Integer)retValue;
		}
		throw new EntityColumnTypeException();
	}

	public String getStringAt(int index) throws EntityColumnTypeException {
		Object retValue = getObjectAt(index);
		if (retValue instanceof String) {
			return (String)retValue;
		}
		throw new EntityColumnTypeException();
	}

	public Double getDouble(int index) throws EntityColumnTypeException {
		Object retValue = getObjectAt(index);
		//stub for numbers in double range
		if (retValue instanceof BigDecimal) {
			retValue = ((BigDecimal) retValue).doubleValue();
		}
		if (retValue instanceof Double) {
			return (Double)retValue;
		}
		throw new EntityColumnTypeException();
	}
}
