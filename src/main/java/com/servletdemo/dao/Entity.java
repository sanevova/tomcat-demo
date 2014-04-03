package com.servletdemo.dao;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public class Entity {
	private int id;
	private String name;

	public Entity() {
	}
	public Entity(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Entity{" +
				"id=" + id +
				" name='" + name + '\'' +
				'}';
	}
}
