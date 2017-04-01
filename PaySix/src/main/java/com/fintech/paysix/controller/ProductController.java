package com.fintech.paysix.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fintech.paysix.service.ProductService;
import com.google.gson.Gson;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	private Gson gson = new Gson();
	
	
	/**
	 * 	[	Product	]
	 * 
	 * 	1. product list
	 * 	2. product detail[order]
	 */
	
	//	1. product list
	@ResponseBody
	@RequestMapping(value="/product/list", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String productList(
			@RequestParam("store_seq") int store_seq) throws SQLException {		
		return gson.toJson(productService.productList(store_seq));
	}
	
	//	2. product detail[order]
	@ResponseBody
	@RequestMapping(value="/product/detail", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")	
	public String productDetail(
			@RequestParam("store_seq") int store_seq,
			@RequestParam("product_seq") int product_seq) throws SQLException {		
		return gson.toJson(productService.productDetail(store_seq, product_seq));
	}
	
	
	
	
	
	/**
	 * 
	 * 	Create Random Product 
	 * @param product_store_fk
	 * @return
	 * @throws SQLException
	 */
	@ResponseBody
	@RequestMapping(value="/product/create", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String productCreate(
			@RequestParam("product_store_fk") int product_store_fk) throws SQLException {		
		return gson.toJson(productService.createProduct(product_store_fk));
	}
}
