package com.demo.products.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.products.controller.model.ProductsList;
import com.demo.products.controller.service.ProductService;
import com.demo.products.controller.service.ProductServiceImpl;

@RestController
public class ProductsController {

	@Autowired
	ProductService productService;
	
	//@RequestMapping("/products")
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ProductsList testing() {
		return productService.getDiscountedProducts();
	} 

}
