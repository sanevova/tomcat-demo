package com.servletdemo.dao;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public class Entity {
	private String name = null;
	private int id = 0;

	public Entity() {
	}
	public Entity(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
