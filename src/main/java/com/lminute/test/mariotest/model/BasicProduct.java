package com.lminute.test.mariotest.model;

import java.util.Arrays;
import java.util.Optional;

public enum BasicProduct {
	BOOK(new String[]{"book"}), 
	FOOD(new String[]{"chocolate"}), 
	MEDICIN(new String[]{"pill"});
	
	private String[] keyWords;
	
	private BasicProduct(String[] keys) {
		this.keyWords = keys;
	}
	
	public String[] getKeyWords() {
		return keyWords;
	}
	
	public static BasicProduct getBasisProductByOrderName(String orderName) {
		Arrays.asList(BOOK.getKeyWords()).parallelStream().anyMatch(orderName::contains);
		Optional<BasicProduct> op = Arrays.asList(values()).stream().
				filter(bp -> Arrays.asList(bp.getKeyWords()).parallelStream().anyMatch(orderName::contains)).findFirst();
		return op.isPresent() ? op.get() : null;
	}
}
