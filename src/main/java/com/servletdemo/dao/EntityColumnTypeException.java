package com.servletdemo.dao;

/**
 * Created by Vladimir Mishatkin on 02.04.2014.
 */
public class EntityColumnTypeException extends Exception {

	public EntityColumnTypeException() {
		super();
	}

	public EntityColumnTypeException(String message) {
		super(message);
	}

	public EntityColumnTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityColumnTypeException(Throwable cause) {
		super(cause);
	}

	protected EntityColumnTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
