package com.lminute.test.mariotest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lminute.test.mariotest.exceptions.FileReadException;
import com.lminute.test.mariotest.exceptions.MyPatternException;
import com.lminute.test.mariotest.model.GoodOrder;
import com.lminute.test.mariotest.reader.FileOrderReader;
import com.lminute.test.mariotest.util.BillCreator;
import com.lminute.test.mariotest.util.GoodFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MyPatternException, IOException{
    	
    	try {
			FileOrderReader fileReader = new FileOrderReader("./orders");
			
			List<String> fileOrders = fileReader.getOrdersFiles();
			
			for (String file : fileOrders) {
				
				List<GoodOrder> myOrders = new ArrayList<>();
				for (String order : FileOrderReader.getFileProducts(file)) {
					myOrders.add(GoodFactory.getMyGoodProduct(order));
				}
				
				BillCreator.getBill(myOrders).stream().forEach(b -> System.out.println(b));;
					
			}
			
		} catch (FileReadException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
    	
    }
}
