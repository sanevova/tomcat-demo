package com.servletdemo.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public class DataAcessManager implements EntityContainer {
	private ArrayList<Entity> entities = new ArrayList<>();

	public DataAcessManager() {
	}

	@Override
	public Entity getEntity(int index) {
		if (index >= entities.size()) {
			throw new IndexOutOfBoundsException();
		}
		return entities.get(index);
	}

	@Override
	public List<Entity> getAll() {
		return entities;
	}

	@Override
	public void saveEntity(Entity entity) {
		entities.add(entity);
	}
}
