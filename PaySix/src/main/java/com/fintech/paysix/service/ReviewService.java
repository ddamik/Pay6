package com.fintech.paysix.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.paysix.dao.ReviewDao;
import com.fintech.paysix.vo.ReviewVO;

@Service
public class ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private ProductService productService;
	/**
	 * 
	 */

	 
	//	1. insertReview
	public int insertReview(int review_product_fk, int review_user_fk, String review_contents, int store_seq){
		ReviewVO review = new ReviewVO();
		review.setReview_product_fk(review_product_fk);
		review.setReview_user_fk(review_user_fk);
		review.setReview_contents(review_contents);
		
		//	update review cnt
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("product_store_fk", String.valueOf(store_seq));
		map.put("product_seq", String.valueOf(review_product_fk));
		productService.updateReviewCnt(map);
		
		return reviewDao.insertReview(review);
	}
	
	//	2. review list
	public List<ReviewVO> reviewList(int review_seq, int review_product_fk){
		ReviewVO review = new ReviewVO();
		review.setReview_seq(review_seq);
		review.setReview_product_fk(review_product_fk);
		return reviewDao.reviewList(review);
	}
}
