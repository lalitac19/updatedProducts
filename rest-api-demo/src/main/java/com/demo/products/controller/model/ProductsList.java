package com.demo.products.controller.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductsList {

	@JsonProperty
	private Product products[];

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product products[]) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductsList =" + Arrays.toString(getProducts()) ;
	}
	
}
