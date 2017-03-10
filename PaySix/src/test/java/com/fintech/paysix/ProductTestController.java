package com.fintech.paysix;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fintech.paysix.service.ProductService;

public class ProductTestController {

	@Autowired
	private ProductService productService;
	
	@Test
	public void initProduct(){
		System.out.println("Product test");
	}
}
