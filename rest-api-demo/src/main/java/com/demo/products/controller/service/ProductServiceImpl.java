package com.demo.products.controller.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.products.controller.model.ProductsList;

@Service
public class ProductServiceImpl implements ProductService {


	/*
	 * double priceReduction; for(int x = 0; x <= discountedProducts.size(); x++) {
	 * if (discountedProducts.) { discountedProducts.add(arg0); } } return Colle
	 ctions.sort(product.)); }*/
	

	public ProductsList getDiscountedProducts() {
		RestTemplate restTemplate = new RestTemplate();
		ProductsList myProducts = restTemplate.getForObject(
		  "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma",
		  ProductsList.class);
		  
		System.out.println("sIXE >> "+ myProducts);
	
		/*
		 * Products myProducts = getProducts.getForObject(
		 * "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma",
		 * Products.class);
		 * 
		 * List<Product> employees = myProducts.getProduct();
		 */
		
		
		
		// productsList.setProducts(products);
		/*
		 * for (int i = 0; i < myProducts.getProducts().length; i++) { JSONObject
		 * objects = myProducts.getJSONObject(i); Iterator key = objects.keys(); while
		 * (key.hasNext()) { String k = key.next().toString(); if(k.equals("Name")) {
		 * if(objects.getString(k).equals("Camera")) { System.out.println("\nKey : " + k
		 * + "\nName : " + objects.getString(k) + ", \nValue : " +
		 * objects.getInt("Value")); } } } }
		 */

		return myProducts;
	}

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
	 * //checking if colorSwatches is not empty if (p.getColorSwatches() != null) {
	 * 
	 * displayingColorSwatches(p.getColorSwatches());
	 * 
	 * }
	 * 
	 * 
	 * }
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

	/*
	 * public String formatPrice(String currentPrice) { String num = ""; if
	 * (Double.parseDouble(currentPrice) < 10 ) { num =
	 * Double.parseDouble(currentPrice); } return currentPrice;
	 * 
	 * }
	 */

}
