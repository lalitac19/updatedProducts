package com.demo.products.controller.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
	
	private String productId;
	private String title;
	private Prices price;
	private ColorSwatch[] colorSwatches;
	private String nowPrice="";
	private String priceLabel="";
	//@JsonProperty(access = Access.WRITE_ONLY)
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
	
	

}
