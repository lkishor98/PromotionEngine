package com.promotionengine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PromotionEngineTesting {

	
	PromotionEngine PromotionTest;
	@Before
	public void insertNewItemAndPriceDummy()
	{
		PromotionTest = new PromotionEngine();
		PromotionTest.insertNewItemAndPrice("A", 50);
		PromotionTest.insertNewItemAndPrice("B", 30);
		PromotionTest.insertNewItemAndPrice("C", 20);
		PromotionTest.insertNewItemAndPrice("D", 15);
		
		PromotionTest.insertProductIntoList("3A");
		PromotionTest.insertProductIntoList("5B");
		PromotionTest.insertProductIntoList("C");
		PromotionTest.insertProductIntoList("D");
		
	}
	
	@Test
	public void test() 
	{
		
		int totalOrderValue = PromotionTest.calculateOrderValue();
		assertEquals(280, totalOrderValue);
		
	}

}
