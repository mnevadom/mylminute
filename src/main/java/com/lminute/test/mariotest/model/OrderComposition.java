package com.lminute.test.mariotest.model;

public enum OrderComposition {
	AMOUNT(1),
	PRODUCT(2),
	PRICE(3);
	
	private int ordinal;
	
	private OrderComposition(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}
