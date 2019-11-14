package com.lminute.test.mariotest.exceptions;

public class FileReadException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileReadException(final Throwable cause) {

		super(cause);
	}

	public FileReadException(final String msg, final Throwable cause) {

		super(msg, cause);
	}

	public FileReadException(final String msg) {

		super(msg);
	}

}
