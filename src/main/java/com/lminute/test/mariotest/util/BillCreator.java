package com.lminute.test.mariotest.util;

import java.util.ArrayList;
import java.util.List;

import com.lminute.test.mariotest.model.GoodOrder;

public class BillCreator {
	
	public static List<String> getBill(List<GoodOrder> goods){
		List<String> bill = new ArrayList<>();
		double taxTot = 0.0;
		double totalPrice = 0.0;
		for (GoodOrder good : goods) {
			bill.add(formatOutput(good));
			taxTot += good.getPriceWithTax() - good.getPrice() ;
			totalPrice += good.getPriceWithTax();
		}
		bill.add("Sales Taxes: " + TaxUtil.getNumberRounded(taxTot, 2));
		bill.add("Total: " + TaxUtil.getNumberRounded(totalPrice, 2));
		
		return bill;
	}

	private static String formatOutput(GoodOrder good) {
		return good.printString();
	}
}
