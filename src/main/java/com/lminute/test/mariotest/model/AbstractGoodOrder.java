package com.lminute.test.mariotest.model;

import com.lminute.test.mariotest.util.TaxUtil;

public abstract class AbstractGoodOrder implements GoodOrder {
	
	private double price;
	private int amount;
	private String name;
	private boolean isImported;
	
	public AbstractGoodOrder(String name, int amount, double price) {
		this.price = price;
		this.amount = amount;
		this.name = name;
		this.isImported = this.name.toLowerCase().contains("imported");
	}

	@Override
	public abstract BasicProduct getType() ;
	@Override
	public abstract double getGoodTax() ;

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public double getPriceWithTax() {
		double finalTax = TaxUtil.round(getPrice(), getGoodTax(), isImported());
		return getPrice() + finalTax ;
	}

	@Override
	public int getAmount() {
		return this.amount;
	}

	@Override
	public String printString() {
		return getAmount() + " " + getName() + " : " + TaxUtil.getNumberRounded(getPriceWithTax(), 2);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isImported() {
		return isImported;
	}
}
