package com.servletdemo.dao;

import java.util.List;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public interface EntityDAO {
	public Entity getEntity(int id);
	public List<Entity> getAll();
	public void saveEntity(Entity entity) throws Exception;
}
