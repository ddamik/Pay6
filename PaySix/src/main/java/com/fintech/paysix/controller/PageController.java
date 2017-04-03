package com.fintech.paysix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	/**
	 * 	[	Page url	]
	 * 
	 * 	0. /: index
	 * 	1. /page/store: store list page
	 *	2. /page/product: product list page
	 *	3. /page/order:	product detail & order 
	 * 
	 */

	
	// 0. index
	@RequestMapping(value="/")
	public ModelAndView index(){
		return new ModelAndView("/html/index");
	}
	
	// 1. store list page
	@RequestMapping(value = "/page/store")
	public ModelAndView store_list() {
		return new ModelAndView("/html/store_list");
	}

	// 2. product list page
	@RequestMapping(value = "/page/product")
	public ModelAndView product_list() {
		return new ModelAndView("/html/product_list");
	}

	// 3. order page
	@RequestMapping(value = "/page/order")
	public ModelAndView order() {
		return new ModelAndView("/html/product_detail");
	}
}
