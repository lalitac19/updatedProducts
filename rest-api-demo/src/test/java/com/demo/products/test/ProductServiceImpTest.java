package com.demo.products.test;

import org.junit.Before;
import org.junit.Test;

import com.demo.products.controller.model.Prices;
import com.demo.products.controller.service.ProductServiceImpl;

import junit.framework.Assert;

public class ProductServiceImpTest {

	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	Prices price1 = new Prices();
	Prices price2 = new Prices();
	Prices price3 = new Prices();

	@Before
	public void setUp() throws Exception {
		price1.setNow("45.00");
		price1.setWas("");

		price2.setWas("45.00");
		price2.setNow("20.00");
		
		price3.setWas("15.00");
		price3.setNow("10.00");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getDiscountTest() {
		int disccount = productServiceImpl.getDiscountPercentage(price1);
		int discount2 = productServiceImpl.getDiscountPercentage(price2);
		int discount3 = productServiceImpl.getDiscountPercentage(price3);
		Assert.assertEquals(0, disccount);
		Assert.assertEquals(55, discount2);
		Assert.assertEquals(33, discount3);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getDiscountedProductsTest() {
		
		Assert.assertEquals(0, );
		Assert.assertEquals(55, );
		Assert.assertEquals(33, );
	}


}
