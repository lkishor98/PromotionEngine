package com.promotionengine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PromotionEngineTesting3 {

	
	PromotionEngine PromotionTest;
	@Before
	public void insertNewItemAndPriceDummy()
	{
		PromotionTest = new PromotionEngine();
		PromotionTest.insertNewItemAndPrice("A", 50);
		PromotionTest.insertNewItemAndPrice("B", 30);
		PromotionTest.insertNewItemAndPrice("C", 20);
		PromotionTest.insertNewItemAndPrice("D", 15);
		
		PromotionTest.insertProductIntoList("5A");
		PromotionTest.insertProductIntoList("5B");
		PromotionTest.insertProductIntoList("C");
		
	}
	
	@Test
	public void test() 
	{
		
		int totalOrderValue = PromotionTest.calculateOrderValue();
		assertEquals(370, totalOrderValue);
		
	}

}
