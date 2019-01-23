package com.demo.products.controller.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.products.controller.model.ColorSwatch;
import com.demo.products.controller.model.Prices;
import com.demo.products.controller.model.Product;
import com.demo.products.controller.model.ProductsList;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("${url}")
	private String url;
	

	public ProductsList getProducts(String labelType) {
		RestTemplate restTemplate = new RestTemplate();
		ProductsList myProducts = restTemplate.getForObject(url, ProductsList.class);
		return getDiscountedProducts(myProducts.getProducts(), labelType);
	}

	private ProductsList getDiscountedProducts(Product[] myProducts, String labelType) {
		List<Product> productsList = new LinkedList<>();
		for (Product product : myProducts) {
			int discountPercentage = getDiscountPercentage(product.getPrice());
			if (discountPercentage == 0) {
				continue;
			}
			product.setNowPrice(product.getPrice().formatPrice(product.getPrice().getNow()));
			product.setPriceLabel(calculatePriceLabel(product.getPrice(), labelType == null? "ShowWasNow": labelType ));
			if(!product.getColorSwatches().toString().isEmpty()) {
				setHexColor(product.getColorSwatches());
			}
			product.compareTo(product);
			productsList.add(product);
		}
		productsList.sort(Collections.reverseOrder());

		ProductsList result = new ProductsList();
		result.setProducts(productsList.toArray(new Product[productsList.size()]));
		return result;
	}
	
	public void setHexColor(ColorSwatch [] colorSwatches) {
		for(ColorSwatch colors : colorSwatches) {
			colors.setBasicColor(colors.colorToHex(colors.getBasicColor()));
		}
	}

	public String calculatePriceLabel(Prices price, String labelType) {
		String statement = "";
		switch (labelType) {
		case "ShowWasThenNow": 
			statement = calculateNowPrice(price);
			break;
		case "ShowPercDscount":
			statement= getDiscountPercentage(price) + "% off - " + price.formatPrice(price.getNow());
			break;
		default: 
			statement = displayWasNowPrice(price);
		}
		return statement;
	}

	public String displayWasNowPrice(Prices price) {
		return "Was: " + price.formatPrice(price.getWas()) + ", Now: " + price.formatPrice(price.getNow());
	}

	public String calculateNowPrice(Prices price) {
		String statement = "";
		if (!price.getThen2().equals("")) {
			statement = "Was: " + price.formatPrice(price.getWas()) 
			+ ", then " + price.formatPrice(price.getThen2())
			+ ", now: " + price.formatPrice(price.getNow());
		} else if(!price.getThen1().equals("")) {
			statement = "Was: " + price.formatPrice(price.getWas()) 
			+ ", then " + price.formatPrice(price.getThen1())
			+ ", now: " + price.formatPrice(price.getNow());
		} else {
		statement = displayWasNowPrice(price);
		}
		return statement;
	}

	public int getDiscountPercentage(Prices prices) {
		int discount = 0;
		if (!prices.getWas().equals("") && !prices.getNow().equals("")) {
			float nowFloat = Float.valueOf(prices.getNow());
			float wasFloat = Float.valueOf(prices.getWas());
			discount = (int) (((wasFloat - nowFloat)/wasFloat)*100);
		}
		return discount;
	}
}
