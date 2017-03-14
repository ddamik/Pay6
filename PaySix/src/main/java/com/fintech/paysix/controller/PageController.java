package com.fintech.paysix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	
	/*
	 * 	1. store list page
	 * 	2. product list page
	 * 	3. order page
	 * 	4. owner page 
	 */
	
	
	//	1. store list page
	@RequestMapping(value="/page/store_list")
	public ModelAndView store_list(){
		return new ModelAndView("/html/store_list");
	}	
	
	
	//	2. product list page
	@RequestMapping(value="/page/product_list")
	public ModelAndView product_list(){
		return new ModelAndView("/html/product_list");
	}
	
	
	//	3. order page
	@RequestMapping(value="/page/order")
	public ModelAndView order(){
		return new ModelAndView("/html/order");
	}
	
	
	
	//	4. owner page
	@RequestMapping(value="/page/owner")
	public ModelAndView owner(){
		return new ModelAndView("/html/owner");
	}
	
	
	
	//	5. product detail 
	@RequestMapping(value="/page/product_detail")
	public ModelAndView product_detail(){
		return new ModelAndView("/html/product_detail");
	}
	
	
	
	  /*
	    *    iamport
	    */
	   
	   @RequestMapping(value="/kakao")
	   public ModelAndView kakao(){
	      return new ModelAndView("/html/kakao/kakao_iamport");
	   }
	   
	   
	   @RequestMapping(value="/kakao/complete")
	   public ModelAndView kakao_complete(){
	      return new ModelAndView("/html/kakao/kakao_complete");
	   }
}
