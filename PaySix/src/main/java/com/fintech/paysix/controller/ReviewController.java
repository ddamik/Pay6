package com.fintech.paysix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fintech.paysix.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
}
