package com.lminute.test.mariotest.exceptions;

public class MyPatternException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyPatternException(final Throwable cause) {

		super(cause);
	}

	public MyPatternException(final String msg, final Throwable cause) {

		super(msg, cause);
	}

	public MyPatternException(final String msg) {

		super(msg);
	}

}
