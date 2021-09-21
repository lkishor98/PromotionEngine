package com.promotionengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PromotionEngine
{

	private HashMap<String, Integer> ItemAndPrice = new HashMap<>();
	private HashMap<String, Integer> promotions = new HashMap<>();
	private List<String> listOfProduct = new ArrayList<>();
	
	
	void insertNewItemAndPrice(String Item, Integer Price)
	{
		ItemAndPrice.put(Item, Price);
	}
	
	void insertProductIntoList(String Item)
	{
		listOfProduct.add(Item);
	}
	
	public void displayItemAndPrice()
	{
		ItemAndPrice.forEach((k,v) -> System.out.println("Sku: "+ k + " Price: "+ v));
	}
	
	public void displayPromotions()
	{
		promotions.forEach((k,v) -> System.out.println("PromotionKey: "+ k + " Value: "+ v));
	}
	
	public int calculateTotalOrder()
	{
		
		if(listOfProduct.isEmpty())
			return 0;
		else 
			return calculateOrderValue();
	}
	
	
	public int calculateOrderValue()
	{
		int totalOrder=0;
		boolean isCPresent = false;
		boolean isDPresent = false;
		for(int i=0;i<listOfProduct.size();i++)
		{
			String product = listOfProduct.get(i);
			if(product.length() == 1 && ItemAndPrice.containsKey(product))
			{
				if(product.equalsIgnoreCase("C"))
					isCPresent = true;
				if(product.equalsIgnoreCase("D"))
					isDPresent = true;
				
				totalOrder += ItemAndPrice.get(product);
			}
			else if(product.length() > 1)
			{
				
				String item = String.valueOf(product.charAt(product.length()-1));
				int value = Integer.parseInt(product.substring(0, product.length()-1));
				
				
				switch (item) {
				case "A":
							totalOrder +=(value / 3) * 130 + (value % 3 * ItemAndPrice.get(item));
							break;
				case "B":
							totalOrder +=(value / 2) * 45 + (value % 2 * ItemAndPrice.get(item));
							break;
				case "C":
							totalOrder +=(value * ItemAndPrice.get(item));
							isCPresent = true;
							break;
				case "D":
							totalOrder +=(value * ItemAndPrice.get(item));
							isDPresent = true;
							break;
				default:
							totalOrder +=0;
							break;
				}
				
			}
		}
		
		if(isCPresent && isDPresent)
		{
			return totalOrder - 5;
		}
		else
			return totalOrder;
		
	}
	
	public static void main(String[] args) 
	{
		PromotionEngine PE = new PromotionEngine();
		
		//sample active promotions on which promotion engine will run for reference
		PE.promotions.put("3A", 130);
		PE.promotions.put("2B", 45);
		PE.promotions.put("C+D", 30);
		
		
		
		//prepare map of products from user but as of now took hardcoded values as mentioned in pdf
		
		/*
			System.out.println("Enter the total number of items : ");
			Scanner input = new Scanner(System.in);
			int totalItems = input.nextInt();
			for(int i=0;i<totalItems;i++)
			{
				System.out.println("Enter the SKU :- ");
				String item = input.next().toString();
				System.out.println("Enter the Price :- ");
				int price = input.nextInt();
				
				PE.insertNewItemAndPrice(item, price);
			}
		*/
		
		PE.insertNewItemAndPrice("A", 50);
		PE.insertNewItemAndPrice("B", 30);
		PE.insertNewItemAndPrice("C", 20);
		PE.insertNewItemAndPrice("D", 15);
		
		PE.displayItemAndPrice();
		PE.displayPromotions();
		
		
		//Get total number of product from user as of allowed 4 products only
		System.out.println("Enter the total number of Products for calculation shouldn't be more than 4 : ");
		
		Scanner inputProducts = new Scanner(System.in);
		int totalProducts = inputProducts.nextInt();
		
		while(totalProducts > 4)
		{
			System.out.println("total product should not be more than 4 scan 4 or less products :-");
			totalProducts = inputProducts.nextInt();
		}
		
		//Store each product value in list for later calculation
		for(int i=0;i<totalProducts;i++)
		{
			System.out.println("Enter the each Product in newline format For ex: A Or 3A :- ");
			String item = inputProducts.next().toString();
			PE.insertProductIntoList(item);
		}
		inputProducts.close();
		
		System.out.println("Total order value: -"+ PE.calculateTotalOrder());
		
	}

}
