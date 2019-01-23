package com.demo.products.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.products.controller.model.Prices;
import com.demo.products.controller.service.ProductServiceImpl;

import junit.framework.Assert;

@SpringBootTest
public class PriceTests {
	
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
		
		price3.setWas("15.00");
		price3.setThen1("");
		price3.setThen2("12.50");
		price3.setNow("10.00");
		
		price4.setNow("9.99");
		price4.setWas("20.00");
		price4.setThen1("15.00");
		price4.setThen2("");
	}
		
	@SuppressWarnings("deprecation")
	@Test
	public void formatPriceTest() throws Exception {
		
		String displayed = price4.formatPrice(price4.getNow());
		String displayed2 = price2.formatPrice(price2.getNow());
		Assert.assertEquals("£20", displayed2);
		Assert.assertEquals("£9.99", displayed);
	}


}
