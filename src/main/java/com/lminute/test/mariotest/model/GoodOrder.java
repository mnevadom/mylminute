package com.lminute.test.mariotest.model;

public interface GoodOrder {

	public BasicProduct getType();
	public double getPrice();
	public double getPriceWithTax();
	public double getGoodTax();
	public int getAmount();
	public String printString();
	public String getName();
	public boolean isImported();
	
}
