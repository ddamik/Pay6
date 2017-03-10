package com.fintech.paysix.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

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
	
	
	/*
	 * 	1. popular_menu, top3
	 */
	
	
	//	1. popular_menu
	@ResponseBody
	@RequestMapping(value="/product/popular_list", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String popular_menu(
			@RequestParam("sid") String sid) throws SQLException {
		return gson.toJson(productService.popular_list(sid));
	}
	
	
	
	//	2. menu
	@ResponseBody
	@RequestMapping(value="/product/all_list", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String menu_list(
			@RequestParam("sid") String sid) throws SQLException {
		return gson.toJson(productService.all_list(sid));
	}
	

	
	//	3. detail
	@ResponseBody
	@RequestMapping(value="/product/detail", method=RequestMethod.GET, produces="application/json;text/plain;charset=UTF-8")
	public String detail(
			@RequestParam("pid") String pid) throws SQLException {
		return gson.toJson(productService.detail(pid));
	}
}
