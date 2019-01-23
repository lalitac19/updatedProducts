package com.demo.products.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.products.controller.model.Prices;
import com.demo.products.controller.service.ProductServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@SpringBootTest
public class ProductServiceImpTest {

	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	Prices price1 = new Prices();
	Prices price2 = new Prices();
	Prices price3 = new Prices();
	Prices price4 = new Prices();

	@Before
	public void setUp() throws Exception {
		price1.setNow("45.00");
		price1.setWas("");
		
		price2.setWas("45.00");
		price2.setThen2("");
		price2.setThen1("");
		price2.setNow("20.00");
		
		price3.setWas("20.00");
		price3.setThen1("");
		price3.setThen2("12.00");
		price3.setNow("10.00");
		
		price4.setNow("450.00");
		price4.setWas("700.00");
		price4.setThen1("550.00");
		price4.setThen2("");
	}

	@SuppressWarnings("deprecation")
@Test
	public void getDiscountPercentageTest() {
		int disccount = productServiceImpl.getDiscountPercentage(price1);
		int discount2 = productServiceImpl.getDiscountPercentage(price2);
		int discount3 = productServiceImpl.getDiscountPercentage(price3);
		Assert.assertEquals(0, disccount);
		Assert.assertEquals(55, discount2);
		Assert.assertEquals(50, discount3);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void displayWasNowPriceTest() {
		String message = "Was: £45, Now: £20";
		String message1 = "Was: £700, Now: £450";
		String displayed2 = productServiceImpl.displayWasNowPrice(price2);
		String displayed1 = productServiceImpl.displayWasNowPrice(price4);

	}
	
	@Test
	  public void calculateNowPriceTest() {
		  String message = "Was: £20, then £12, now: £10";
		  String displayed2 = productServiceImpl.calculateNowPrice(price3);
		  String message1 = "Was: £700, then £550, now: £450";
		  String displayed1 = productServiceImpl.calculateNowPrice(price4);
		  String message3 = "Was: £45, Now: £20";
		  String displayed3 = productServiceImpl.calculateNowPrice(price2);
		 Assert.assertEquals(message, displayed2);
		 Assert.assertEquals(message1, displayed1);
		 Assert.assertEquals(message3, displayed3);
	  }
	  
	 

}
