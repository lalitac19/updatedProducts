package com.demo.products.controller.service;

import com.demo.products.controller.model.ProductsList;

public interface ProductService {
	ProductsList getProducts(String labelType);
}