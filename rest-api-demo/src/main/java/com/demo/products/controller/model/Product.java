package com.demo.products.controller.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Comparable{

	private String productId;
	private String title;
	private Prices price;
	private ColorSwatch[] colorSwatches;
	private String nowPrice = "";
	private String priceLabel = "";

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ColorSwatch[] getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(ColorSwatch[] colorSwatches) {
		this.colorSwatches = colorSwatches;
	}

	public String getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getPriceLabel() {
		return priceLabel;
	}

	public void setPriceLabel(String priceLabel) {
		this.priceLabel = priceLabel;
	}

	public Prices getPrice() {
		return price;
	}

	public void setPrice(Prices price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", title=" + title + ", colorSwatches="
				+ Arrays.toString(colorSwatches) + ", nowPrice=" + nowPrice + ", priceLabel=" + priceLabel + ", price="
				+ price + "]";
	}

	
@Override
public int compareTo(Object o) {

	if (o != null && o instanceof Product) {
		Product p = (Product) o;
		Double pnow = new Double(p.getPrice().getNow());
		Double now = new Double(price.getNow());
		double compare = now - pnow;

		if (compare == 0) {
			return 0;
		} else if (compare > 0) {
			return 1;
		} else {
			return -1;
		}
	}
	return 0;
}
}
