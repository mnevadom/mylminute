package com.lminute.test.mariotest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lminute.test.mariotest.exceptions.MyPatternException;
import com.lminute.test.mariotest.model.BasicProduct;
import com.lminute.test.mariotest.model.GoodOrder;
import com.lminute.test.mariotest.model.OrderComposition;
import com.lminute.test.mariotest.model.orders.BasicProductOrder;
import com.lminute.test.mariotest.model.orders.OtherProductOrder;

public class GoodFactory {
	private static final String ORDER_FMAT = "([0-9]+) ([a-zA-Z ]+) at ([0-9.]+)";
	private static final Pattern pattern = Pattern.compile(ORDER_FMAT);

	public static GoodOrder getMyGoodProduct(String order) throws MyPatternException {
		Matcher matcher = pattern.matcher(order);
		
		if (!matcher.find())
			throw new MyPatternException("Product order not well formated");
		
		int amount = Integer.parseInt(matcher.group(OrderComposition.AMOUNT.getOrdinal()));
		String orderName = matcher.group(OrderComposition.PRODUCT.getOrdinal());
		double price = Double.parseDouble(matcher.group(OrderComposition.PRICE.getOrdinal()));
		
		if (isBasicProduct(orderName))
			return new BasicProductOrder(orderName, amount, price);
		else
			return new OtherProductOrder(orderName, amount, price);
	}
	
	public static boolean isBasicProduct(String orderName) {
		return null != BasicProduct.getBasisProductByOrderName(orderName);
	}
	
}
