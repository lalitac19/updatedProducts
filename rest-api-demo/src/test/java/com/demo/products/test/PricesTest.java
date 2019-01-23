package com.demo.products.test;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.demo.products.controller.model.Prices;
import com.demo.products.controller.model.Product;

public class PricesTest {

	Prices price; 
	Product product; 
	
	@Before
	public void setUp() throws Exception {
		price = new Prices();
		product = new Product();
		
	}
	
	@Test
	public void formatPriceTest() {
	
		//int newPrices = 0;
		System.out.println(price.getNow().toString());
		//assertEquals("£ ", price.getCurrency());
				
				//formatPrice(price.getNow()));
		
	}
	
	
	
}
