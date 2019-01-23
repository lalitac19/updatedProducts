package com.demo.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.products.controller.model.ProductsList;
import com.demo.products.controller.service.ProductService;

@RestController
public class ProductsController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ProductsList testing(
			@RequestParam(value="labelType", required=false) 
			String labelType ) {
		return productService.getProducts(labelType);
	} 

}
