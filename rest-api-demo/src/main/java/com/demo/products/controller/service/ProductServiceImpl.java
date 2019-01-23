package com.demo.products.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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
		// discountPercentage;
		for (Product products : myProducts) {
			getDiscountPercentage(products.getPrice());
			if(!products.getPrice().getWas().equals("")) {
				
			}

		}
		return null;
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

	// productsList.setProducts(products);
	/*
	 * for (int i = 0; i < myProducts.getProducts().length; i++) { JSONObject
	 * objects = myProducts.getJSONObject(i); Iterator key = objects.keys(); while
	 * (key.hasNext()) { String k = key.next().toString(); if(k.equals("Name")) {
	 * if(objects.getString(k).equals("Camera")) { System.out.println("\nKey : " + k
	 * + "\nName : " + objects.getString(k) + ", \nValue : " +
	 * objects.getInt("Value")); } } } }
	 */

	/*
	 * public Products[] displayingObjects(Products [] products, String labelType) {
	 * List<Products> productLists = new ArrayList <Products>();
	 * 
	 * for (Products p: productLists) { String wasPrice = p.getPrice().getWas();
	 * 
	 * //checking if products has been discounted if (wasPrice != null) {
	 * p.setNowPrice(getDiscount(wasPrice, p.getPrice().getNow())); }
	 * 
	 * productLists.add(p);
	 * 
	 * Collections.sort(productLists, Collections.reverseOrder()); Products []
	 * productArray = productsList.toArray(new Products[productsList.size()]);
	 * return productArray;
	 * 
	 * 
	 * }
	 */

	/*
	 * public String getDiscount(String priceWas, String priceNow) { discounted =
	 * System.out.print(d); return null; }
	 */
	/*
	 * public void displayingColorSwatches(ColorSwatch [] colorSwatch) {
	 * //colorswatches for (ColorSwatch cs : colorSwatch) {
	 * 
	 * cs.setBasicColor((productUtils.getRGB(colorSwatches
	 * 
	 * .getBasicColor())));
	 * 
	 * } }
	 */

}
