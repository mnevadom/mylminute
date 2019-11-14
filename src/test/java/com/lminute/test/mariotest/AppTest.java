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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws FileReadException 
     * @throws MyPatternException 
     * @throws IOException 
     */
    public void testApp() throws FileReadException, IOException, MyPatternException
    {
    	FileOrderReader fileReader = new FileOrderReader("./orders/order1");
    	List<String> fileOrders = fileReader.getOrdersFiles();
		
		for (String file : fileOrders) {
			
			List<GoodOrder> myOrders = new ArrayList<>();
			for (String order : FileOrderReader.getFileProducts(file)) {
				myOrders.add(GoodFactory.getMyGoodProduct(order));
			}
			
			List<String> bill = BillCreator.getBill(myOrders);
			
			List<String> expected = new ArrayList<>();
			expected.add("1 book : 12.49");
			expected.add("1 music CD : 16.49");
			expected.add("1 chocolate bar : 0.85");
			expected.add("Sales Taxes: 1.5");
			expected.add("Total: 29.83");
			
			for (int i = 0; i < bill.size(); ++i) {
	            assertEquals(expected.get(i), bill.get(i));
	        }
				
		}
		
    }
    
}
