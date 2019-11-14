package com.lminute.test.mariotest.model.orders;

import com.lminute.test.mariotest.model.AbstractGoodOrder;
import com.lminute.test.mariotest.model.BasicProduct;

public class OtherProductOrder extends AbstractGoodOrder{
	private static final double tax = 0.1; 
	
	public OtherProductOrder(String name, int amount, double price) {
		super(name, amount, price);
	}

	@Override
	public BasicProduct getType() {
		return BasicProduct.getBasisProductByOrderName((getName()));
	}

	@Override
	public double getGoodTax() {
		return tax;
	}
}
