package com.fintech.paysix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	/*
	 * 1. store list page 2. product list page 3. order page 4. owner page
	 */

	// 1. store list page
	@RequestMapping(value = "/page/store_list")
	public ModelAndView store_list() {
		return new ModelAndView("/html/store_list");
	}

	// 2. product list page
	@RequestMapping(value = "/page/product_list")
	public ModelAndView product_list() {
		return new ModelAndView("/html/product_list");
	}

	// 3. order page
	@RequestMapping(value = "/page/order")
	public ModelAndView order() {
		return new ModelAndView("/html/order");
	}

	// 5. product detail
	@RequestMapping(value = "/page/product_detail")
	public ModelAndView product_detail() {
		return new ModelAndView("/html/product_detail");
	}

	// 6. product detail
	@RequestMapping(value = "/page/header")
	public ModelAndView header() {
		return new ModelAndView("/html/header");
	}

	/*
	 * 1. onwer index
	 * 
	 * 
	 */

	// 1. index
	@RequestMapping(value = "/page/owner/index")
	public ModelAndView owner_index() {
		return new ModelAndView("/html/owner/owner_index");
	}

	// 2. owner page
	@RequestMapping(value = "/page/owner/order_list")
	public ModelAndView owner_order_list() {
		return new ModelAndView("/html/owner/order_list");
	}

	// 3. owner page
	@RequestMapping(value = "/page/owner/chart")
	public ModelAndView owner_data_chart() {
		return new ModelAndView("/html/owner/chart");
	}	
	
	
	
	
	
	/*
	 * iamport
	 */

	@RequestMapping(value = "/kakao")
	public ModelAndView kakao() {
		return new ModelAndView("/html/kakao/kakao_iamport");
	}

	@RequestMapping(value = "/kakao/complete")
	public ModelAndView kakao_complete() {
		return new ModelAndView("/html/kakao/kakao_complete");
	}

	/*
	 * Temp Page
	 */
	// 5. product detail
	@RequestMapping(value = "/page/btn_back")
	public ModelAndView btn_back() {
		return new ModelAndView("/html/btn_back");
	}

	// 5. product detail
	@RequestMapping(value = "/page/product_detail2")
	public ModelAndView product_detail2() {
		return new ModelAndView("/html/product_detail1");
	}

	@RequestMapping(value = "/page/store_list2")
	public ModelAndView store_list2() {
		return new ModelAndView("/html/store_list2");
	}
}
