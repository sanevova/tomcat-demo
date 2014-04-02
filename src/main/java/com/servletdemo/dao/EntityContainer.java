package com.servletdemo.dao;

import java.util.List;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public interface EntityContainer {
	public Entity getEntity(int index);
	public List<Entity> getAll();
	public void saveEntity(Entity entity);
}
