package com.lminute.test.mariotest.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxUtil {
	public static final double IMPORTED_TAX = 0.05;
	
	public static double round(double price, double goodTax, boolean imported) {
		double roundTax = 0.0;
		if (imported) roundTax += getNumberRounded(price*IMPORTED_TAX, 2);
		
		roundTax += getNumberRounded(price*goodTax, 2);

		return getNumberRounded(roundTax, 2);
	}
	
	public static double getNumberRounded(double number, int scale) {
		return new BigDecimal(number).setScale(scale, RoundingMode.HALF_UP).doubleValue();
	}
}
