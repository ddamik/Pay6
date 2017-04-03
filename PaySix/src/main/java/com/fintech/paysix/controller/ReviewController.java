package com.fintech.paysix.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fintech.paysix.service.ReviewService;
import com.google.gson.Gson;

@Controller
public class ReviewController {

	/**
	 * 	[ Review Controller	]
	 * 
	 *  1. insert review
	 *  2. review list
	 */

	@Autowired
	private ReviewService reviewService;
	private Gson gson = new Gson();

	@ResponseBody
	@RequestMapping(value = "/review/insert", method = RequestMethod.POST, produces = "application/json;text/plain;charset=UTF-8")
	public String insertReview(HttpServletRequest request) {
		int review_product_fk = Integer.parseInt(request.getParameter("review_product_fk"));
		int review_user_fk = Integer.parseInt(request.getParameter("review_user_fk"));		
		String review_contents = request.getParameter("review_contents");
		int store_seq = Integer.parseInt(request.getParameter("store_seq"));
		return gson.toJson(reviewService.insertReview(review_product_fk, review_user_fk, review_contents, store_seq));
	}
	
	@ResponseBody
	@RequestMapping(value = "/review/list", method = RequestMethod.GET, produces = "application/json;text/plain;charset=UTF-8")
	public String reviewList(
			@RequestParam("review_seq") int review_seq,
			@RequestParam("review_product_fk") int review_product_fk) {
		System.out.println("[ Review Seq & Product Fk ]: " + review_seq + " / " + review_product_fk);
		return gson.toJson(reviewService.reviewList(review_seq, review_product_fk));
	}	
}
